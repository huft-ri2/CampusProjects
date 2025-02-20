package doubleLinkedList;
import java.util.Scanner;
public class cDoubleLL {
    Scanner sc=new Scanner(System.in);
    cNode head, tail;
    int jNode;
    cDoubleLL(){
        head=tail=null;
        jNode=0;
    }
    public void addFront(cNode baru){
        if(head==null){
            head=tail=baru;
        }else{
            baru.next=head;
            head.prev=baru;
            head=baru;
        }
        System.out.println("(Added...)");
    }
    public void addBack(cNode baru){
        if(tail==null){
            head=tail=baru;
        }else{
            tail.next=baru;
            baru.prev=tail;
            tail=baru;
        }
        System.out.println("(Added...)");
    }
    public void DelFront(){
        if(head==null){
            System.out.println("(Linked List Kosong!!)");
        }else if(head.next==null){
            head=tail=null;
            System.out.println("(Deleted...)");
        }else{
            cNode temp=head.next;
            head.next=null;
            head=temp;
            head.prev=null;
            System.out.println("(Deleted...)");
        }
    }
    public void DelBack(){
        if(tail==null){
            System.out.println("(Linked List Kosong!!)");
        }else if(tail.prev==null){
            head=tail=null;
            System.out.println("(Deleted...)");
        }else{
            cNode temp=tail.prev;
            tail.prev=null;
            tail=temp;
            tail.next=null;
            System.out.println("(Deleted...)");
        }
    }
    public void show(){
        if(tail==null){
            System.out.println("(Linked List Kosong!!)");
        }else{
            boolean y=true;
            int pilih=0, x=1;
            do{
                System.out.println("1. Depan ke Belakang\n2. Belakang ke Depan");
                System.out.print("Pilih = ");
                pilih=sc.nextInt();
                y=true;
                switch (pilih) {
                    case 1:
                        System.out.println("==================== Isi Double Linked List ====================");
                        for (cNode t = head; t!=null; t=t.next) {
                            System.out.println(x+". "+t.getNama()+"\tRp"+t.getHarga()+"\t["+t.getJumlah()+"]");
                            x++;
                        }
                        System.out.println("================================================================");
                        break;
                    case 2:
                        System.out.println("==================== Isi Double Linked List ====================");
                        for (cNode t = tail; t!=null; t=t.prev) {
                            System.out.println(x+". "+t.getNama()+"\tRp"+t.getHarga()+"\t["+t.getJumlah()+"]");
                            x++;
                        }
                        System.out.println("===============================================================");
                        break;
                    default:
                        y=false;
                        System.out.println("(Mohon Pilih dengan Benar!!)");
                        break;
                }
            }while(y==false);
        }
    }
}
