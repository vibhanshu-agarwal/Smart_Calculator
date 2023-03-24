package calculator;

import java.util.Scanner;

/**
 * The type calculator.Main.
 */
public class Main {

    public static final boolean DEBUG = false;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String input;

        do {
            input = scanner.nextLine();

            //Check for invalid command(s)
            if (!CommandValidator.getInstance().validate(input)) {
                PrintHelper.printUnknownCommand();
            }
            input = input.strip();
            switch (input) {
                case "/help" -> PrintHelper.printHelp(input);
                case "/exit" -> PrintHelper.printExitMessage();
                case "" -> {
                    //break out of switch statement
                }
                default -> {
                    if(DEBUG)
                    {
                        System.out.println("***" + input + "***");
                    }

                    Expression expression = ExpressionFactory.getExpression(input);
                    if (expression.getType() == Expression.Type.ASSIGNMENT) {
                        performAssignment(input,
                                expression);
                    } else if (expression.getType() == Expression.Type.VARIABLE) {
                        printVariable(input
                        );
                    } else if (expression.getType() == Expression.Type.CALCULATION) {
                        performCalculation(input);
                    }
                }

            }

        } while (!input.equals("/exit"));

    }

    private static void performAssignment(String input, Expression expression) {
        //Validate the assignment expression and print if there are any errors with the assignment
        //such as illegal identifiers or unassigned variables
        if(AssignmentValidator.getInstance().validate(input)) {
            //If a valid assignment, add the variable to the variable map
            expression.addVariable();
        }
    }

    private static void printVariable(String input) {
        //If the variable map contains the variable, then display its value
        if(Expression.hasVariable(input.strip())) {
            //If a valid variable, then display its value
            PrintHelper.printVariableValue(Expression.getVariableValue(input.strip()));
        }
        else {
            //If an invalid variable, then print "Unknown variable"
            if(!VariableValidator.getInstance().validate(input))
            {
                PrintHelper.printInvalidIdentifier();
            }
            else {
                PrintHelper.printUnknownVariable();
            }
        }
    }

    private static void performCalculation(String input) {
        //Validate the calculation expression and print if there are any errors with the calculation
        //such as illegal identifiers or unassigned variables or unsupported operators
        if(CalculationInputValidator.getInstance().validate(input)) {
            //If a valid calculation, then perform the calculation and display the result
            String result = Calculator.convertExpressionToPostfix(input);
            if(DEBUG) {
                System.out.println("Postfix: " + result);
            }
            PrintHelper.printResult(Calculator.calculatePostfix(result));
        }
    }

}
