package calculator;

public class CalculationInputValidator implements Validator {
    private static final String MULTI_OPERATORS_REGEX = ".*[*/]{2,}.*";
    //make this a singleton
    private static CalculationInputValidator instance;

    private CalculationInputValidator() {

    }

    public static CalculationInputValidator getInstance() {
        if (instance == null) {
            instance = new CalculationInputValidator();
        }
        return instance;
    }

    @Override
    public boolean validate(String input) {
        //Check if the input contains any invalid characters,
        //i.e. not numbers, latin alphabets, spaces, operators
        if (!input.strip().matches(INVALID_CALCULATION_REGEX)) {
            PrintHelper.printInvalidExpression();
            return false;
        }

        //Match the number of left and right parentheses
        //if they don't match, then print invalid expression
        if (input.chars().filter(ch -> ch == '(').count() != input.chars().filter(ch -> ch == ')').count()) {
            PrintHelper.printInvalidExpression();
            return false;
        }
        //If there are more than one * or / operators adjacent to each other, print invalid expression
        if (input.matches(MULTI_OPERATORS_REGEX)) {
            PrintHelper.printInvalidExpression();
            return false;
        }
        //Check if there are any invalid variables in the input
        if (input.matches(".*[a-zA-Z]+.*")) {

            for (char c : input.strip().toCharArray()) {
                String s = String.valueOf(c);
                if (s.strip().equals("")) continue;
                if (!s.strip().matches(VARIABLE_REGEX) && !s.strip().matches(NUMBER_REGEX) && !s.strip().matches("\\s*[+-/*^()]+\\s*")) {
                    PrintHelper.printInvalidExpression();
                    return false;
                } else if (s.strip().matches(VARIABLE_REGEX) && !Expression.hasVariable(s.strip())) {
                    PrintHelper.printUnknownVariable();
                    return false;
                }
            }
        }
        return true;
    }
}
