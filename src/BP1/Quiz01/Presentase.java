package Quiz01;

import java.util.Scanner;
public class Presentase {
    public static void main(String[] args) {
       
       /*memasukkan angka*/
       int angka1, angka2;
       Scanner sf = new Scanner (System.in);
       System.out.print("Masukkan angka 1 : ");
       angka1 = sf.nextShort(); 
       System.out.print("Masukkan angka 2 : ");
       angka2 = sf.nextShort();
       System.out.println(" ");
       
       /*membuat persentase*/
       double xx;
       xx = ((double)angka1/angka2)*100;
       System.out.println("Persentase : "+xx+"%");
       System.out.println(" ");
       
    }
}
