package calculator;

public interface Validator {
//    String ASSIGNMENT_REGEX = "([a-zA-Z]+)\\s*=\\s*([a-zA-Z]*)(\\d*)";
    String VARIABLE_REGEX = "^[a-zA-Z]+$";
//    String CALCULATION_REGEX = "([a-zA-Z]*)(\\d*)\\s*([+\\-*/])\\s*([a-zA-Z]*)(\\d*)";

    String INVALID_CALCULATION_REGEX = "^[a-zA-Z0-9\\s+\\-*/()]+$";
    String MULTI_ASSIGNMENT_OPERATORS_REGEX = ".*=.*=.*";

    String INVALID_ASSIGNMENT_CHARS_REGEX = "^[a-zA-Z0-9\\s+\\-*/]+$";

    String NUMBER_REGEX = "(-)*\\d+";
    String NUMBERS_AND_VARIABLE_REGEX = "^[a-zA-Z\\d]+$";
    String OPERATORS_REGEX = "\\s*[+\\-/*^]+\\s*";

    boolean validate(String input);
}
