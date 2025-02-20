package finalProject2;
import java.util.Scanner;
public class appToko {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cBarang brg1 = new cBarang("Laptop", 10000);
		cBarang brg2 = new cBarang("HP", 4000);
		cBarang brg3 = new cBarang("Printer", 2000);
		cBarang brg4 = new cBarang("AC", 3000);
		cBarang brg5 = new cBarang("Tablet", 5000);
		cDaftarTransaksi jual = new cDaftarTransaksi();
		int pilih, pilih2, pilih3;
		int kode=100, jumlah;
		
		do{
			System.out.println("\nToko 'HARTANTO' Elektronik "
							+"\n1. Pembeli"
							+"\n2. Member"
							+"\n3. Admin"
							+"\n4. Pemilik"
							+"\n5. Exit");
			System.out.print("Pilih = ");
			pilih = sc.nextInt();
			switch(pilih){
				case 1://Pembeli
					kode++;
					cDaftarTransaksi beli = new cDaftarTransaksi();
					System.out.print("Masukkan Nama = ");
					String nama=sc.next();
					do{
						System.out.println("Akun Pembeli"
										+"\n1. Tambah"
										+"\n2. Hapus"
										+"\n3. Lihat"
										+"\n4. Kembali");
						System.out.print("Pilih = ");
						pilih2=sc.nextInt();
						switch(pilih2){
							case 1: //tambah
								cTransaksi br=null;
								System.out.println("Daftar Barang: "
												+"\n1. Laptop"
												+"\n2. HP"
												+"\n3. Printer"
												+"\n4. AC"
												+"\n5. Tablet");
								System.out.print("Pilih = ");
								pilih3=sc.nextInt();
								System.out.print("Jumlah = ");
								jumlah=sc.nextInt();
								if(pilih3==1) {
									br = new cTransaksi(String.valueOf(kode), nama, brg1, jumlah, 0);
								} else if (pilih3==2) {
									br = new cTransaksi(String.valueOf(kode), nama, brg2, jumlah, 0);
								} else if (pilih3==3) {
									br = new cTransaksi(String.valueOf(kode), nama, brg3, jumlah, 0);
								} else if (pilih3==4) {
									br = new cTransaksi(String.valueOf(kode), nama, brg4, jumlah, 0);
								} else if (pilih3==5) {
									br = new cTransaksi(String.valueOf(kode), nama, brg5, jumlah, 0);
								}
								beli.tambahTransaksi(br);
								break;
							case 2: //hapus
                            	beli.lihatTransaksi();
                                System.out.print("Hapus Nomor = ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
								break;
							case 3:
								beli.lihatTransaksi();
								break;
							case 4:
                                //selesai. sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Selamat Datang kembali..");
								break;
						}
					}while(pilih2!=4);
					break;
				case 2://Member
					break;
				case 3://Admin
                    jual.lihatTransaksi();
                    // memproses setiap transaksi yg blm diproses
                    cTransaksi t=jual.getFront();
                    do {
                        if (t.getStatus()==0) {
                            System.out.println("Kode : "+t.getKode());
                            System.out.println("Pembeli : "+t.getPembeli());
                            System.out.println("Barang : "+t.getBarang().getNama());
                            System.out.println("Jumlah : "+t.getJumlah());
                            System.out.println("-Pilih Aksi-");
                            System.out.println("1. Diproses");
                            System.out.println("2. Selesai");
                            System.out.print("Pilih = ");
                            int aksi=sc.nextInt();
                            if (aksi==1) {
                                jual.prosesTransaksi(t);
                                System.out.println("Berhasil diproses..");
                            } else {
                                break;
                            }
                        }
                        t=t.next;
                    }while (t!=null);
					break;
				case 4://Pemilik
					break;
				case 5:
					System.out.println("Terima Kasih...");
					break;
			}
		}while(pilih!=5);
	}
	
}
