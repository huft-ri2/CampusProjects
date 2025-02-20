package finalProject2;
public class cDaftarTransaksi {
	cTransaksi front, rear;
	int jumlah;
	
	cDaftarTransaksi() {
		front=rear=null;
		jumlah=0;
	}
	public cTransaksi getFront(){
        return front;
    }
    public cTransaksi getRear(){
        return rear;
    }
	public void tambahTransaksi(cTransaksi baru) {
		if(rear==null) {
			front=rear=baru;
		} else {
			rear.next=baru;
			rear=baru;
		}
		System.out.println("Penambahan berhasil...");
	}
	
	public void lihatTransaksi() {
		int i=1;
		System.out.println("Daftar Transaksi:");
		for(cTransaksi t=front; t!=null; t=t.next) {
			System.out.print(i+".");
			System.out.print(t.getKode()+"-");
			System.out.print(t.getPembeli()+"-");
			System.out.print(t.getBarang().getNama()+"-");
			System.out.println(t.getStatus());
		}
	} 
    public void hapusTransaksi(int nomor){
        cTransaksi t=front;
        cTransaksi prev=null;
        int i=1;
        if (nomor==1) { //hapus posisi terdepan
            if (t.next==null) {
                front=rear=null;
            } else {
                front=front.next;
                t.next=null;
            }
            System.out.println("("+t.getBarang().getNama()+") dihapus..");
        }else{
            for (; t!=null; t=t.next){
                if (i==nomor) {
                    break;
                }
                i++;
                prev=t;
            } //yg dihapus diujung belakang
            if (t.next==null) {
                rear=prev;
            } else {
                prev.next=t.next;
                t.next=null;
            }
            System.out.println("("+t.getBarang().getNama()+") dihapus..");
        }
    }
    public void sambungTransaksi(cTransaksi depan, cTransaksi belakang){
        //sambungkan transaksi
        if (rear==null) { //transaksi toko masih kosong
            front=depan;
            rear=belakang;
        } else {
            rear.next=depan;
            //update posisi rear
            rear=belakang;
        }
    }
    public void prosesTransaksi(cTransaksi t){
        t.setStatus(1);
    }
}
