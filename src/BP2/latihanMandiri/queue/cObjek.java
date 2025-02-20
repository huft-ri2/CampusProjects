package queue;
public class cObjek {
    private cBarang barang;
    cObjek next, prev;
    cObjek(cBarang b){
        barang=b;
    }
    public String getNama(){
        return barang.getNama();
    }
    public int getHarga(){
        return barang.getHarga();
    }
}
