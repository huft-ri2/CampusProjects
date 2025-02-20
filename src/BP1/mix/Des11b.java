package mix;

import java.util.Scanner;
public class Des11b {
    public static void main(String[] args) {
        // Memanggil metode kasir
        kasir();
    }

    // Metode kasir untuk menghitung total pembelian
    private static void kasir() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Kasir ===");

        // Meminta input informasi produk
        System.out.print("Masukkan nama produk: ");
        String namaProduk = scanner.nextLine();

        System.out.print("Masukkan harga produk: ");
        double hargaProduk = scanner.nextDouble();

        System.out.print("Masukkan jumlah produk: ");
        int jumlahProduk = scanner.nextInt();

        // Menghitung total pembelian
        double total = hitungTotal(hargaProduk, jumlahProduk);

        // Menampilkan hasil pembelian
        System.out.println("\n=== Struk Pembelian ===");
        System.out.println("Produk: " + namaProduk);
        System.out.println("Harga per unit: " + hargaProduk);
        System.out.println("Jumlah: " + jumlahProduk);
        System.out.println("Total: " + total);

        // Menutup scanner
        scanner.close();
    }

    // Metode untuk menghitung total pembelian
    private static double hitungTotal(double harga, int jumlah) {
        return harga * jumlah;
    }
}
