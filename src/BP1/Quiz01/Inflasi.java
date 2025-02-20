package Quiz01;


import java.util.Scanner;
public class Inflasi {
    
    public static void main(String[] args) {
        
        int tab;
        int inf = 4;
        int dur;
        
        Scanner op = new Scanner(System.in);
        System.out.print("Masukkan jumlah tabungan anda : ");
        tab = op.nextInt();
        System.out.print("Masukkan durasi : ");
        dur = op.nextInt();
        System.out.println("Jumlah inflasi : "+inf+"%");

        int x = (tab*inf)/100;
        int y = (x*dur)/12;
        int z = tab-y;
        System.out.println("Nilai tabungan anda dalam " +dur+ " bulan adalah : "+z);
        
    }    
}
