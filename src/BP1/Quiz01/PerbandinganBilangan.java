package Quiz01;

import java.util.Scanner;
public class PerbandinganBilangan {
    
    public static void main(String[] args) {
       
       /*memasukkan angka*/
       int angka1, angka2;
       Scanner sf = new Scanner (System.in);
       System.out.print("Masukkan angka 1 : ");
       angka1 = sf.nextShort(); 
       System.out.print("Masukkan angka 2 : ");
       angka2 = sf.nextShort();
       System.out.println(" ");
       
       /*logika true-false*/
       boolean logika;
       int A = angka1, B = angka2;
       logika = A==B;
       System.out.println(angka1+" = "+angka2+" : "+logika);
       logika = A<B;
       System.out.println(angka1+" < "+angka2+" : "+logika);
       logika = B>A;
       System.out.println(angka2+" > "+angka1+" : "+logika);
       logika = B<A;
       System.out.println(angka2+" < "+angka1+" : "+logika);
       System.out.println(" ");
       
    }
}
