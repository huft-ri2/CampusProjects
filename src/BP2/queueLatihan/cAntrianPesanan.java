package queueLatihan;
public class cAntrianPesanan {
    cPesanan front, rear;
    int jumlah, maks;
    cAntrianPesanan(){
        System.out.println("Antrian dibuat.....");
    }
    cAntrianPesanan(int kapasitas){
        maks=kapasitas;
        System.out.println("Antrian "+maks+" dibuat.....");
    }
    public void enqueue(String m, int j){
        if(jumlah<maks){
            cPesanan baru = new cPesanan (m, j);
            if(jumlah==0){
                front=rear=baru;
            }else{
                baru.next=rear;
                rear.prev=baru;
                rear=baru;
            }
            jumlah++;
            System.out.println("Enqueue sukses...");
        }else{
            System.out.println("Antrian Penuh!");
        }
    }
    public void show(){
        System.out.print("Isi antrian:");
        if(jumlah==0){
            System.out.println("Kosong");
        }else{
            for (cPesanan t = rear; t!=null; t=t.next) {
                System.out.println("("+t.getMenu()+")");
            }
            System.out.println("");
        }
    }
    public void dequeue(){
        if (jumlah==0) {
            System.out.println("Antrian Kosong");
        }else{
            if (jumlah==1) {
                front=rear=null;
            }else{
                cPesanan t = front.prev;
                front.prev = null;
                front = t;
            }
            jumlah--;
            System.out.println("Dequeue sukses!");
        }
    }
}
