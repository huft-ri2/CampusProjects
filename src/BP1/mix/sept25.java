package mix;

import java.util.Scanner;
public class sept25 {
    public static void main(String[] args){
        Scanner s = new Scanner (System.in);
        Scanner a = new Scanner (System.in);
        System.out.println("Pilihan Program yang tersedia");
        System.out.println("1. Total Jam\n2. Jam Lembur\n3. ATM");
        System.out.print("Silahkan pilih Channel tontonan anda = ");
        
        int pilih = s.nextInt();
        System.out.println(" ");
        
        switch (pilih){
                case 1: 
                    System.out.println("Total Jam");
                    
                    int hari1;
                    Scanner sh = new Scanner (System.in);
                    System.out.print("Masukkan Jumlah Hari : ");
                    hari1 = sh.nextShort();
        
                    int h = hari1*24;
                    System.out.println("Total Jam : "+h+" Jam");
                    System.out.println(" ");

                break;
                
                case 2: 
                    System.out.println("Jam Lembur");
                    
                    int bh = 31250;
                    int bl = 20000;
                    int jb;
                    int jl;
        
                    Scanner pu = new Scanner(System.in);
                    System.out.print("Masukkan Jumlah hari kerja dalam sebulan : ");
                    jb = pu.nextInt();
                    System.out.print("Masukkan Jumlah jam lembur : ");
                    jl = pu.nextInt();
        
                    System.out.println("Jumlah bayaran per hari : "+bh);
        
                    int ll = jl*bl;
                    int bb = jb*bh;
                    int tb = bb+ll;
                    System.out.println("Jumlah bayaran lembur : "+ll);
                    System.out.println("Jumlah bayaran perbulan : "+bb);
                    System.out.println("Total bayaran : "+tb);
                    System.out.println(" ");
                break;
                
                case 3:
                    System.out.println("ATM 2023");
                    System.out.println("1. Penarikan\n2. Transfer");
                    System.out.print("3. Pembayaran\nPilihan Anda = ");
                    byte pilih1 = a.nextByte();
                    
                    switch(pilih1){
                        case 1: System.out.println(" ");
                                System.out.println("Menu Penarikan");
                                System.out.println("Masukkan Nominal = ");
                                break;
                        case 2: System.out.println(" ");
                                System.out.println("Menu Transfer");
                                System.out.println("1. Ke Bank Sama");
                                System.out.println("2. Ke Bank Lain");
                                System.out.print("Pilihan Anda = ");
                                int pilih2 = a.nextInt();

                            switch(pilih2){
                                case 1: System.out.println("Gratis Biaya");
                                        break;
                                case 2: System.out.println("Biaya 5.000");
                                        break;
                               }
                                break;

                        case 3: System.out.println(" ");
                                System.out.println("Menu Pembayaran");
                                System.out.println("1. Tagihan Listrik");
                                System.out.println("2. Tiket Online");
                                System.out.println("3. Biaya Kuliah");
                                System.out.print("Pilihan Anda = ");
                                int pilih3 = a.nextInt();
                    
                            switch(pilih3){
                                case 1: System.out.println("ID Pel: ");
                                        break;
                                case 2: System.out.println("Kode Trx: ");
                                        break;
                                case 3: System.out.println("NPM: "); break;
                            }
                            break;

                        default: System.out.println("Pilihan Tidak Ada");

                    }
                break;
                
                default: System.out.println("Pilihan tidak ada");
                
        }
    }
}
