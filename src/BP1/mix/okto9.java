package mix;

import java.util.Scanner;
public class okto9 {
    public static void main(String[] args){
        Scanner s = new Scanner (System.in);
        System.out.print("Masukkan Angka = ");
        int n = s.nextInt();
    for(int i=n; i>=1; i--)
        {
        for(int j=n; j>i; j--)
            {
            System.out.print(" ");
            }
        for(int k=1; k<=i; k++)
            {
            System.out.print("* ");
            }
        System.out.println();
        }
        System.out.println();
        System.out.println("baris = " + n);
    }
}

