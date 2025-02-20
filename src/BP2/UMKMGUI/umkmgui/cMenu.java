package umkmgui;

public class cMenu { //makanan
    // data
    private String nama, kode;
    private int harga, pemasukan;
        
    //method
    cMenu() {
        System.out.println("Default constructor menu..");
    }
    cMenu(String n, int h, String k, int p){
        nama=n; harga=h; kode=k; pemasukan=p; 
        System.out.println("Objek "+nama+" dibuat...");
    }
	public void setNama(String n) { nama=n; }
    public void setHarga(int h) { harga=h; }
	public void setPemasukan(int p) { pemasukan=p; }
    public void setKode(String k) { kode=k; }
    public String getNama() {return nama; }
    public int getHarga() { return harga; }
	public int getPemasukan() { return pemasukan; }
    public String getKode() { return kode; }
    public String ToString(){
        return "["+nama+"]["+harga+"]["+kode+"]";  
    }
}




