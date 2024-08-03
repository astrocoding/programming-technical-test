import java.util.Scanner;

public class Recursive {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a decimal number: ");
    int decimal = scanner.nextInt();
    scanner.close();

    System.out.println("Binary: " + decimalToBinary(decimal));
    System.out.println("Octal: " + decimalToOctal(decimal));
    System.out.println("Hexadecimal: " + decimalToHexadecimal(decimal));
  }

  public static String decimalToBinary(int decimal) {
    if (decimal == 0) {
      return "0";
    } else if (decimal == 1) {
      return "1";
    } else {
      return decimalToBinary(decimal / 2) + (decimal % 2);
    }
  }

  public static String decimalToOctal(int decimal) {
    if (decimal < 8) {
      return Integer.toString(decimal);
    } else {
      return decimalToOctal(decimal / 8) + (decimal % 8);
    }
  }

  public static String decimalToHexadecimal(int decimal) {
    if (decimal < 16) {
      return Integer.toHexString(decimal);
    } else {
      return decimalToHexadecimal(decimal / 16) + Integer.toHexString(decimal % 16);
    }
  }
}