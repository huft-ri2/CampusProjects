package queueLatihan;
public class cPesanan {
    private String menu;
    private int jumlah;
    cPesanan prev,next;
    cPesanan(){
        System.out.println("Pesanan dibuat.....");
    }
    cPesanan(String m, int j){
        menu=m; jumlah=j;
        System.out.println("Pesanan "+menu+" dibuat.....");
    }
    public String getMenu(){ return menu; }
    public int getJumlah(){ return jumlah; }
}
