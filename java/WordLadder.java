import java.util.*;

public class WordLadder {
  public static List<String> temukanJalurTerpendek(String awal, String akhir, List<String> daftarKata) {
    Set<String> kamus = new HashSet<>(daftarKata);
    List<String> jalur = new ArrayList<>();
    jalur.add(awal);

    Queue<List<String>> antrian = new LinkedList<>();
    antrian.offer(jalur);

    while (!antrian.isEmpty()) {
      List<String> jalurSekarang = antrian.poll();
      String kataSekarang = jalurSekarang.get(jalurSekarang.size() - 1);

      if (kataSekarang.equals(akhir)) {
        return jalurSekarang;
      }

      char[] karakterSekarang = kataSekarang.toCharArray();
      for (int i = 0; i < karakterSekarang.length; i++) {
        char karakterAsli = karakterSekarang[i];
        for (char c = 'a'; c <= 'z'; c++) {
          karakterSekarang[i] = c;
          String kataBaru = new String(karakterSekarang);
          if (kamus.contains(kataBaru)) {
            List<String> jalurBaru = new ArrayList<>(jalurSekarang);
            jalurBaru.add(kataBaru);
            antrian.offer(jalurBaru);
            kamus.remove(kataBaru);
          }
        }
        karakterSekarang[i] = karakterAsli;
      }
    }

    return new ArrayList<>();
  }

  public static void main(String[] args) {
    String awal = "hot";
    String akhir = "dog";
    List<String> daftarKata = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    List<String> jalurTerpendek = temukanJalurTerpendek(awal, akhir, daftarKata);
    if (jalurTerpendek.isEmpty()) {
      System.out.println("Tidak ditemukan jalur!");
    } else {
      System.out.println("Jalur terpendek: " + jalurTerpendek);
    }
  }
}