package calculator;

import java.util.HashMap;
import java.util.Map;

public abstract class Expression {
    public static int getOperatorPrecedence(String operator) {
        //Determine the precedence of the operator
        //based on Operator enum
        return switch (operator) {
            case "+" -> Operator.PLUS.getPrecedence();
            case "-" -> Operator.MINUS.getPrecedence();
            case "*" -> Operator.MULTIPLY.getPrecedence();
            case "/" -> Operator.DIVIDE.getPrecedence();
            case "^" -> Operator.POWER.getPrecedence();
            default -> 0;
        };
    }
    //Make this class a singleton

    public enum Type {ASSIGNMENT, VARIABLE, CALCULATION}
    private String input;

    private Type type;

    private static Map<String, String> variablesMap = new HashMap<>();

    public Expression withInput(String input) {
        this.input = input;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Expression withType(Type expression) {
        this.type = expression;
        return this;
    }

    public void addVariable() {
        throw new UnsupportedOperationException();
    }

    public static boolean hasVariable(String varName) {
        return variablesMap.containsKey(varName);
    }

    public static Map<String, String> getVariablesMap() {
        return variablesMap;
    }

    public static String getVariableValue(String varName) {
        return variablesMap.get(varName);
    }

}
