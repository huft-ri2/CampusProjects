package Quiz01;

import java.util.Scanner;
public class Triangle {
    
    public static void main(String[] args){
        
        Scanner tringular = new Scanner (System.in);
        
        int a,b,c;
        System.out.print("Masukkan Panjang Sisi a : ");
        a = tringular.nextInt();
        System.out.print("Masukkan Panjang Sisi b : ");
        b = tringular.nextInt();
        System.out.print("Masukkan Panjang Sisi c : ");
        c = tringular.nextInt();

        boolean cek1, cek2, cek3, hasil;
        cek1 = a+b>c;
        System.out.println("a + b > c : "+cek1);
        cek2 = a+c>b;
        System.out.println("a + c > b : "+cek2);
        cek3 = b+c>a;
        System.out.println("b + c > a : "+cek3);

        hasil = cek1 && cek2 && cek3;
        System.out.println("Bisa Dibuat Segitiga : "+hasil);
 
    }
}
