package mix;

import java.util.Scanner;
public class Okto22k {
    public static void main(String[] args) 
    {
        Scanner s = new Scanner (System.in);
        System.out.print("Masukkan Angka = ");
        int n = s.nextInt();
        for(int i=1; i<=n; i++) 
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
        System.out.print("Baris = "+n);
    }
}
