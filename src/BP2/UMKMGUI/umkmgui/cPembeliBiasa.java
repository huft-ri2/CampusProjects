package umkmgui;

public class cPembeliBiasa extends cPembeli{
	private String jenis = "Biasa";
	
	cPembeliBiasa(){ System.out.println("Default constructor pembeli biasa.."); }
	
	cPembeliBiasa(String id, String nm, String al){
		super(id,nm,al);
        System.out.println("Pembeli "+nm+" dibuat..");
    }
	
	public String getJenis() { return jenis; }
}
