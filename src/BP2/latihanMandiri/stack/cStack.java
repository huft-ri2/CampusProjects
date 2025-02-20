package stack;
public class cStack {
    
    cSimpul top, bottom;
    int jumlah, maks;
    cStack(){
        jumlah=0;
        maks=100;
    }
    void push(String j){ //tambah depan
        if(jumlah<maks){
            cSimpul baru = new cSimpul(j);
            if(top==null){
                top=bottom=baru; 
            }else{
                baru.next=top; 
                top.prev=baru; 
                top=baru;
            }
            jumlah++; 
            tampil(); 
        }else{
            System.out.println("Stack sdh penuh!");
        }
    }
    String pop(){
        String t="";
        if(jumlah>0){ 
            cSimpul temp = top;
            if(top.next==null){ 
                top=bottom=null; 
            }else{ 
                top=top.next; 
                top.prev=null; 
                temp.next=null;
            }
            jumlah--; 
            tampil(); 
            t=temp.data;
        }else{
            System.out.println("Stack sudah kosong!");
        }
        return t;
    }
    void tampil(){
        System.out.println("Isi STACK: ");
        for(cSimpul t=top; t!=null; t=t.next){
            System.out.println("["+t.data+"]");
        }
    }
}
