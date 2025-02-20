package singleLinkedList;
public class cNode {
    cMahasiswa data;
    cNode next;
    cNode(cMahasiswa d){
        data = d;
    }
    public String getNama(){
        return data.getNama();
    }
    public String getAlamat(){
        return data.getAlamat();
    }
    public int getNPM(){
        return data.getNPM();
    }
}
