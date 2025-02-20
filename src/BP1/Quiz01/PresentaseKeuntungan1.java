package Quiz01;

import java.util.Scanner;
public class PresentaseKeuntungan1 {
    
    public static void main(String[] args){
        int hargaawal;
        int hargajual;
        
        Scanner kl= new Scanner (System.in);
        System.out.print("Masukkan Harga Beli Barang : ");
        hargaawal = kl.nextInt();
        System.out.print("Masukkan Harga Jual Barang : ");
        hargajual= kl.nextInt();

        int profit= (hargajual-hargaawal);
        float percentage;
        percentage = (float)profit/hargaawal*100;

        System.out.println("Persentase Keuntungan : "+percentage+ "%");
        System.out.println(" ");
        
    }
}