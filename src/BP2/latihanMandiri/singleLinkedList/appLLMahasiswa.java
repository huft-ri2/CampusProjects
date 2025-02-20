package singleLinkedList;
import java.util.Scanner;
public class appLLMahasiswa {
    public static void main(String[] args) {
        cMahasiswa mhs1 = new cMahasiswa("Johan", 155, "Mojosari");
        cMahasiswa mhs2 = new cMahasiswa("Dinda", 178, "Waru");
        cMahasiswa mhs3 = new cMahasiswa("Kelly", 193, "Citraland");
        Scanner s = new Scanner(System.in);
        cLL LL = new cLL();
        
        int pilih=0;
        do{
            System.out.println("\nDATA MAHASISWA");
            System.out.println("1. Tambah Depan\n2. Hapus Depan");
            System.out.println("3. Lihat Isi\n4. Exit");
            System.out.print("Pilih = ");
            pilih = s.nextInt();
            switch(pilih){
                case 1:
                    System.out.println("1. "+mhs1.getNama());
                    System.out.println("2. "+mhs2.getNama());
                    System.out.println("3. "+mhs3.getNama());
                    System.out.print("Pilih = ");
                    int pilih2=s.nextInt();
                    switch(pilih2){
                        case 1:
                            cNode data = new cNode(mhs1);
                            LL.addFront(data);
                            break;
                        case 2:
                            data = new cNode(mhs2);
                            LL.addFront(data);
                            break;
                        case 3:
                            data = new cNode(mhs3);
                            LL.addFront(data);
                            break;
                        default:
                            System.out.println("(Pilihan Tidak Ada..)");
                            break;
                    }
                    break;
                case 2:
                    LL.delFront();
                    break;
                case 3:
                    LL.show();
                    break;
                case 4:
                    System.out.println("Arigatou..");
                    break;
            }
        }while(pilih!=4);
    }
}
