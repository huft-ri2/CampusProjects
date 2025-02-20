package umkmgui;

public class cPembeli {
	private String noID;
    private String nama;
    private String alamat;
	
    cPembeli(){
        System.out.println("Pembeli dibuat...");
    }
    cPembeli(String id, String nm, String al){
        noID=id; nama=nm; alamat=al;
        System.out.println("Pembeli "+nama+" dibuat..");
    }
	public void setID(String id) { noID = id; }
    public void setNama(String nm) { nama = nm; }
    public void setAlamat(String al) { alamat = al; }
	public String getID() { return noID; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
}
