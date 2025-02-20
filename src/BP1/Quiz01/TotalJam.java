package Quiz01;

import java.util.Scanner;
public class TotalJam {
    
    public static void main(String[] args) {
        
        int hari1;
        Scanner sh = new Scanner (System.in);
        System.out.print("Masukkan Jumlah Hari : ");
        hari1 = sh.nextShort();
        
        int h = hari1*24;
        System.out.println("Total Jam : "+h+" Jam");
        System.out.println(" ");

    }
}
