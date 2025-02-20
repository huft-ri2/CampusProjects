public class cPembeli {
    private String nama;
    private String alamat;
    cPembeli(){
        System.out.println("Pembeli dibuat...");
    }
    cPembeli(String n){
        nama=n;
        System.out.println("Pembeli "+nama+" dibuat..");
    }
    public void setNama(String n) { nama = n; }
    public void setAlamat(String alt) { alamat = alt; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
}
