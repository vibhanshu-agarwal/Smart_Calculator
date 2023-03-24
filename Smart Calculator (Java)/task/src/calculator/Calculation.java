package calculator;

import java.util.Deque;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation extends Expression{
    /**
     * Collapse multi adjacent operators string.
     * e.g. 1 +++ 2 * 3 -- 4 into 1+2*3+4
     *
     * @param input the input
     * @return the string
     */
    static String collapseMultiAdjacentOperators(String input) {
        Pattern pattern = Pattern.compile(Validator.OPERATORS_REGEX);
        Matcher matcher = pattern.matcher(input);

        StringBuilder newInput = new StringBuilder();

        while (matcher.find()) {
            String operator = matcher.group().strip();
            //if the operator is "-" and there is an even number of operators in the list
            //change it to a single "+"
            if (operator.startsWith("-") && operator.length() % 2 == 0) {
                operator = "+";
            }
            //if the operator is "-" and there is an odd number of operators in the list
            //change it to a single "-"
            if (operator.startsWith("-") && operator.length() % 2 != 0) {
                operator = "-";
            }
            //Collapse multiple + operators to a single +
            if (operator.startsWith("+") && operator.length() > 1) {
                operator = "+";
            }

            matcher.appendReplacement(newInput, operator);
        }
        matcher.appendTail(newInput);

        if(Main.DEBUG) {
            System.out.println("New input: " + newInput);
        }
        return newInput.toString();
    }

    /**
     * Process numbers and variables,
     * if the string is a variable,
     * get the value from the variable map
     * and add them to the postfix expression.
     *
     * @param postfixExpression the postfix expression
     * @param s                 the s
     */
    static void processNumbersAndVariables(StringBuilder postfixExpression, String s) {
        postfixExpression.append(
                hasVariable(s) ?
                        getVariableValue(s) : s).append(" ");
    }

    /**
     * Process right parenthesis.
     * Pop all the operators from the stack
     * until you find a left parenthesis
     * and add them to the result.
     * Discard the left parenthesis.
     *
     * @param postfixExpression the postfix expression
     * @param operators         the operators
     */
    static void processRightParenthesis(StringBuilder postfixExpression, Deque<String> operators) {
        while (Objects.nonNull(operators.peekLast()) && !operators.peekLast().equals("(")) {
            postfixExpression.append(operators.pollLast()).append(" ");
        }
        //Discard the left parenthesis
        operators.pollLast();
    }

    /**
     * Process operators.
     *
     * <p>
     *     If the current operator has a lower or equal precedence than the operator at the top of the stack,
     *     pop all the operators from the stack and add them to the result
     *     until you find an operator that has a lower precedence than the current operator
     *     or a left parenthesis on the top of the stack;
     *     then push the current operator onto the stack.
     *     If the current operator has a higher precedence than the operator at the top of the stack,
     *     push the current operator onto the stack.
     *     If the stack is empty or contains a left parenthesis on top,
     *     push the operator onto the stack.
     *     Otherwise, pop all the operators from the stack
     *     and add them to the result until you find an operator
     *     that has a lower precedence than the current operator
     *     or a left parenthesis on the top of the stack;
     *     then push the current operator onto the stack.
     *  </p>
     *
     * @param postfixExpression the postfix expression
     * @param operators         the operators
     * @param s                 the s
     */
    static void processOperators(StringBuilder postfixExpression, Deque<String> operators, String s) {
        if (operators.isEmpty()) {
            operators.add(s);
        } else if (operators.peekLast().equals("(")) {
            operators.add(s);
        } else {
            //If the current operator has a higher precedence than the operator at the top of the stack,
            //add it to the stack
            if (getOperatorPrecedence(s) > getOperatorPrecedence(Objects.requireNonNull(operators.peekLast()))) {
                operators.add(s);
            } else {
                //If the current operator has a lower or equal precedence than the operator at the top of the stack,
                //pop all the operators from the stack and add them to the result
                while (Objects.nonNull(operators.peekLast())
                        && getOperatorPrecedence(s) <= getOperatorPrecedence(Objects.requireNonNull(operators.peekLast()))) {
                    postfixExpression.append(operators.pollLast()).append(" ");
                }
                //Add the incoming operator to the stack
                operators.add(s);
            }
        }
    }

    /**
     * Process remaining operators.
     * Pop all the remaining operators from the stack and add them to the result
     * after the input has been processed.
     *
     * @param postfixExpression the postfix expression
     * @param operators         the operators
     */
    static void processRemainingOperators(StringBuilder postfixExpression, Deque<String> operators) {
        //Pop all the operators from the stack and add them to the result
        while (!operators.isEmpty()) {
            postfixExpression.append(operators.pollLast()).append(" ");
        }
    }

    @Override
    public void addVariable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change the body of generated methods, choose Tools | Templates.
    }
}
