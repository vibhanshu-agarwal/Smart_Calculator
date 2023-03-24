package calculator;

public class PrintHelper {
    private PrintHelper() {
    }

    public static void printHelp(String input) {
        if (input.equals("/help")) {
            System.out.println("1. The program supports both unary and binary minus operators.");
            System.out.println("2. The program supports addition,subtraction, multiplication, division, and power operations.");
            System.out.println("3. The program collapses multiple adjacent operators of the same type.");
            System.out.println("4. For an even number of minus adjacent operators it behaves as a plus.");
            System.out.println("5. Now the calculator supports variables. A variable is a string of Latin letters.");
            System.out.println("6. The expressions can be grouped by parentheses. When parentheses are present the calculator evaluates the expression inside the parentheses first.");
            System.out.println("7. The calculator also calculates the result taking into account operator precedence.");
        }
    }

    public static void printUnknownCommand() {
        System.out.println("Unknown command");
    }

    public static void printUnknownVariable() {
        System.out.println("Unknown variable");
    }

    public static void printInvalidIdentifier() {
        System.out.println("Invalid identifier");
    }

    public static void printInvalidAssignment() {
        System.out.println("Invalid assignment");
    }


    public static void printExitMessage() {
        System.out.println("Bye!");
    }


    public static void printVariableValue(String input) {
        System.out.println(input.strip());
    }

    public static void printInvalidExpression() {
        System.out.println("Invalid expression");
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
