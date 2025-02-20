package Quiz01;

import java.util.Scanner;
public class PresentaseKeuntungan2 {
    
    public static void main(String[] args){
        int hargawal;
        int hargajual;
        int profit;

        Scanner tm= new Scanner (System.in);
        System.out.print("Masukkan Harga Beli Barang : "+ " Rp.");
        hargawal = tm.nextInt();
        System.out.print("MAsukkan Presentase Keuntungan : ");
        profit= tm.nextInt();
        
        //int profit= hargajual-hargawal;
        int a=hargawal*profit;
        int b= hargawal+(a/100);

        System.out.println("Harga Jual Barang : "+ " Rp. "+b);
        System.out.println(" ");

    }
}
