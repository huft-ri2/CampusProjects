import java.util.*;
public class EAS {

    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nama = {"Umam Hanif", "Dimas Rhoyhan", "Umar Mukhtar"};
        String[] uname = {"hanif1234", "dimas1234", "umar1234"};
        String[] pass = {"Umam1Hanif", "Dimas1Rhoyhan", "Umar1Mukhtar"};

        int a, i, kmbl, x;
        String unameLogin, passLogin;

        do {
            kmbl = 0;
            System.out.println("Masukkan UserName Yang Telah Ada");
            System.out.println(" Atau Ketik Angka '9' Untuk Keluar dari aplikasi");
            unameLogin = input.next();
            if (!unameLogin.equals("9")) {
                System.out.print("Masukkan Password : ");
                passLogin = input.next();
                for (i = 0; i < 3; i++) {
                    if (unameLogin.equals(uname[i])) {
                        do {
                            if (passLogin.equals(pass[i])) {
                                System.out.println("Login Berhasil");
                                x = i;
                                kmbl = menu(nama, uname, x);
                                i = 2;
                            } else {
                                System.out.println("Password Yang Anda Masukkan Salah");
                                System.out.print("Silakan Masukkan Ulang Password : ");
                                passLogin = input.next();
                                kmbl = 1;
                            }
                        } while (kmbl == 1);
                    } else {
                        if (i == 2) {
                            System.out.println("Username Yang Anda Masukkan Tidak Ditemukan");
                            System.out.print("Silakan Masukkan Ulang Username: ");
                            kmbl = 1;
                        }
                    }
                }
                kmbl = 1;
            } else {
                input.nextLine();
                kmbl = -1;
            }
        } while (kmbl == 1 || kmbl == -2);
        System.out.println("Anda Telah Keluar Dari Aplikasi");
    }


    public static int menu(String[] nama, String[] uname, int x) {
        int[] saldo = {300000000, 2000000000, 1000000000};
        int[] pin = {879345, 64598, 324687};
        int[] rek = {30034287, 30054265, 30023598};

        int kmbl, pilih;

        do {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("<<<<<<<<< " + "Selamat Datang Di The UPN " + nama[x] + " >>>>>>>>>");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("1. Go-UPN");
            System.out.println("2. UPN M-Banking");
            System.out.println("0. Log out");
            pilih = input.nextInt();
            if (pilih == 0) {
                kmbl = -2;
            } else {
                if (pilih == 1) {
                    kmbl = goUPN(nama, x, saldo, pin);
                } else if (pilih == 2) {
                    kmbl = bank(nama, x, saldo, pin, rek);
                } else {
                    System.out.println("Pilihan Tidak Tersedia, Silakan Pilih Kembali");
                    kmbl = -1;
                }
            }
        } while (kmbl != -1 && kmbl != -2);

        return kmbl;
    }

    public static int goUPN(String[] nama, int x, int[] saldo, int[] pin) {
        int kmbl, need;

        do {
            System.out.println("Going Out to Campus with GO-UPN");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("-Go to Campus safely and quickly-");
            System.out.println("--It's the same with Graduation--");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Apa yang anda inginkan?");
            System.out.println("1. Berangkat ke UPN");
            System.out.println("2. Pulang ke Rumah");
            System.out.println("0. Kembali Ke Beranda");
            need = input.nextInt();
            if (need == 0) {
            } else {
                if (need == 1 || need == 2) {
                    need = menuGoUPN(nama, x, saldo, pin, need);
                } else {
                    System.out.println("Maaf, pilihan tidak tersedia! Silakan Pilih Kembali!");
                }
            }
        } while (need != 0);

        return need;
    }

    public static int bank(String[] nama, int x, int[] saldo, int[] pin, int[] rek) {
        int kmbl;
        int cekPin;

        System.out.print("Silakan masukkan nomor PIN Anda atau tulis angka '0' untuk keluar : ");
        do {
            cekPin = input.nextInt();
            if (cekPin == pin[x]) {
                kmbl = menuBank(x, saldo, rek);
            } else {
                if (cekPin == 0) {
                    kmbl = 0;
                } else {
                    System.out.println("PIN Yang Anda Masukkan Salah, Silakan Masukkan Ulang PIN atau Tulis '0' Untuk Keluar");
                    kmbl = 1;
                }
            }
        } while (kmbl != 0);
        
        return kmbl;
    }
    public static int menuGoUPN(String[] nama, int x, int[] saldo, int[] pin, int need) {
        int where, pay, fast, pilih, konfirmasi, urut, i, j, temp;

        pilih = 0;
        String driver, temp2;
        int[] going = new int[5];

        going[0] = 25000;
        going[1] = 30000;
        going[2] = 25000;
        going[3] = 15000;
        going[4] = 20000;
        String[] tempat = new String[5];

        tempat[0] = "SBY Selatan = Rp25000";
        tempat[1] = "SBY Barat = Rp30000";
        tempat[2] = "SBY Pusat = Rp25000";
        tempat[3] = "SBY Timur = Rp15000";
        tempat[4] = "SBY Pusat = Rp20000";
        for (i = 0; i <= 4; i++) {
            System.out.println(Integer.toString(i + 1) + ". " + tempat[i]);
        }
        if (need == 1) {
            System.out.println("Silahkan Pilih Lokasi Anda Sekarang : ");
        } else {
            System.out.println("Silahkan Pilih Lokasi Rumah Anda : ");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        do {
            System.out.println("Ketik Angka '0' Untuk Mengurutkan Dari Termurah Ke Termahal");
            System.out.println("Atau Langsung Pilih Tujuan");
            where = input.nextInt();
            if (where < 0 || where > 5) {
                System.out.println("Maaf, pilihan anda tidak tersedia! Silakan Pilih Kembali!");
            }
        } while (where < 0 || where > 5);
        if (where == 0) {
            for (i = 0; i <= 4; i++) {
                for (j = 0; j <= 3; j++) {
                    if (going[j] > going[j + 1]) {
                        temp = going[j];
                        going[j] = going[j + 1];
                        going[j + 1] = temp;
                        temp2 = tempat[j];
                        tempat[j] = tempat[j + 1];
                        tempat[j + 1] = temp2;
                    }
                }
            }
            for (i = 0; i <= 4; i++) {
                System.out.println(Integer.toString(i + 1) + ". " + tempat[i]);
            }
            System.out.println("Pilih Lokasi : ");
            where = input.nextInt();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Pilih Jenis Kendaraan:");
        System.out.println("1. Motor");
        System.out.println("2. Mobil");
        do {
            fast = input.nextInt();
            if (fast == 1) {
                System.out.println("Ini besaran jumlah yang anda tanggung: Rp" + going[where - 1]);
            } else {
                if (fast == 2) {
                    going[where - 1] = going[where - 1] + 10000;
                    System.out.println("Ini besaran jumlah yang anda tanggung: Rp" + going[where - 1]);
                } else {
                    System.out.println("Maaf, pilihan anda tidak tersedia!");
                    System.out.println("Masukan kembali pilihan anda!");
                }
            }
        } while (fast != 1 && fast != 2);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Pilih Metode Pembayaran:");
        System.out.println("1. Transfer dari M-Banking UPN !!! Diskon 5% !!!");
        System.out.println("2. Tunai");
        do {
            pay = input.nextInt();
            if (pay != 1 && pay != 2) {
                System.out.println("Maaf, pilihan anda tidak tersedia!");
                System.out.println("Masukan kembali pilihan anda!");
            }
        } while (pay != 1 && pay != 2);
        System.out.println("Tulis Angka '1' Untuk Mengonfirmasi Pesanan Anda");
        System.out.println("Tulis Angka Lainnya Untuk Membatalkan Pesanan Dan Kembali Menu GO-UPN");
        konfirmasi = input.nextInt();
        if (konfirmasi == 1) {
            if (pay == 1) {
                if (saldo[x] < going[where - 1] - (double) (going[where - 1] * 5) / 100) {
                    System.out.println("Isi Saldo Anda Adalah : " + saldo[x]);
                    System.out.println("Saldo Anda Tidak Mencukupi Untuk Pembayaran Pesanan");
                    System.out.println("Tulis '1' Untuk Melanjutkan Pesanan Dengan Pembayaran Di Tempat");
                    System.out.println("Tulis Angka Lainnya Untuk Membatalkan Pesanan Dan Kembali Ke Menu GO-UPN");
                    konfirmasi = input.nextInt();
                    if (konfirmasi == 1) {
                        System.out.println("Proses Pesanan Anda Telah Selesai");
                        System.out.println("Silahkan membayar sebesar Rp" + going[where - 1] + " kepada petugas ketika sudah sampai");
                        driver = vehicle(fast);
                        System.out.println("Anda akan dijemput oleh " + driver);
                    } else {
                        System.out.println("Pesanan Anda Telah Dibatalkan");
                    }
                } else {
                    System.out.print("Masukkan PIN Bank UPN Atas Nama '" + nama[x] + "' : ");
                    if (cekPin(pin, x) == true) {
                        System.out.println("Proses Pesanan Anda Telah Selesai");
                        System.out.println("Anda Telah Memperoleh Diskon 5%, Biaya Asli Adalah : Rp" + going[where - 1]);
                        going[where - 1] = (int) (going[where - 1] - (double) (going[where - 1] * 5) / 100);
                        saldo[x] = saldo[x] - going[where - 1];
                        System.out.println("Biaya Setelah Diskon : Rp" + going[where - 1] + " telah terpotong dari Saldo Rekening Anda");
                        driver = vehicle(fast);
                        System.out.println("Anda akan dijemput oleh " + driver);
                    } else {
                        System.out.println("Tulis '1' Untuk Melanjutkan Pesanan Dengan Pembayaran Di Tempat");
                        System.out.println("Tulis Angka Lainnya Untuk Membatalkan Pesanan Dan Kembali Ke Menu GO-UPN");
                        konfirmasi = input.nextInt();
                        if (konfirmasi == 1) {
                            System.out.println("Proses Pesanan Anda Telah Selesai");
                            System.out.println("Silahkan membayar sebesar Rp" + going[where - 1] + " kepada petugas ketika sudah sampai");
                            driver = vehicle(fast);
                            System.out.println("Anda akan dijemput oleh " + driver);
                        } else {
                            System.out.println("Pesanan Anda Telah Dibatalkan");
                        }
                    }
                }
            } else {
                System.out.println("Proses Pesanan Anda Telah Selesai");
                System.out.println("Silahkan membayar sebesar Rp" + going[where - 1] + " kepada petugas ketika sudah sampai");
                driver = vehicle(fast);
                System.out.println("Anda akan dijemput oleh " + driver);
            }
            pilih = (int) (-1);
        } else {
            System.out.println("Pesanan Anda Telah Dibatalkan");
            pilih = (int) (-1);
        }
        
        return pilih;
    }
    public static int menuBank(int x, int[] saldo, int[] rek) {
        int pilih, jumlah, i, notujuan, b;

        do {
            System.out.println("Silakan pilih salah satu dari opsi-opsi berikut : ");
            System.out.println("1. Pengecekan saldo");
            System.out.println("2. Penarikan tunai");
            System.out.println("3. Setor tunai");
            System.out.println("4. Transfer");
            System.out.println("0. Keluar Dari UPN M-Banking");
            pilih = input.nextInt();
            if (pilih == 0) {
            } else {
                if (pilih == 1) {
                    System.out.println("Saldo Anda : Rp" + saldo[x]);
                } else {
                    if (pilih == 2) {
                        System.out.println("Masukkan jumlah penarikan tunai : ");
                        jumlah = input.nextInt();
                        saldo[x] = saldo[x] - jumlah;
                        System.out.println("Saldo Anda Sekarang : Rp" + saldo[x]);
                    } else {
                        if (pilih == 3) {
                            System.out.println("Masukkan jumlah penyetoran tunai : ");
                            jumlah = input.nextInt();
                            saldo[x] = saldo[x] + jumlah;
                            System.out.println("Saldo Anda Sekarang : Rp" + saldo[x]);
                        } else {
                            if (pilih == 4) {
                                System.out.println("Masukkan No. Rekening Tujuan : ");
                                do {
                                    System.out.println(" Atau Ketik Angka '9' Untuk Keluar Dari Aplikasi");
                                    notujuan = input.nextInt();
                                    if (notujuan != 9) {
                                        for (i = 0; i <= 2; i++) {
                                            if (notujuan == rek[i]) {
                                                System.out.print("Masukkan jumlah tunai yang akan ditransfer : ");
                                                jumlah = input.nextInt();
                                                saldo[x] = saldo[x] - jumlah;
                                                saldo[i] = saldo[i] + jumlah;
                                                System.out.println("Transfer ke No. Rekening '" + notujuan + "' telah berhasil");
                                                System.out.println("Saldo Anda Sekarang : Rp" + saldo[x]);
                                                i = 2;
                                            } else {
                                                if (i == 2) {
                                                    System.out.println("No. Rekening Yang Anda Tuju Tidak Tersedia Di Bank UPN");
                                                    System.out.println("Silakan Masukkan Ulang No. Rekening Tujuan");
                                                    pilih = 1;
                                                }
                                            }
                                        }
                                    } else {
                                        pilih = (int) (-1);
                                    }
                                } while (pilih == 1);
                            } else {
                                System.out.println("Maaf, pilihan tidak ada");
                                System.out.print("Masukkan angka terserah untuk kembali ke menu utama atau angka '0' untuk keluar : ");
                            }
                        }
                    }
                }
            }
        } while (pilih != 0);
        
        return pilih;
    }
    public static String vehicle(int fast) {
        String vehicle;
        String[] bike = new String[5], car = new String[5];

        car[0] = "AKBAR yang menggunakan jenis XENIA dengan Nopol. L 4419 UX";
        car[1] = "NIO yang menggunakan jenis AVANZA dengan Nopol. W 5187 YY";
        car[2] = "NOVAL yang menggunakan jenis SIGRA dengan Nopol. L 5754 YT";
        car[3] = "ALEX yang menggunakan jenis INNOVA dengan Nopol. W 3018 OR";
        car[4] = "RAIHAN yang menggunakan jenis XPANDER dengan Nopol. L 1997 MX";
        bike[0] = "ALI yang menggunakan jenis HONDA VARIO dengan Nopol. W 1889 UI";
        bike[1] = "DIO yang menggunakan jenis YAMAHA NMAX dengan Nopol. S 6417 LL";
        bike[2] = "Utomo yang menggunakan jenis HONDA PCX dengan Nopol. L 6317 MN";
        bike[3] = "Aldi yang menggunakan jenis HONDA BEAT dengan Nopol. W 1309 KL";
        bike[4] = "Feri yang menggunakan jenis YAMAHA MIO dengan Nopol. L 4376 OP";
        if (fast == 1) {
            vehicle = bike[random.nextInt(4)];
        } else {
            vehicle = car[random.nextInt(4)];
        }
        
        return vehicle;
    }
    public static boolean cekPin(int[] pin, int x) {
        boolean pINTrue;
        int i, cekPin;

        i = 1;
        do {
            System.out.print("Silakan Masukkan NO. PIN Anda : ");
            cekPin = input.nextInt();
            if (cekPin == pin[x]) {
                pINTrue = true;
            } else {
                i = i + 1;
                pINTrue = false;
                if (i == 4) {
                    System.out.println("Anda Telah Salah Memasukkan No. PIN Sebanyak 3 kali, Pembayaran Anda Dengan Bank UPN Tidak Dapat Diselesaikan");
                } else {
                    System.out.print("No. PIN Yang Anda Masukkan Salah, Silakan Masukkan Ulang No. PIN (Maksimal Percobaan 3 Kali) : ");
                }
            }
        } while (i != 4 && pINTrue == false);
        
        return pINTrue;
    }
}

