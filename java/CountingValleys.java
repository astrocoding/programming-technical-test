public class CountingValleys {
  public static int countValleys(int steps, String path) {
    int level = 0;
    int valleys = 0;

    for (int i = 0; i < steps; i++) {
      char step = path.charAt(i);

      if (step == 'U') {
        level++;
        if (level == 0) {
          valleys++;
        }
      } else if (step == 'D') {
        level--;
      }
    }

    return valleys;
  }

  public static void main(String[] args) {
    int steps = 8;
    String path = "UDDDUDUU";
    int result = countValleys(steps, path);
    System.out.println("Jumlah lembah yang dilewati: " + result);
  }
}