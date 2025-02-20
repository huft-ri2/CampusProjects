package Quiz01;

import java.util.Scanner;
public class JamLembur {
    
    public static void main(String[] args) {
        
        int bh = 31250;
        int bl = 20000;
        int jb;
        int jl;
        
        Scanner pu = new Scanner(System.in);
        System.out.print("Masukkan Jumlah hari kerja dalam sebulan : ");
        jb = pu.nextInt();
        System.out.print("Masukkan Jumlah jam lembur : ");
        jl = pu.nextInt();
        
        System.out.println("Jumlah bayaran per hari : "+bh);
        
        int ll = jl*bl;
        int bb = jb*bh;
        int tb = bb+ll;
        System.out.println("Jumlah bayaran lembur : "+ll);
        System.out.println("Jumlah bayaran perbulan : "+bb);
        System.out.println("Total bayaran : "+tb);
        System.out.println(" ");
        
    }
}
