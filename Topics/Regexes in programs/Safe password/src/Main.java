import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String password = scanner.nextLine();
        //A password is considered safe if it contains at least 12 characters,
        // contains at least one digit, and contains at least one uppercase letter
        //and one lowercase letter.
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}$";
        if(password.matches(passwordRegex)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}