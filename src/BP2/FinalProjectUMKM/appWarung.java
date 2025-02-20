import java.util.Scanner;
import java.util.Set;
public class appWarung {
    public static void main(String[] args) {
        cMenu m1 = new cMenu();
        cMenu m2 = new cMenu("Mi Telor",5000,10);
        cPembeli pb = new cPembeli();
        cTransaksi tr = new cTransaksi();
        Scanner sc = new Scanner(System.in);
        int pilih=0;
        do{
            System.out.println("\nWARMINDO");
            System.out.println("1. Menu");
            System.out.println("2. Pembeli");
            System.out.println("3. Transaksi");            
            System.out.println("4. Exit");
            System.out.print("Pilih = ");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.println("Menu");
                    System.out.println("  1. Tambah");
                    System.out.println("  2. Ubah");
                    System.out.println("  3. Hapus");
                    System.out.println("  4. Lihat");
                    System.out.print("  Pilih = ");
                    int pilih2=sc.nextInt();
                    switch(pilih2){
                        case 1:
                            System.out.print("   Nama   = ");
                            String nm=sc.next();
                            System.out.print("   Harga  = ");
                            int hg=sc.nextInt();
                            System.out.print("   Diskon = ");
                            int dk=sc.nextInt();
                            m2 = new cMenu(nm,hg,dk);
                            break;
                        case 2:
                            System.out.print("   Harga Baru  = ");
                            hg=sc.nextInt();
                            System.out.println("   Yakin Ubah? ");
                            System.out.println("    1. Ya ");
                            System.out.println("    2. Tidak ");
                            System.out.print("    Jawab = ");
                            int jwb=sc.nextInt();
                            if (jwb==1){
                                m2.setHarga(hg);
                                System.out.println("    Ubah Berhasil..");
                            }else{
                                System.out.println("    Ubah Batal!");
                            }
                            break;
                        case 3:
                            System.out.print("   Nama = ");
                            sc=new Scanner (System.in);
                            nm=sc.nextLine();
                            if(nm.equalsIgnoreCase(m2.getNama())){
                                m2=null;
                                System.out.println("   Hapus Berhasil..");
                            }else{
                                System.out.println("   Menu tidak ada!");
                            }
                            break;
                        case 4:
                            if(m2!=null){
                                System.out.println(m2.ToString());
                            }else{
                                System.out.println("Menu Kosong!");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("[Data Pembeli]");
                    break;
                case 3:
                    System.out.println("[Transaksi]");
                    System.out.print("Pembeli = ");
                    String pembeli = sc.next();
                    pb.setNama(pembeli);
                    tr.setPembeli(pb);
                    do {
                        System.out.println("1. Tambah");
                        System.out.println("2. Ubah");
                        System.out.println("3. Hapus");
                        System.out.println("4. Selesai");
                        System.out.print("Pilih = ");
                        pilih2 = sc.nextInt();
                        switch(pilih2){
                            case 1:
                                System.out.println("Daftar Menu");
                                System.out.println("1. Mie Telor [8000]");
                                System.out.println("2. Mie Rebus [5000]");
                                System.out.println("3. Mie Goreng [7000]");
                                System.out.println("4. Mie Jakarta [10000]");
                                System.out.print("Pilih = ");
                                int pilih3 = sc.nextInt();
                                switch(pilih3){
                                    case 1:
                                        m1= new cMenu("Mie Telor",8000,0);
                                        break;
                                    case 2:
                                        m1= new cMenu("Mie Rebus",5000,0);
                                        break;
                                    case 3:
                                        m1= new cMenu("Mie Goreng",7000,0);
                                        break;
                                    case 4:
                                        m1= new cMenu("Mie Jakarta",10000,0);
                                        break;
                                }
                                System.out.print("Jumlah  = ");
                                int jum= sc.nextInt();
                                tr.tambahMenu(m1, jum);
                                tr.lihatMenu();
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                System.out.println("Hapus Menu = ");
                                sc= new Scanner(System.in);
                                String hps= sc.nextLine();
                                tr.hapusMenu(hps);
                                tr.lihatMenu();
                                break;
                            case 4:
                                System.out.println("Kembali...");
                                break;
                        }
                    } while (pilih2!=4);
                    
                    /*
                    System.out.println("Transaksi");
                    System.out.println("  1. Tambah");
                    System.out.println("  2. Ubah");
                    System.out.println("  3. Hapus");
                    System.out.println("  4. Lihat");
                    System.out.print("  Pilih = ");
                    pilih2 = sc.nextInt();
                    switch(pilih2){
                        case 1:
                            System.out.print("Nama = ");
                            String pbl = sc.next();
                            pb.setNama(pbl);
                            System.out.print("Menu = ");
                            sc = new Scanner (System.in);
                            String mn = sc.nextLine();
                            if(mn.equalsIgnoreCase(m2.getNama())){
                                System.out.print("Jumlah = ");
                                int jum = sc.nextInt();
                                int total = jum*m2.getHarga();
                                tr.setPembeli(pb);
                                tr.setMenu(m2);
                                tr.setJumlah(jum);
                                tr.setTotal(total);
                                System.out.println("Tambah Sukses...");
                            }else{
                                System.out.println("Menu tidak ada...");
                            }
                            break;
                        case 2:
                            if(tr.getMenu()!=null){
                                System.out.print("Nama Menu = ");
                                sc = new Scanner (System.in);
                                mn = sc.nextLine();
                                if(mn.equalsIgnoreCase(tr.getMenu().getNama())){
                                    System.out.print("Jumlah Baru = ");
                                    int jb = sc.nextInt();
                                    tr.setJumlah(jb);
                                    tr.setTotal(jb*tr.getMenu().getHarga());
                                    System.out.println("Ubah Sukses...");
                                }else{
                                    System.out.println("Menu tidak ada!");
                                }
                            }else{
                                System.out.println("Menu kosong!");
                            }
                            break;
                        case 3:
                            break;
                        case 4:
                            if(tr!=null){
                                System.out.println("Nama   : "+tr.getPembeli().getNama());
                                System.out.println("Menu   : "+tr.getMenu().getNama());
                                System.out.println("Jumlah : "+tr.getJumlah());
                                System.out.println("Total  : "+tr.getTotal());
                            }else{
                                System.out.println("Transaksi kosong!");
                            }
                            break;
                    }
                    */
                    break;
                case 4:
                    System.out.println("Terima Kasih..");
                    break;
            }
        }while(pilih!=4);
    }
}
