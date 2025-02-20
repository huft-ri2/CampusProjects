package circuralLinkedList;
import java.util.Scanner;
public class appCircularLL {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int pilih=0;
        cNode n;
        cMenu mn;
        cCircularLL cLL=new cCircularLL();
        do{
            System.out.println("\nCircular LINKED LIST");
            System.out.println("1. Add Node\n2. Delete");
            System.out.println("3. Show\n4. Exit");
            System.out.print("Pilih = ");
            pilih=s.nextInt();
            int pilih2=0;
            switch(pilih){
                case 1:
                    System.out.print("Nama = ");
                    s=new Scanner(System.in); String nm=s.nextLine();
                    System.out.print("Harga = ");
                    int hg=s.nextInt();
                    System.out.print("Masukkan Jumlah Stok = ");
                    int jml = s.nextInt();
                    mn=new cMenu(nm,hg,jml);
                    n=new cNode(mn);
                    cLL.addNode(n);
                    break;
                case 2:
                    cLL.delNode();
                    break;
                case 3:
                    cLL.check();
                    break;
                case 4:
                    System.out.println("Arigatou...");
                    break;
                default:
                    System.out.println("(Mohon Pilih dengan Benar!!)");
                    break;
            }
        }while(pilih!=4);
    }
}
