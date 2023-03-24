import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]{" + size + "}\\b");
        Matcher matcher = pattern.matcher(line);
        boolean found = matcher.find();
        System.out.println(found ? "YES" : "NO");

    }
}