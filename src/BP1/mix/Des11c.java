package mix;


import java.util.Scanner;

public class Des11c {
    public static void main(String[] args) {

        // Memanggil metode kasir
        kasir();
    }

    // Metode kasir untuk menghitung total pembelian
    private static void kasir() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Kasir ===");

        // Meminta jumlah produk yang akan dimasukkan
        System.out.print("Masukkan jumlah produk: ");
        int jumlahProduk = scanner.nextInt();

        // Mendefinisikan array 3 dimensi untuk menyimpan informasi produk
        String[][][] produkArray = new String[jumlahProduk][3][3];

        // Memasukkan informasi produk ke dalam array
        for (int i = 0; i < jumlahProduk; i++) {
            scanner.nextLine(); // Membersihkan karakter baris baru di buffer

            System.out.println("\nMasukkan informasi untuk Produk " + (i + 1));

            System.out.print("Nama produk: ");
            produkArray[i][0][0] = scanner.nextLine();

            System.out.print("Harga produk: ");
            produkArray[i][1][0] = scanner.nextLine();

            System.out.print("Jumlah produk: ");
            produkArray[i][2][0] = scanner.nextLine();
        }

        // Menampilkan hasil pembelian
        System.out.println("\n=== Struk Pembelian ===");

        double totalBelanja = 0;

        for (int i = 0; i < jumlahProduk; i++) {
            String namaProduk = produkArray[i][0][0];
            double hargaProduk = Double.parseDouble(produkArray[i][1][0]);
            int jumlahProdukBeli = Integer.parseInt(produkArray[i][2][0]);

            double totalProduk = hargaProduk * jumlahProdukBeli;
            totalBelanja += totalProduk;

            System.out.println("Produk: " + namaProduk);
            System.out.println("Harga per unit: " + hargaProduk);
            System.out.println("Jumlah: " + jumlahProdukBeli);
            System.out.println("Total: " + totalProduk);
            System.out.println("----------------------");
        }

        System.out.println("Total Belanja: " + totalBelanja);

        // Menutup scanner
        scanner.close();
    }
}
