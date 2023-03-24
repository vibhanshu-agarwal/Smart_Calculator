package calculator;

public class ExpressionFactory {

    public static final String BAD_VARIABLE_REGEX = "^\\s*[a-zA-Z\\d]+$";
    public static final String ASSIGNMENT_OPERATOR = "=";

    private ExpressionFactory() {
    }

    /**
     * Gets expression.
     *
     * @param input the input
     * @return the expression
     */
    public static Expression getExpression(String input) {
        if (input.contains(ASSIGNMENT_OPERATOR)) {
            return new Assignment().withInput(input).withType(Expression.Type.ASSIGNMENT);
        } else if (input.matches(BAD_VARIABLE_REGEX)) { //We intentionally include invalid identifiers here, to validate later.
            return new Variable().withInput(input).withType(Expression.Type.VARIABLE);
        } else {
            return new Calculation().withInput(input).withType(Expression.Type.CALCULATION);
        }
    }
}
