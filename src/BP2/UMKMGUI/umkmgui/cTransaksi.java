package umkmgui;

public class cTransaksi {
	private String nama;
	private String noID = "-";
	private String kodeTr;
	private String kode;
	private String menu;
	private String jenis = "Umum";
	private int jumlah;
	private int harga;//harga total (harga satuan dikali jumlah)
	private int biaya;//biaya akhir yang harus dibayar
	public boolean dptDk;
	
	cTransaksi(){
		System.out.println("Transaksi dibuat...");
	}
	
	cTransaksi(String k, String m, int j, int h){
		kode=k; menu=m; jumlah=j; harga=h;
		System.out.println("Object pembelian dibuat...");
	}
	
	cTransaksi(String kt, String id, String n, String jn, int h, int b) {
		kodeTr=kt; noID=id; nama=n; jenis=jn; harga=h; biaya=b;
	}
	
	public void setNama(String n) { nama = n; }
	public void setID(String id) { noID = id; }
	public void setJenis(String jn) { jenis = jn; }
	public void setKodeTr(String ktr) { kodeTr = ktr; }
	public void setKode(String k) { kode = k; }
    public void setMenu(String m) { menu = m; }
	public void setBiaya(int b) { biaya = b; }
    public void setJumlah(int j) { jumlah = j; }
	public void setHarga(int h) { harga = h; }
	public String getNama() { return nama; }
	public String getJenis() { return jenis; }
	public String getID() { return noID; }
	public String getKodeTr() { return kodeTr; }
	public String getKode() { return kode; }
    public String getMenu() { return menu; }
    public int getJumlah() { return jumlah; }
	public int getBiaya() { return biaya; }
	public int getHarga() { return harga; }
	
	public String transaksiToString() {
		return "["+kodeTr+"]         ["+noID+"]      ["+nama+"]   ["+jenis+"]   ["+harga+"]       ["+biaya+"]";
	}
}
