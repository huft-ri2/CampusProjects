package Quiz01;



import java.util.Scanner;
public class Quiz1 {
    
    public static void main(String[] args) {
       
       /*memasukkan angka*/
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
       
       /*membuat persentase*/
       double xx;
       xx = ((double)angka1/angka2)*100;
       System.out.println("Persentase : "+xx+"%");
       System.out.println(" ");
       
    }
}