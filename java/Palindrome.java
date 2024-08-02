import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String input = scanner.nextLine();
    scanner.close();

    boolean isPalindrome = checkPalindrome(input);
    int characterCount = countCharacters(input);

    System.out.println("Is Palindrome: " + isPalindrome);
    System.out.println("Character Count: " + characterCount);
  }

  public static boolean checkPalindrome(String input) {
    int length = input.length();
    for (int i = 0; i < length / 2; i++) {
      if (input.charAt(i) != input.charAt(length - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static int countCharacters(String input) {
    return input.length();
  }
}