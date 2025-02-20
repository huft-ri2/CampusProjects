package  linkedListSederhana;
public class cLinkedList {
    cSimpul kepala;
    cSimpul ekor;
    int jSimpul;
    cLinkedList(cSimpul s){
        kepala=ekor=s; jSimpul=0;
    }
    public void addSimpul(cSimpul baru){
        if(kepala==null){
            kepala=ekor=baru;
        }else{
            //tambah depan
            baru.next=kepala;
            kepala=baru;
        }
        System.out.println("(Added...)");
    }
    public void delSimpul(){
        if(kepala==null){
            System.out.println("(Linked List Kosong!!)");
        }else{
            cSimpul temp = kepala.next;
            kepala=null;
            kepala=temp;
            System.out.println("(Deleted...)");
        }
    }
    public void show(){
        if(kepala==null){
            System.out.println("(Linked List Kosong!!)");
        }else{
            System.out.println("Isi Linked List: ");
            for (cSimpul t = kepala; t!=null; t=t.next) {
                System.out.println(t.getNama()+" ["+t.getHarga()+"]");
            }
            System.out.println("");
        }
    }
}
