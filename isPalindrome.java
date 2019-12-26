import java.util.Scanner;

public class isPalindrome {

    // take string and return string without any non-letter characters
    static String doStripped (String str) {
        int i;
        str = str.toLowerCase();
        String stripped = "";
        for (i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                stripped = stripped + str.charAt(i);
            }
        }
        return stripped;
    }

    // take strind and return reverse string
    static String doReversed (String str) {
        int i;
        String reverse = "";
        for (i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your string: ");
        String s = input.nextLine();

        System.out.println("stripped: " + doStripped(s));
        System.out.println("reversed: " + doReversed(doStripped(s)));

        if (doStripped(s).equals(doReversed(doStripped(s)))) {
            System.out.println("This IS a palindrome.");
        } else {
            System.out.println("This is NOT a palindrome.");
        }
    }
}