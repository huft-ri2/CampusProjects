package mix;

import java.util.Scanner;
public class Des11d {
    public static void main(String[] args) {
        // Memanggil metode kasir
        kasir();
    }

    // Metode kasir untuk menghitung total pembelian
    private static void kasir() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Warteg Kasir ===");

        // Menentukan menu makanan dan harganya
        String[][] menu = {
                {"Nasi Goreng", "15000"},
                {"Mie Goreng", "12000"},
                {"Ayam Goreng", "18000"},
                {"Sayur Asem", "10000"},
                {"Soto Ayam", "16000"}
        };

        // Mendefinisikan array untuk menyimpan jumlah porsi makanan yang dibeli
        int[] jumlahPorsi = new int[menu.length];

        int pilihan;
        do {
            // Menampilkan menu makanan
            tampilkanMenu(menu);

            // Meminta pengguna memilih menu dan memasukkan jumlah porsi
            System.out.print("Pilih menu (0 untuk selesai): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 0:
                    break; // Keluar dari loop jika pengguna memilih 0
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.print("Masukkan jumlah porsi: ");
                    int porsi = scanner.nextInt();
                    jumlahPorsi[pilihan - 1] += porsi;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }

        } while (pilihan != 0);

        // Menampilkan struk pembelian
        System.out.println("\n=== Struk Pembelian ===");

        double totalBelanja = 0;

        for (int i = 0; i < menu.length; i++) {
            if (jumlahPorsi[i] > 0) {
                String namaMenu = menu[i][0];
                double hargaMenu = Double.parseDouble(menu[i][1]);
                int porsi = jumlahPorsi[i];

                double totalMenu = hargaMenu * porsi;
                totalBelanja += totalMenu;

                System.out.println(namaMenu + " x " + porsi + " = Rp" + totalMenu);
            }
        }

        System.out.println("----------------------");
        System.out.println("Total Belanja: Rp" + totalBelanja);
        System.out.println("Terima kasih!");

        // Menutup scanner
        scanner.close();
    }

    // Metode untuk menampilkan menu makanan
    private static void tampilkanMenu(String[][] menu) {
        System.out.println("\nMenu Makanan:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i][0] + " - Rp" + menu[i][1]);
        }
        System.out.println("0. Selesai");
    }
}
