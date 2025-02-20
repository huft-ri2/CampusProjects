package stack;
import java.util.Scanner;
public class appStack {
    public static void main(String[] args) {
        int pilih=0;
        cSimpul node=new cSimpul("");
        cStack stack=new cStack();
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\nMENU STACK\n1. Push Data");
            System.out.println("2. Pop Data\n3. Keluar");
            System.out.print("Pilihan Anda : "); 
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Masukkan Nama = ");
                    sc=new Scanner(System.in); String nm = sc.nextLine();
                    node=new cSimpul(nm);
                    stack.push(nm);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println("Arigatou...");
                    break;
                default:
                    System.out.println("(Mohon Pilih dengan Benar!!)");
                    break;
            }
        }while(pilih!=3);
    }
}
