package Quiz01;

import java.util.Scanner;
public class SatuanConverter {
    
    public static void main(String[] args){
        
        int itm;
    
        Scanner kow = new Scanner(System.in);
        System.out.print("Masukkan jumlah item : ");
        itm = kow.nextInt();
        
        //PRIN SMUA
        int kod= itm/20;
        int rekod= itm%20;
        int lus= itm/12;
        int reitm= itm%12;
        int gro= itm/144;
        int regro=itm%144;

        System.out.println("hasil konversi : ");
        System.out.println("Dalam Saruan Lusin : "+lus+ " lusin "+reitm+ " item ");
        System.out.println("Dalam Saruan Gross : "+gro+ " grosir "+regro+ " item ");
        System.out.println("Dalam Saruan Kodi : "+kod+ " kodi "+rekod+" item ");


    }
}
