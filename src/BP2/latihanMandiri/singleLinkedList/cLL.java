package singleLinkedList;
public class cLL {
    cNode head, tail;
    int jNode;
    cLL(){
        
    }
    public void addFront(cNode baru){
        if(head==null){
            head=tail=baru;
        }else{
            baru.next=head;
            head=baru;
        }
        System.out.println("(Added...)");
    }
    public void delFront(){
        if(head==null){
            System.out.println("(Data Kosong!!)");
        }else if(head.next==null){
            head=tail=null;
            System.out.println("(Deleted...)");
        }else{
            head=head.next;
            System.out.println("(Deleted...)");
        }
    }
    public void show(){
        if(head==null){
            System.out.println("(Data Kosong!!)");
        }else{
            System.out.println("Isi Linked List: ");
            for (cNode t = head; t!=null; t=t.next) {
                System.out.println(t.getNPM()+" "+t.getNama()+" ["+t.getAlamat()+"]");
            }
        }
    }
}
