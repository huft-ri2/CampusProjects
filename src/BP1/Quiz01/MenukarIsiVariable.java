package Quiz01;

import java.util.Scanner;
public class MenukarIsiVariable {
    public static void main(String[] args) {
       
       int angka1, angka2;
       Scanner sf = new Scanner (System.in);
       System.out.print("Masukkan angka 1 : ");
       angka1 = sf.nextShort(); 
       System.out.print("Masukkan angka 2 : ");
       angka2 = sf.nextShort();
       System.out.println(" ");
       
       /*selisih, penjumlahan, dan rata-rata*/
       int x = angka1 - angka2;
       int y = angka1 + angka2;
       int z = (angka1 + angka2)/2 ;
       System.out.println("Selisih dari "+angka1+" dan "+angka2+" : "+x);
       System.out.println("Penjumlahan dari "+angka1+" dan "+angka2+" : "+y);
       System.out.println("Rata-Rata dari  "+angka1+" dan "+angka2+" : "+z);
       System.out.println(" ");
       
    }
}
