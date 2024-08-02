/**
 * Name: TechnicalTest.java
 * Author: Zaenal Alfian
 * Date: 21 Aug 2024
 * Description: This program contains solutions for three technical questions:
 *  1. Bubble Sort (ascending/descending order)
 *  2. Binary Search
 *  3. String Analysis (counts vowels, consonants, special/other characters, and identifies the longest word)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TechnicalTest {

    // Question 1: Bubble Sort Function
    public static int[] bubbleSort(int[] arr, String order) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (("asc".equals(order) && arr[j] > arr[j + 1]) || ("desc".equals(order) && arr[j] < arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }

    // Question 2: Binary Search Function
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    public static int binarySearch(int[] arr, int low, int high, int value) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == value) return mid;

            if (arr[mid] > value) return binarySearch(arr, low, mid - 1, value);

            return binarySearch(arr, mid + 1, high, value);
        }

        return -1;
    }

    public static int searchArray(int[] arr, int value) {
        // Sort the array using bubbleSort from Question 1
        if (!isSorted(arr)) {
            arr = bubbleSort(arr, "asc");
        }

        // Perform binary search
        return binarySearch(arr, 0, arr.length - 1, value);
    }

    // Question 3: String Analysis Function
    public static void analyzeString(String input) {
        int[] vowelCount = new int[26];
        int[] consonantCount = new int[26];
        Map<Character, Integer> specialCharCount = new HashMap<>();
        int longestWordLength = 0;
        String longestWord = "";

        String vowels = "AEIOUaeiou";
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                if (vowels.indexOf(ch) != -1) {
                    vowelCount[Character.toLowerCase(ch) - 'a']++;
                } else {
                    consonantCount[Character.toLowerCase(ch) - 'a']++;
                }
                word.append(ch);
            } else {
                specialCharCount.put(ch, specialCharCount.getOrDefault(ch, 0) + 1);

                if (word.length() > longestWordLength) {
                    longestWordLength = word.length();
                    longestWord = word.toString();
                }
                word.setLength(0);
            }
        }

        if (word.length() > longestWordLength) {
            longestWordLength = word.length();
            longestWord = word.toString();
        }

        System.out.println("Vowels:");
        for (int i = 0; i < vowelCount.length; i++) {
            if (vowelCount[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + vowelCount[i]);
            }
        }

        System.out.println("Consonants:");
        for (int i = 0; i < consonantCount.length; i++) {
            if (consonantCount[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + consonantCount[i]);
            }
        }

        System.out.println("Other Characters:");
        for (Map.Entry<Character, Integer> entry : specialCharCount.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }

        System.out.println("Longest Word: " + longestWord);
    }

    public static void main(String[] args) {
        // Test for Question 1: Bubble Sort
        int[] arr1 = {10, 4, 2, 8, 11, 15};
        System.out.println("Question 1: Bubble Sort");
        int[] sortedAsc = bubbleSort(arr1.clone(), "asc");
        int[] sortedDesc = bubbleSort(arr1.clone(), "desc");

        System.out.println("Sorted Ascending: " + java.util.Arrays.toString(sortedAsc));
        System.out.println("Sorted Descending: " + java.util.Arrays.toString(sortedDesc));

        // Test for Question 2: Binary Search
        int[] arr2 = {3, 6, 2, 4};
        int[] arr3 = {1, 5, 8, 9, 10};
        System.out.println("\nQuestion 2: Binary Search");
        System.out.println("Index of 4 in arr2: " + searchArray(arr2, 4)); // Should return 2
        System.out.println("Index of 5 in arr3: " + searchArray(arr3, 5)); // Should return 1

        // Test for Question 3: String Analysis
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nQuestion 3: String Analysis");
        System.out.print("Please enter a string for analysis: ");
        String input = scanner.nextLine();
        analyzeString(input);
    }
}
