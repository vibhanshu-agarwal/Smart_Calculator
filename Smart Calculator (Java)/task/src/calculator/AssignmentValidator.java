package calculator;

public class AssignmentValidator implements Validator {

    //Make this a singleton
    private static AssignmentValidator instance;

    private AssignmentValidator() {

    }

    public static AssignmentValidator getInstance() {
        if (instance == null) {
            instance = new AssignmentValidator();
        }
        return instance;
    }

    public boolean validate(String input) {
        //Regex to match more than one "=" operators in input
        if (input.matches(MULTI_ASSIGNMENT_OPERATORS_REGEX)) {
            PrintHelper.printInvalidAssignment();
            return false;
        }
        //Check for illegal characters in the variable identifier on the left side of the assignment
        if (!input.split("=")[0].strip().matches(VARIABLE_REGEX)) {
            PrintHelper.printInvalidIdentifier();
            return false;
        }
        //Check if the right-hand side of the assignment contains any characters other that latin alphabets,
        // numbers, spaces and operators
        if (!input.split("=")[1].strip().matches(INVALID_ASSIGNMENT_CHARS_REGEX)) {
            PrintHelper.printInvalidAssignment();
            return false;
        }
        //Check if the right-hand side of the assignment contains any invalid variables
        if (input.split("=")[1].strip().matches(".*[a-zA-Z]+.*")) {
            String[] rightHandSide = input.split("=")[1].strip().split("\\s+");
            for (String s : rightHandSide) {
                if (!s.strip().matches(VARIABLE_REGEX)) {
                    PrintHelper.printInvalidAssignment();
                    return false;
                }
                else if(s.strip().matches(VARIABLE_REGEX) && !Expression.hasVariable(s.strip())) {
                    PrintHelper.printUnknownVariable();
                    return false;
                }
            }
        }
        return true;
    }
}
