package queueLatihan;
import java.util.Scanner;
public class appQueue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pilih=0;
        cAntrianPesanan antrian = new cAntrianPesanan(3);
        do{
            System.out.println("Antrian Queue");
            System.out.println("1. Tambah");
            System.out.println("2. Proses");
            System.out.println("3. Lihat");
            System.out.println("4. Exit");
            System.out.print("Pilih....");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Menu = ");
                    String mn = sc.next();
                    System.out.print("Jumlah = ");
                    int jum = sc.nextInt();
                    antrian.enqueue (mn, jum);
                    break;
                case 2:
                    antrian.dequeue();
                    break;
                case 3:
                    antrian.show();
                    break;
                case 4:
                    break;
            }
        }while(pilih!=4);
    }
}
