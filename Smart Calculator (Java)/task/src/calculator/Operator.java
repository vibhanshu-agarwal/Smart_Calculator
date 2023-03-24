package calculator;

public enum Operator {
    // +, - *, / , ^
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    POWER("^");

    private final String operator;

    private final int precedence;

    Operator(String operator) {
        this.operator = operator;
        switch (operator) {
            case "+" -> this.precedence = 1;
            case "-" -> this.precedence = 1;
            case "*" -> this.precedence = 2;
            case "/" -> this.precedence = 2;
            case "^" -> this.precedence = 3;
            default -> this.precedence = 0;
        }
    }



    public String getOperator() {
        return operator;
    }

    public int getPrecedence() {
        return precedence;
    }
}
