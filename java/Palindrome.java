import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Masukkan sebuah kata: ");
    String input = scanner.nextLine();
    scanner.close();

    boolean isPalindrome = checkPalindrome(input);
    int characterCount = input.length();

    System.out.println("Apakah Palindrome: " + isPalindrome);
    System.out.println("Jumlah Karakter: " + characterCount);
  }

  public static boolean checkPalindrome(String input) {
    String reversedInput = new StringBuilder(input).reverse().toString();
    return input.equalsIgnoreCase(reversedInput);
  }
}