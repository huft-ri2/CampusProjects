package circuralLinkedList;
import java.util.Scanner;
public class cCircularLL {
    cCircularLL LL;
    Scanner s=new Scanner(System.in);
    cNode head, tail;
    int jNode;
    cCircularLL(){
        head=tail=null;
        jNode=0;
    }
    public void addNode(cNode baru){
        //Simpul baru selalu di depan(kiri)
        if(head==null){
            head=tail=baru;
            tail.next=head;
        }else{
            baru.next=head;
            tail.next=baru;
            head=baru;
        }
        System.out.println("(Added...)");
    }
    public void delNode(){
        if(head==null){
            System.out.println("(Isi Kosong!!)");
        }else if(head.next==null){
            head=tail=null;
            System.out.println("(Deleted...)");
        }else{
            cNode t=head.next;
            head.next=null;
            head=t;
            tail.next=head;
            System.out.println("(Deleted...)");
        }
    }
    public void check(){
        boolean y;
        if(head==null){
            System.out.println("(Isi Kosong!!)");
        }else{
            LL=new cCircularLL();
            int pilih=0;
            do{
                System.out.println("1. Tampilkan Default\n2. Tampilkan Sesuai Keinginan");
                System.out.print("3. Kembali\nPilih = ");
                pilih=s.nextInt();
                switch(pilih){
                    case 1:
                        LL.show(head);
                        pilih=3;
                        break;
                    case 2:
                        do{
                            y=false;
                            System.out.print("Mulai dari = ");
                            s=new Scanner(System.in); String mn=s.nextLine();
                            cNode start=null;
                            cNode t=head;
                            do{
                                if(t.getNama().equalsIgnoreCase(mn)){
                                    start = t;
                                    y=true;
                                    break;
                                }
                                t=t.next;
                            }while(t!=head);
                            if(y==false){
                                System.out.print("Apakah Ingin Mencoba Lagi?(Ketik 1 jika ya) ");
                                int ya=s.nextInt();
                                if(ya==1){
                                    y=true;
                                }
                            }else{
                                LL.show(start);
                                y=false;
                                pilih=3;
                            }
                        }while(y==true);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("(Mohon Pilih Dengan Benar!!)");
                        break;
                }
            }while(pilih!=3);
        }
    }
    public void show(cNode s){
        cNode t = s;
        System.out.println("============== Isi Circular Linked List ==============");
        int x=1;
        do{
            System.out.println(x+". "+t.getNama()+"\tRp"+t.getHarga()+"\t["+t.getJumlah()+"]");
            t=t.next; x++;
        }while(t!=s);
        System.out.println("======================================================");
    }
}
