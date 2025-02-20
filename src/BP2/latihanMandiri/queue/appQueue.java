package queue;
import java.util.Scanner;
public class appQueue {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int pilih=0;
        cBarang brg;
        cObjek objek;
        cQueue queue=new cQueue();
        
        do{
            System.out.println("\nAPP QUEUE\n1. Enqueue");
            System.out.println("2. Dequeue\n3. Show Queue");
            System.out.print("4. Exit\nPilih = ");
            pilih=s.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Masukkan Nama Barang = ");
                    s=new Scanner(System.in); String nm=s.nextLine();
                    System.out.print("Masukkan Harga Barang = ");
                    int hg=s.nextInt();
                    brg=new cBarang(nm,hg);
                    objek=new cObjek(brg);
                    queue.enqueue(objek);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.show();
                    break;
                case 4:
                    System.out.println("(Arigatou...)");
                    break;
                default:
                    System.out.println("(Mohon Pilih dengan Benar!!)");
                    break;
            }
        }while(pilih!=4);
    }
}
