package Quiz01;



import java.util.Scanner;
public class Tugas2 {
    
    public static void main(String[] args) {
        
        /*total jam*/
        int hari1;
        Scanner sh = new Scanner (System.in);
        System.out.print("Masukkan Jumlah Hari : ");
        hari1 = sh.nextShort();
        
        int h = hari1*24;
        System.out.println("Total Jam : "+h+" Jam");
        System.out.println(" ");
        
        /*inflasi*/
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
        System.out.println(" ");
        
        /*jam lembur*/
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
