import java.util.*;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        //A date regex
        String dateRegex1 = "(19|20)\\d{2}" + //year
                "[- /.](0[\\d]|1[012])" + //month
                "[- /.](0[\\d]|[12][\\d]|3[01])"; //day
        String dateRegex2 = "(0[\\d]|[12][\\d]|3[01])" + //day
                "[- /.](0[\\d]|1[012])" + //month
                "[- /.](19|20)\\d{2}"; //year
        if (date.matches(dateRegex1) || date.matches(dateRegex2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}