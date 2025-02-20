package circuralLinkedList;
public class cNode {
    cMenu menu;
    cNode next;
    cNode(cMenu m){
        menu=m;
        next=null;
    }
    public String getNama(){
        return menu.getNama();
    }
    public int getHarga(){
        return menu.getHarga();
    }
    public int getJumlah(){
        return menu.getJumlah();
    }
}
