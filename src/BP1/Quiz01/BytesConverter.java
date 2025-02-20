package Quiz01;

import java.util.Scanner;
public class BytesConverter {
    
    public static void main(String[] args){
        Scanner cv = new Scanner(System.in);
        int Megabytes;
        
        //{b, kb, mb, gb, tb, B, KB, GB, TB}
        System.out.print("Masukkan jumlah megabyte(MB) : ");
        Megabytes = cv.nextInt();
        
        //TAMPIL SEMUA 
        int b= Megabytes*800000;
        int kb= Megabytes*800;
        int mb= Megabytes*8;
        int gb= Megabytes/125;
        double tb= Megabytes*0.000008;
        int B= Megabytes*1000000;
        int KB=Megabytes*1000;
        double GB= Megabytes*0.001;
        double TB= Megabytes*0.000001;
        
        System.out.println(Megabytes+ "  MB sma dengan  " +b+ " b");
        System.out.println(Megabytes+ "  MB sma dengan  " +kb+ " kb");
        System.out.println(Megabytes+ "  MB sma dengan  " +mb+ " mb");
        System.out.println(Megabytes+ "  MB sma dengan  " +gb+ " gb");
        System.out.println(Megabytes+ "  MB sma dengan  " +tb+ " tb");
        System.out.println(Megabytes+ "  MB sma dengan  " +B+ " B");
        System.out.println(Megabytes+ "  MB sma dengan  " +KB+ " KB");
        System.out.println(Megabytes+ "  MB sma dengan  " +GB+ " GB");
        System.out.println(Megabytes+ "  MB sma dengan  "+(String.format("%.4f",TB))+ " TB");
        

    }
}
