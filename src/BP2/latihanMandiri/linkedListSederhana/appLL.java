package linkedListSederhana;
import java.util.Scanner;
public class appLL {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        cLinkedList LL = new cLinkedList(null);
        int pilih=0;
        do{
            System.out.println("\nMENU LINKED LIST");
            System.out.println("1. Tambah Simpul\n2. Hapus Simpul");
            System.out.println("3. Lihat Linked List\n4. Exit");
            System.out.print("Pilih = ");
            pilih=s.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Masukkan Nama Minuman = ");
                    s = new Scanner(System.in); String nm = s.nextLine();
                    System.out.print("Masukkan Harga = ");
                    int hg = s.nextInt();
                    cSimpul br = new cSimpul(nm,hg);
                    LL.addSimpul(br);
                    break;
                case 2:
                    LL.delSimpul();
                    break;
                case 3:
                    LL.show();
                    break;
                case 4:
                    System.out.println("Arigatou...");
                    break;
            }
        }while(pilih!=4);
    }
}
