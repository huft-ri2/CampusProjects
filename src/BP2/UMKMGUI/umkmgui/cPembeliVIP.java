package umkmgui;

public class cPembeliVIP extends cPembeli{
	private String jenis = "VIP";
	private double dskn = 0.1;
	
	cPembeliVIP(){ System.out.println("Default constructor pembeli VIP..");	}
	
	cPembeliVIP(String id, String nm, String al){
		super(id,nm,al);
        System.out.println("Pembeli "+nm+" dibuat..");
    }

	public String getJenis() { return jenis; }
	public double getDiskon() { return dskn; }
}
