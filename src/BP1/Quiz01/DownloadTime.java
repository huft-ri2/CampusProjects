package Quiz01;

import java.util.Scanner;
 public class DownloadTime {   public static void main(String[] args){
     
        int bt;
        int bw;
        
        Scanner leap = new Scanner(System.in);
        System.out.print("masukkan besar file (MB) : ");
        bt = leap.nextInt();
        System.out.print("masukkan jumlah bandwith (mbps) : ");
        bw = leap.nextInt();

        float tms = bt*8;
        float tmm=  tms/60;

        System.out.println("Download time (s) : "+tms);
        System.out.println("Download time (m) : "+String.format("%.2f", tmm));
        


    }
}
