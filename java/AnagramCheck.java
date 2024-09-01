import java.util.Arrays;

public class AnagramCheck {
  public static boolean isAnagram(String str1, String str2) {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();

    Arrays.sort(charArray1);
    Arrays.sort(charArray2);

    return Arrays.equals(charArray1, charArray2);
  }

  public static void main(String[] args) {
    String str1 = "listen";
    String str2 = "silent";

    if (isAnagram(str1, str2)) {
      System.out.println("Kedua string adalah anagram.");
    } else {
      System.out.println("Kedua string bukan anagram.");
    }
  }
}