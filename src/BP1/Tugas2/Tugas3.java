package Tugas2;

public class Tugas3 {
    public static void main(String[] args){
        boolean[] b1={true,false,false,false,true};
        boolean[] b2={false,true,false,true,false};
        boolean[] b3={false,false,true,false,false};
        boolean[] b4={false,true,false,true,false};
        boolean[] b5={true,false,false,false,true};
        for (int i = 0; i < 5; i++){
            if(b1[i]==true) System.out.print("G");
            else System.out.print(" ");
        } System.out.println("");
        for (int i = 0; i < 5; i++){
            if(b2[i]==true) System.out.print("G");
            else System.out.print(" ");
        } System.out.println("");
        for (int i = 0; i < 5; i++){
            if(b3[i]==true) System.out.print("G");
            else System.out.print(" ");
        } System.out.println("");
        for (int i = 0; i < 5; i++){
            if(b4[i]==true) System.out.print("G");
            else System.out.print(" ");
        } System.out.println("");
        for (int i = 0; i < 5; i++){
            if(b5[i]==true) System.out.print("G");
            else System.out.print(" ");
        } System.out.println("");
    }
}
