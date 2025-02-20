package doubleLinkedList;
public class cNode {
    cMenu data;
    cNode next,prev;
    cNode(cMenu d){
        data=d;
        next=prev=null;
    }
    public String getNama(){
        return data.getNama();
    }
    public int getHarga(){
        return data.getHarga();
    }
    public int getJumlah(){
        return data.getJumlah();
    }
}
