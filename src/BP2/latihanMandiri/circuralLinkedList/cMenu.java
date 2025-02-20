package circuralLinkedList;
public class cMenu {
    private String nama;
    private int harga, jumlah;
    cMenu(String n, int h, int j){
        nama=n; harga=h; jumlah=j;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
    public int getJumlah(){
        return jumlah;
    }
}
