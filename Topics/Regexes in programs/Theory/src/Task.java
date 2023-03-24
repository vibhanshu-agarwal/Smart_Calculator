// You can experiment here, it won’t be checked

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {
        // put your code here
        String text = "We use Java to write modern applications";
        Pattern pattern = Pattern.compile(".*[Jj]ava.*"); // regex to match "java" or "Java" in a text
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());

        System.out.println(Pattern.matches(".*[Jj]ava.*", "We use Java to write modern applications"));

        pattern = Pattern.compile(".*java.*", Pattern.CASE_INSENSITIVE);
        text = "We use Java to write modern applications";

        matcher = pattern.matcher(text);

        System.out.println(matcher.matches()); // true

        System.out.println(Pattern.matches("(?is).*java.*", "\n\nJAVA\n\n")); // true

        text = "Regex is a powerful tool for programmers";

        pattern = Pattern.compile("tool");
        matcher = pattern.matcher(text);

        System.out.println(matcher.matches()); // false, the whole string does not match the pattern
        System.out.println(matcher.find()); // true, there is a substring that matches the pattern

        pattern = Pattern.compile("^tool$");
        matcher = pattern.matcher(text);

        System.out.println(matcher.matches()); // false
        System.out.println(matcher.find());   // false

        text = "Regex is a powerful tool for programmers";
        matcher = Pattern.compile("tool").matcher(text);

        matcher.region(10, 20); // start index = 10, end index = 20
        System.out.println(matcher.find()); // false
        matcher.region(20, 30); // start index = 20, end index = 30
        System.out.println(matcher.find()); // true
    }
}
