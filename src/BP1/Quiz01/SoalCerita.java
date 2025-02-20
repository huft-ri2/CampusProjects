package Quiz01;

import java.util.Scanner;
public class SoalCerita {
    
    public static void main(String[] args){
        Scanner red = new Scanner(System.in);

        int x;
        int y;
        int a;

        System.out.print("Masukkan jumlah pekerja : ");
        x = red.nextInt();
        System.out.print("Masukkan waktu pengerjaan : ");
        a = red.nextInt();
        System.out.print("Masukkan jumlah pekerja tambahan : ");
        y = red.nextInt();

        int k= x+y;
        int l= a*x;
        int m= l/k;

        System.out.println("Total waktu pengerjaan : "+m+" mnt ");

    }
}
