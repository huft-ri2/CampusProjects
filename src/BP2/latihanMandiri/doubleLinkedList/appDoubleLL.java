package doubleLinkedList;
import java.util.Scanner;
public class appDoubleLL {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int pilih=0;
        cNode n;
        cMenu mn;
        cDoubleLL dLL=new cDoubleLL();
        do{
            System.out.println("\nDOUBLE LINKED LIST");
            System.out.println("1. Add Node\n2. Delete");
            System.out.println("3. Show\n4. Exit");
            System.out.print("Pilih = ");
            pilih=s.nextInt();
            int pilih2=0;
            switch(pilih){
                case 1:
                    do{
                        System.out.println("1. Add Front\n2. Add Back");
                        System.out.print("3. Kembali\nPilih = ");
                        pilih2=s.nextInt();
                        switch(pilih2){
                            case 1:
                                System.out.print("Nama = ");
                                s=new Scanner(System.in); String nm=s.nextLine();
                                System.out.print("Harga = ");
                                int hg=s.nextInt();
                                System.out.print("Masukkan Jumlah Stok = ");
                                int jml=s.nextInt();
                                mn=new cMenu(nm,hg,jml);
                                n=new cNode(mn);
                                dLL.addFront(n);
                                break;
                            case 2:
                                System.out.print("Nama = ");
                                s=new Scanner(System.in); nm=s.nextLine();
                                System.out.print("Harga = ");
                                hg=s.nextInt();
                                System.out.print("Masukkan Jumlah Stok = ");
                                jml=s.nextInt();
                                mn=new cMenu(nm,hg,jml);
                                n=new cNode(mn);
                                dLL.addBack(n);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("(Mohon Pilih dengan Benar!!)");
                                break;
                        }
                    }while(pilih2!=3);
                    break;
                case 2:
                    do{
                        System.out.println("1. Delete Front\n2. Delete Back");
                        System.out.print("3. Kembali\nPilih = ");
                        pilih2=s.nextInt();
                        switch(pilih2){
                            case 1:
                                dLL.DelFront();
                                break;
                            case 2:
                                dLL.DelBack();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("(Mohon Pilih dengan Benar!!)");
                                break;
                        }
                    }while(pilih2==1 || pilih2==2);
                    break;
                case 3:
                    dLL.show();
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
