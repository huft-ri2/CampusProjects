package queue;
public class cQueue {
    cObjek front, rear;
    int size;
    cQueue(){
        front=rear=null;
        size=0;
    }
    public void enqueue(cObjek baru){
        if(rear==null){
            front=rear=baru;
            size++;
        }else{
            rear.next=baru;
            baru.prev=rear;
            rear=baru;
            size++;
        }
        System.out.println("(Enqueue Sukses...)");
    }
    public cObjek dequeue(){
        cObjek t=front;
        if(front==null){
            System.out.println("(Queue Kosong...)");
            return(null);
        }else if(front.next==null){
            System.out.println("(Dequeue "+t.getNama()+" Sukses...)");
            t=rear;
            front=rear=null;
            System.out.println("(Dequeue Sukses...)");
            size--;
            return(t);
        }else{
            System.out.println("(Dequeue "+t.getNama()+" Sukses...)");
            t=front.next;
            front.next=null;
            front=t;
            front.prev=null;
            size--;
            return(t);
        }
    }
    public void show(){
        if(size<1){
            System.out.println("(Queue Kosong!!)");
        }else{
            int x=1;
            System.out.println("==================== ISI QUEUE ====================");
            for (cObjek t = front; t!=null; t=t.next) {
                System.out.println(x+". "+t.getNama()+"\t["+t.getHarga()+"]");
                x++;
            }
            System.out.println("===================================================");
        }
    }
}
