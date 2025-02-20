package Tugas2;

import java.util.Scanner;
public class Tugas2 {

    public static void main(String[] args){
        
        //input
        Scanner t2 = new Scanner (System.in);
        System.out.println("Penghitung Berat Badan Ideal Anda");
        System.out.println(" ");
        
        System.out.print("Silahkan Masukkan Berat Badan Anda (dalam KG) : ");
        int bb = t2.nextInt();
        System.out.print("Silahkan Masukkan Tinggi Badan Anda (dalam CM) : ");
        int tb = t2.nextInt();
        System.out.println(" ");
        
        System.out.print("Silahkan Pilih Jenis Kelamin Anda\n 1. Laki-laki = 1\n 2. Perempuan = 2\n Jawaban Anda : ");
        int jk = t2.nextInt();
        switch (jk){
            case 1:
                System.out.println("Jenis Kelamin Anda : Laki-Laki");
                break;
            
            case 2:
                System.out.println("Jenis Kelamin Anda : Perempuan");
                break;
            
            default: System.out.println("Pilihan Anda tidak tersedia");
        }
        System.out.println(" ");
        
        System.out.print("Silahkan Masukkan Umur Anda : ");
        int umur = t2.nextInt();
        System.out.println(" ");
        
        System.out.print("Silahkan Pilih Jenis Pengukur Berat Badan Ideal\n 1. Broca Formula = 1\n 2. BMI Formula = 2\n Jawaban Anda : ");
        int PbbIdeal = t2.nextInt();
        System.out.println(" ");
        
        switch (PbbIdeal){
            case 1:
                System.out.println("Pengukuran Berat Badan dengan Broca Formula");
                System.out.println(" ");
                
                //Rumus Broca
                if (jk <= 1) {
                    int brocaLk = (tb-100)-((tb-100)*10/100);
                    System.out.println("Berat Badan Ideal Untuk Laki-Laki (dalam KG) : "+brocaLk);
                    
                    if (bb < brocaLk){
                        System.out.println("Berdasarkan Broca Formula berat badan anda adalah dibawah berat bedan ideal");
                    }else if (brocaLk == bb){
                        System.out.println("Berdasarkan Broca Formula berat badan anda adalah merupakan berat bedan ideal");
                    }else if (bb > brocaLk){
                        System.out.println("Berdasarkan Broca Formula berat badan anda adalah diatas berat bedan ideal");
                    }
                    
                }else if (jk >= 2){
                    int brocaPr = (tb-100)-((tb-100)*15/100);
                    System.out.println("Berat Badan Ideal Untuk Perempuan (dalam KG) : "+brocaPr);
                    
                    if (bb < brocaPr){
                        System.out.println("Berdasarkan Broca Formula berat badan anda adalah dibawah berat bedan ideal");
                    }else if (brocaPr == bb){
                        System.out.println("Berdasarkan Broca Formula berat badan anda adalah merupakan berat bedan ideal");
                    }else if (bb > brocaPr){
                        System.out.println("Berdasarkan Broca Formula berat badan anda adalah diatas berat bedan ideal");
                    } 
                }
                
                break;
            
            case 2:
                System.out.println("Pengukuran Berat Badan dengan BMI Formula");
                System.out.println(" ");
                
                //Rumus BMI
                if (umur >= 20){
                    int bmi2 = bb/(tb/100);
                    System.out.println("Berat Badan Ideal Anda (dalam KG) : "+bmi2);
                    
                    if (bmi2 >= 18 & bmi2 <= 25){
                        System.out.println("Berdasarkan BMI Formula berat badan anda adalah : Normal");
                    }else if (bmi2 <= 18){
                        System.out.println("Berdasarkan BMI Formula berat badan anda adalah : Kurang");
                    }else if (bmi2 >= 25){
                        System.out.println("Berdasarkan BMI Formula berat badan anda adalah : Berlebih");
                    }
                
                }else{
                    System.out.println("Umur Anda tidak mencukupi syarat untuk menggunakan Pengukuran BMI");                    
                }
                
                break;
            
            default: System.out.println("Pilihan Anda tidak tersedia");
        }
    }   
}
