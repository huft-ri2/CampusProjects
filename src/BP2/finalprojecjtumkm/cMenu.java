public class cMenu {
    private String nama;
    private int harga,diskon;

    cMenu () {
        System.out.println("Default constructor menu..");
    }
    cMenu (String n, int h, int d) {
        nama=n; harga=h; diskon=d;
        System.out.println("Object "+nama+" dibuat..");
    }
    public void setHarga(int h) { harga=h; }
    public void setDiskon(int d) { diskon=d; }
    public String getNama() { return nama;}
    public int getHarga() {return harga;}
    public int getDiskon() {return diskon;}
    public String ToString() {
        return "["+nama+"] ["+harga+"] ["+diskon+"]";
    }
}
