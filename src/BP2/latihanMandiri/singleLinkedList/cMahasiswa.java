package singleLinkedList;
public class cMahasiswa {
    private String nama, alamat;
    private int NPM;
    cMahasiswa(String n, int npm, String a){
        nama=n; NPM=npm; alamat=a;
    }
    public String getNama(){
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public int getNPM(){
        return NPM;
    }
}
