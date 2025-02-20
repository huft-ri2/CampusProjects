package umkmgui;

public class CTrans {
    private int nomor;
    private String tanggal;
    private cPembeli pembeli;
    private cMenu menu;
    private cMenu menus[];
    private int jumMenu[]; //jumlah menu yang dibeli
    private int totMenu[];
    private int grandTotal;
    private int jm; //jumlah item menu
    private int maksm; //jumlah maksimum item menu
    private int jumlah;
    private int total;
    CTrans(){
        maksm =3; jm=0; grandTotal =0;
        menus = new cMenu[3]; jumMenu = new int[3];
        totMenu = new int[3];
        System.out.println("Objek transaksi dibuat...");   
    }
    public void tambahMenu(cMenu m, int j){
        if(jm<maksm){
            menus[jm]=m;
            jumMenu[jm]=j;
            totMenu[jm]=j*m.getHarga();
            jm++;
            System.out.println("Tambah Berhasil..");
        }else System.out.println("Keranjang Penuh!");
    }
    public void lihatMenu(){ //menampilkan daftar menu yang dibeli
        if(jm>0){
            System.out.println("Daftar Pembelian");
            for (int i = 0; i < jm; i++) {
                System.out.print((i+1)+"-"+menus[i].getNama());
                System.out.print(" ["+menus[i].getHarga());
                System.out.print("] ["+jumMenu[i]+"] ");
                System.out.println("["+totMenu[i]+"]");
            }
        }else{
            System.out.println("Keranjang Kosong!");
        }
    }
    public void hapusMenu(String m){
        boolean ketemu=false;
        for (int i = 0; i < jm; i++) {
            if(m.equalsIgnoreCase(menus[i].getNama())){
                ketemu=true;
                menus[i]=null;
                //geser elemen belakangnya
                for (int j = 0; j < jm; j++) {
                    if(j==jm-1)
                        menus[j]=null;
                    else
                        menus[j]=menus[j=1];
                }
                System.out.println("Hapus Berhasil....");
                jm--;
                break;
            }
        }
        if(ketemu==false){
            System.out.println("Menu Tidak Ada");
        }
    }
    public void setPembeli(cPembeli p){
        pembeli = new cPembeli();
        pembeli=p;
    }
    public void setMenu(cMenu m){
        menu = new cMenu();
        menu=m;
    }
    public void setJumlah(int j){ jumlah=j; }
    public void setTotal(int t){ total=t; }
    public cPembeli getPembeli(){ return pembeli; }
    public cMenu getMenu(){ return menu; }
    public int getJumlah(){ return jumlah; }
    public int getTotal(){ return total; }
     
}
