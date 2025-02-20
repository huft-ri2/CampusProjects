package mix;

import java.util.Scanner;
public class Octo30 {
    public static void main(String[] args)
    /*{
        Scanner s = new Scanner (System.in);
        int bilangan, counter;
        char next;
        System.out.println("Program Deret Angka");
        System.out.print("Masukkan Angka = ");
        bilangan = s.nextInt();
        
        System.out.print("Deret Angkanya : ");
        counter = 1;
        while (counter <= bilangan){
            if (counter == 4){
                System.out.print("3a ");
            }else if(counter == 13){
                System.out.print("12a ");
            }else{
                System.out.print(" ");
            }
            System.out.print(counter+" ");
            
            System.out.println(" ");   
            System.out.print("Apakah anda ingin lanjut (y/n) : ");
            next = s.next().charAt(0);
            if (next == 'y'){
                counter++;
            }else{
                break;
            }
        }
        
        System.out.println(" ");
    }*/
    {
        Scanner s = new Scanner (System.in);
        int bilangan, counter, jumlah, kali;
        System.out.println("Program Deret Angka");
        System.out.print("Masukkan Angka = ");
        bilangan = s.nextInt();
        System.out.print("Deret Angkanya : ");
        counter = 1;
        jumlah = 0;
        kali = 1;
        while (counter <= bilangan){
            System.out.print(counter+" ");
            if (counter < bilangan){
                System.out.print("+ ");
            }
            jumlah = jumlah + counter;
            kali = kali * counter;
            counter++;
        }
        System.out.println("= "+jumlah);
        System.out.println(" ");
        System.out.println("Hasil jumlah deretnya : "+jumlah);
        System.out.println("Hasil kali deretnya : "+kali);
        System.out.println(" ");
    }
}
