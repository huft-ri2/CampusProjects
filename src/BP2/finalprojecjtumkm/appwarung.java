
import java.util.Scanner;
import java.util.ArrayList;
public class appwarung {
    public static void main(String[] args) {
        cMenu m1 = new cMenu();
        cMenu m2 = new cMenu ("Nasi Goreng",20000,10);
        Scanner sc = new Scanner(System.in);
        int pilih=0, x=0;
        ArrayList<String> lihat = new ArrayList<>();
        do{
            System.out.println("\nWORANG WARUNG");
            System.out.println("1.Menu");
            System.out.println("2.Pembeli");
            System.out.println("3.Transakasi");
            System.out.println("4.Exit");
            System.out.print("pilih = ");
            pilih=sc.nextInt();
            switch(pilih) {
                case 1:
                System.out.println("[Data menu]");
                System.out.println("  1.Tambah");
                System.out.println("  2.Ubah");
                System.out.println("  3.Hapus");
                System.out.println("  4.Lihat");
                System.out.print("  Pilih = ");
                int pilih2=sc.nextInt();
                switch(pilih2){
                    case 1:
                    System.out.print("  Nama = ");
                    sc=new Scanner(System.in);
                    String nm=sc.nextLine();
                    System.out.print("  Harga = ");
                    int hg=sc.nextInt();
                    System.out.print("  Diskon = ");
                    int dk=sc.nextInt();
                    m2 = new cMenu (nm,hg,dk);
                    lihat.add(x, m2.ToString());
                    x = x + 1;
                    break;
                    case 2:
                    System.out.print("Nama yang ingin diubah harganya = ");
                    sc=new Scanner(System.in);
                    nm=sc.nextLine();
                    int indek=0;
                    for(String data : lihat){
                        if(data.contains(nm)){
                            System.out.print("  Harga baru = ");
                            hg=sc.nextInt();
                            System.out.print("  Diskon baru = ");
                            dk=sc.nextInt();
                            System.out.println("Wes yakin kah?");
                            System.out.println("  1.Iya");
                            System.out.println("  2.Batal");
                            System.out.print("  Jawab = ");
                            int jwb=sc.nextInt();
                            if (jwb==1) {
                                m2.setHarga(hg);
                                m2.setDiskon(dk);
                                m2 = new cMenu (nm,hg,dk);
                                lihat.set(indek, m2.ToString());
                                System.out.println("Berhasil Mengubah");
                            }else{
                            System.out.println("Batal Mengubah");
                            }
                        } else {
                            indek++;
                            if(indek==x){
                                System.out.println("Menu Tidak Ada");
                            }
                        }
                    }
                    
                    /*if(jwb==1){
                        m2.setHarga(hg);
                        lihat.set(x, m2.ToString());
                        System.out.print("Berhasil");
                    }
                    else{
                        System.out.print("Ubah Batal");
                    }*/
                    break;
                    case 3:
                    System.out.print("Nama yang ingin di hapus = ");
                    sc=new Scanner(System.in);
                    nm=sc.nextLine();
                    /*if(nm.equalsIgnoreCase(m2.getNama())){
                        System.out.println("Wes yakin kah?");
                        System.out.println("  1.Iya");
                        System.out.println("  2.Batal");
                        System.out.print("  Jawab = ");
                        int jwb2=sc.nextInt();
                        if (jwb2==1) {
                            //m2=null;
                            lihat.remove(x-1);
                            System.out.println("Berhasil Menghapus");
                        }
                        else{
                        System.out.println("Batal Menghapus");
                        }
                    }
                    else{
                        System.out.println("Menu Tidak Ada");
                    }*/
                    int index=0;
                    for(String data : lihat) {
                        if(data.contains(nm)){
                            System.out.println("Wes yakin kah?");
                            System.out.println("  1.Iya");
                            System.out.println("  2.Batal");
                            System.out.print("  Jawab = ");
                            int jwb2=sc.nextInt();
                            if (jwb2==1) {
                                //m2=null;
                                lihat.remove(index);
                                System.out.println("Berhasil Menghapus");
                            }else{
                            System.out.println("Batal Menghapus");
                            }
                        } else {
                            index++;
                            if(index==x){
                                System.out.println("Menu Tidak Ada");
                            }
                        }
                    }
                    break;
                    case 4:
                    if(m2!=null) {
                        System.out.println("Menu terakhir yang dipesan:");
                        System.out.println(m2.ToString());
                        System.out.println("Daftar semua menu yang telah dipesan:");
                        int indeks=1;
                        for(String data : lihat) {
                            System.out.println(String.format("[%d] %s", indeks, data));
                            indeks++;
                        }
                    } else
                    System.out.println("Menu Kosong!");
                }
                break;
                case 2:
                System.out.println("[Master Pembeli]");

                break;
                case 3:
                System.out.println("[Transaksi]"
                                +"\n1. Cetak Struk"//Menampilkan ringkasan pembelian 1 pembeli
                                +"\n2. Rincian Data Pembelian");//Menampilkan semua data para pembeli
                System.out.print("Pilih:");
                int pilihtra=sc.nextInt();
                switch (pilihtra) {
                    case 1:
                        System.out.println("=====Worang Warung====="
                                        +"\nJl. Embong Gedhe No.67"
                                        +"\nTelp. 123456789 - FAX -"
                                        +"\n-----------------------"
                                        +"\n       Pesanan"
                                        +"\n");
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
                break;
                case 4:
                System.out.println("Matur Suwun..");
            }
      }while (pilih!=4);
    
    }
}