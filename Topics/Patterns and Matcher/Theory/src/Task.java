// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    // put your code here
    String digitRegex = "\\d"; // a regex to match a digit

    String str = "ab73c80abc9"; // a string consisting of letters and digits

    String result1 = str.replaceAll(digitRegex, "#"); // it replaces each digit with #

    System.out.println(result1); // "ab##c##abc#"

    String result2 = str.replaceFirst(digitRegex, "#"); // it replaces only the first digit with #

    System.out.println(result2); // "ab#3c80abc9"
  }
}
