import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
        //Your task is to determine whether any of the words from the second line contain this sequence of letters.
        // Count only the words that do not start or end with your search term.
        // If such a word is present in the line, output "YES", otherwise output "NO".
        // The word can contain only the letters of the English alphabet.
        // Ignore the case while searching for matches.
        // The search term can be of any length.
        Pattern pattern = Pattern.compile("\\B" + part + "\\B", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean found = matcher.find();
        System.out.println(found ? "YES" : "NO");
    }
}