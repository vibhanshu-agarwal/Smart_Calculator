package calculator;

public class VariableValidator implements Validator {

    //Make this a singleton
    private static VariableValidator instance;

    private VariableValidator() {

    }

    public static VariableValidator getInstance() {
        if (instance == null) {
            instance = new VariableValidator();
        }
        return instance;
    }

    public boolean validate(String variable) {
        return variable.strip().matches(VARIABLE_REGEX);
    }

}
