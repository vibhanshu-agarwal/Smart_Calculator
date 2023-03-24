package calculator;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private Calculator() {
    }

    public static String convertExpressionToPostfix(String input) {

        //Collapse all multi adjacent operators into one
        //This also removes whitespaces from the input
        input = Calculation.collapseMultiAdjacentOperators(input);

        StringBuilder postfixExpression = new StringBuilder();
        Deque<String> operators = new ArrayDeque<>();

        Pattern pattern = Pattern.compile("\\d+|[a-zA-Z]+|\\(|\\)|[+\\-*/^]");
        Matcher matcher = pattern.matcher(input);

        while(matcher.find())
        {
            String token = matcher.group();
            if (token.matches(Validator.NUMBERS_AND_VARIABLE_REGEX)) {
                Calculation.processNumbersAndVariables(postfixExpression,
                        token);
            } //If the current character is a left parenthesis, add it to the stack
            else if (token.equals("(")) {
                operators.add(token);
            }//If the current character is a right parenthesis, pop all the operators from the stack
            //until you find a left parenthesis
            else if (token.equals(")")) {
                Calculation.processRightParenthesis(postfixExpression,
                        operators);
            } else if (token.matches(Validator.OPERATORS_REGEX)) {
                Calculation.processOperators(postfixExpression,
                        operators,
                        token);
            }
        }

        Calculation.processRemainingOperators(postfixExpression,
                operators);

        return postfixExpression.toString();
    }


    /**
     * Calculate postfix string.
     * <p>
     * Pop first two operands from numbers and first operator from operators
     * perform operations and push a result back to numbers
     * repeat until operators are empty
     * </p>
     *
     * @param postfixExpression the postfix expression
     * @return the string
     */
    public static String calculatePostfix(String postfixExpression) {
        //pop first two operands from numbers and first operator from operators
        //perform operations and push a result back to numbers
        //repeat until operators are empty
        Deque<String> numbers = new ArrayDeque<>();

        //Split the input based on spaces
        String[] input = postfixExpression.split("\\s+");
        for (String s : input) {
            if (s.matches(Validator.NUMBER_REGEX)) {
                numbers.push(s);
                if(Main.DEBUG)
                {
                    System.out.println("Pushed: " + s);
                    System.out.println("Numbers: " + numbers);
                }
            } else if (s.matches(Validator.OPERATORS_REGEX)) {
                if (!numbers.isEmpty()) {
                    BigInteger operand2 = new BigInteger(numbers.pop());
                    BigInteger operand1 = new BigInteger(Objects.requireNonNull(numbers.pop()));
                    if(Main.DEBUG)
                    {
                        System.out.println("Operand1: " + operand1);
                        System.out.println("Operand2: " + operand2);
                    }
                    String result = "";
                    switch (s) {
                        case "+" -> result = String.valueOf(operand1.add(operand2));
                        case "-" -> result = String.valueOf(operand1.subtract(operand2));
                        case "*" -> result = String.valueOf(operand1.multiply(operand2));
                        case "/" -> result = String.valueOf(operand1.divide(operand2));
                        case "^" -> result = operand1.pow(operand2.intValue()).toString();

                        default -> {
                            System.out.println("Invalid operator");
                            return "0";
                        }
                    }
                    numbers.push(result);
                }
            }
        }

        if (Main.DEBUG) {
            System.out.println(numbers);
        }
        //pop the last number from numbers
        return numbers.pop();
    }


}
