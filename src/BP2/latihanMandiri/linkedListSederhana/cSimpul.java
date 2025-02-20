package  linkedListSederhana;
public class cSimpul {
    private String nama;
    private int harga;
    cSimpul next;
    cSimpul(String m, int h){
        nama=m; harga=h; next=null;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
}
