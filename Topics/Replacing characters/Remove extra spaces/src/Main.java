import java.util.Scanner;

class RemoveExtraSpacesProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        //Remove all extra spaces from the text using regex
        text = text.replaceAll("\\s+", " ");
        System.out.println(text);
    }
}