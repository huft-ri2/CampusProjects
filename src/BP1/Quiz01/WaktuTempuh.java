package Quiz01;

import java.util.Scanner;
public class WaktuTempuh {
    
    public static void main(String[] args){
        
        Scanner nuw= new Scanner(System.in);
        double jarak, kecepatanjam, waktutmph, waktutmphH, waktutmphM, waktuakhir;

        System.out.print("jarak dari rumah ke kampus (km) : ");
        jarak = nuw.nextInt();
        System.out.print("kecepatan rata-rata tempuh (km/jam) : ");
        kecepatanjam =nuw.nextInt();

        waktutmph= jarak/ kecepatanjam;
        waktutmphH= 2*waktutmph;
        waktutmphM= waktutmphH*5;
        waktuakhir= waktutmphM*60;

        System.out.println("Waktu pulang pergi dalam satu minggu (5 hari) : "+(int)waktuakhir+ " mnt");


    }
}
