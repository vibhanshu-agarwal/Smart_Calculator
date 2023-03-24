import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        printOutput(part, line);

//        String part = "ing";
//        String line = "Java is the most popular programming language";
//        printOutput(part, line);
//
//        part = "press";
//        line = "Regular expressions is hard to read, isn't it?";
//        printOutput(part, line);
//
//        part = "ho";
//        line = "Wow! How awesome is that!";
//        printOutput(part, line);
//
//        part = "ONE";
//        line = "ponep,onep!";
//        printOutput(part, line);
    }

    public static void printOutput(String part, String line) {
        //Your task is to determine if any of the words of this text start or end with the sequence specified in the first line of the input.
        //If there is, you should output "YES", otherwise output "NO".
        // A word can only contain symbols of the English alphabet.
        // You should ignore the case while searching for matches.
        // Step 3: Construct the regular expression pattern
        String patternString = String.format("\\b(?:%s\\w*|\\w*%s)\\b", part, part);
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);

        System.out.println(matcher.find()? "YES" : "NO");
    }
}