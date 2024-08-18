import java.util.HashMap;
import java.util.Map;

public class SockMerchant {
  public static int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> jumlahKaosKaki = new HashMap<>();
    int jumlahPasangan = 0;

    // Menghitung jumlah kaos kaki dari setiap warna
    for (int i = 0; i < n; i++) {
      int warna = ar[i];
      jumlahKaosKaki.put(warna, jumlahKaosKaki.getOrDefault(warna, 0) + 1);
    }

    // Menghitung jumlah pasangan
    for (int jumlah : jumlahKaosKaki.values()) {
      jumlahPasangan += jumlah / 2;
    }

    return jumlahPasangan;
  }

  public static void main(String[] args) {
    int n = 9;
    int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    int hasil = sockMerchant(n, ar);
    System.out.println("Jumlah pasangan: " + hasil);
  }
}