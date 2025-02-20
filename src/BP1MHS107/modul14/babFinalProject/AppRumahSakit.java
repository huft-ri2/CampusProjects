package BP1MHS107.modul14.babFinalProject;
import java.util.Scanner;
public class AppRumahSakit {
    //deklarasi variable2 global
    static Scanner sc = new Scanner(System.in);
    //asumsi maksimal 50 pasien; menyimpan 6 data;
    //kode, nama, umur, asal, sakit, status peserta
    static String pasien [][] = new String [50][6];
    static int jumPasien = 0;

    static void rawatJalan(String kd, String nm, String um, String as, String skt, String st){
        if(jumPasien>=50){
            System.out.println("Kapasitas Penuh!!!");
        } else {
            pasien[jumPasien][0]=kd;
            pasien[jumPasien][1]=nm;
            pasien[jumPasien][2]=um;
            pasien[jumPasien][3]=as;
            pasien[jumPasien][4]=skt;
            pasien[jumPasien][5]=st;
            System.out.println("Pencatatan Berhasil!!!");
            jumPasien++;
        }
    }

    static String[][] urutkan(String[][] data, int kolom){
        for (int i=0; i<jumPasien-1; i++){
            for(int j=i+1; j<jumPasien; j++){
                if(data[i][kolom].compareToIgnoreCase(data[j][kolom])>0){
                    //tukar nama
                    String temp1 = data[i][1];
                    data[i][1]=data[j][1];
                    data[j][1]=temp1;
                    //tukar umur
                    String temp2 = data[i][2];
                    data[i][2]=data[j][2];
                    data[j][2]=temp2;
                    //tukar asal
                    String temp3 = data[i][3];
                    data[i][3]=data[j][3];
                    data[j][3]=temp3;
                }
            }
        }
        //copy kolom2 array yg sdh diurutkan
        //ke array penampungan yg baru
        //asumsi hanya 3 kolom yg diakses
        String hasil[][] = new String[jumPasien][3];
        for (int i=0; i<jumPasien; i++){
            hasil[i][0]=data[i][1]; //nama
            hasil[i][1]=data[i][2]; //umur
            hasil[i][2]=data[i][3]; //asal
        }
        return hasil;
    }
    
    static void cetakUrut(String d[][]){
        for (int i=0; i<jumPasien; i++){
            System.out.print((i+1)+". "+d[i][0]);
            System.out.print(", "+d[i][1]);
            System.out.println(" thn, "+d[i][2]);
        }
    }

    static void urutNama(){
        String pas[][] = urutkan(pasien, 1);
        System.out.println("Urut Nama");
        cetakUrut(pas);
    }

    static void urutUmur(){
        String pas[][] = urutkan(pasien, 2);
        System.out.println("Urut Umur");
        cetakUrut(pas);
    }

    static void urutAsal(){
        String pas[][] = urutkan(pasien, 3);
        System.out.println("Urut Asal");
        cetakUrut(pas);
    }

    static void rekap(){
        System.out.println("==Rekap Data Pasien==");
        System.out.println("No.\tKode\tNama\tUmur\tAsal\tSakit\tPeserta");
        for (int i=0; i<jumPasien; i++){
            System.out.print((i+1)+"\t");
            System.out.print(pasien[i][0]+"\t");
            System.out.print(pasien[i][1]+"\t");
            System.out.print(pasien[i][2]+"\t");
            System.out.print(pasien[i][3]+"\t");
            System.out.print(pasien[i][4]+"\t");
            System.out.println(pasien[i][5]+"\t");
        }
        System.out.println("");
        int p;
        do{
            System.out.println("[[Urutkan berdasar]]");
            System.out.println("1. Nama\n2. Umur\n3. Asal");
            System.out.print("pilih : ");
            p = sc.nextInt();
            switch (p){
                case 1: urutNama(); break;
                case 2: urutUmur(); break;
                case 3: urutAsal(); break;
            }
        } 
        while(p<=3);
    }

    static void cari(String nm){
        boolean ketemu=false;
        for(int i=0; i<jumPasien; i++){
            if(pasien[i][1].contains(nm)){
                System.out.print(pasien[i][1]+" "+pasien[i][2]+" thn");
                System.out.print(" asal"+pasien[i][3]);
                ketemu=true;
            }
        }
        if(ketemu==false){
            System.out.println("Pasien tidak ditemukan!!!");
        }
    }

    static void cetakGrafis(int x){
        for(int i=0; i<x; i++){
            System.out.print("X");
        }
        System.out.println("");
    }

    static void umurStat(){
        int k1=0; //0-10 thn
        int k2=0; //11-17 thn
        int k3=0; //18-40 thn
        int k4=0; //41-60 thn
        int k5=0; //61 thn lebih

        //hitung jumlahnya dulu
        for(int i=0; i<jumPasien; i++){
            if(Integer.parseInt(pasien[i][2])>=61)
                k5++;
            else if(Integer.parseInt(pasien[i][2])>=41)
                k4++;
            else if(Integer.parseInt(pasien[i][2])>=18)
                k3++;
            else if(Integer.parseInt(pasien[i][2])>=11)
                k2++;
            else if(Integer.parseInt(pasien[i][2])>=0)
                k1++;
        }
        System.out.println("==Grafik Usia Pasien==");
        System.out.print(">=61 thn ");
        cetakGrafis(k5);
        System.out.print("41-60 thn ");
        cetakGrafis(k4);
        System.out.print("18-40 thn ");
        cetakGrafis(k3);
        System.out.print("11-17 thn ");
        cetakGrafis(k2);
        System.out.print("0-10 thn ");
        cetakGrafis(k1);
    }

    static void asalStat(){
        int k1=0; //SBY
        int k2=0; //SDA
        int k3=0; //MJK
        int k4=0; //GRS
        int k5=0; //LAIN

        //hitung jumlahnya dulu
        for(int i=0; i<jumPasien; i++){
            if(pasien[i][3].compareToIgnoreCase("SBY")==0)
                k1++;
            else if(pasien[i][3].compareToIgnoreCase("SDA")==0)
                k2++;
            else if(pasien[i][3].compareToIgnoreCase("MJK")==0)
                k3++;
            else if(pasien[i][3].compareToIgnoreCase("GRS")==0)
                k4++;
            k5=jumPasien-(k1+k2+k3+k4);
        }
        System.out.println("==Grafik Asal Pasien==");
        System.out.print("Surabaya ");
        cetakGrafis(k1);
        System.out.print("Sidoarjo ");
        cetakGrafis(k2);
        System.out.print("Mojokerto ");
        cetakGrafis(k3);
        System.out.print("Gresik ");
        cetakGrafis(k4);
        System.out.print("Lainnya ");
        cetakGrafis(k5);
    }

    static void sakitStat(){
        int k1=0; //Pusing
        int k2=0; //Mual
        int k3=0; //Diare
        int k4=0; //Batuk
        int k5=0; //Lainnya

        //hitung jumlahnya dulu
        for(int i=0; i<jumPasien; i++){
            if(pasien[i][4].compareToIgnoreCase("Pusing")==0)
                k1++;
            else if(pasien[i][4].compareToIgnoreCase("Mual")==0)
                k2++;
            else if(pasien[i][4].compareToIgnoreCase("Diare")==0)
                k3++;
            else if(pasien[i][4].compareToIgnoreCase("Batuk")==0)
                k4++;
            k5=jumPasien-(k1+k2+k3+k4);
        }
        System.out.println("==Grafik Sakit Pasien==");
        System.out.print("Pusing ");
        cetakGrafis(k1);
        System.out.print("Mual ");
        cetakGrafis(k2);
        System.out.print("Diare ");
        cetakGrafis(k3);
        System.out.print("Batuk ");
        cetakGrafis(k4);
        System.out.print("Lainnya ");
        cetakGrafis(k5);
    }

    static void pesertaStat(){
        int k1=0; //BPJS
        int k2=0; //Umum

        //hitung jumlahnya dulu
        for(int i=0; i<jumPasien; i++){
            if(pasien[i][5].compareToIgnoreCase("BPJS")==0)
                k1++;
            else if(pasien[i][5].compareToIgnoreCase("Umum")==0)
                k2++;
        }
        System.out.println("==Grafik Peserta Pasien==");
        System.out.print("BPJS ");
        cetakGrafis(k1);
        System.out.print("Umum ");
        cetakGrafis(k2);
    }

    public static void main(String[] args){
        int pilih;

        //inisialisasi data pasien
        pasien[0][0]="PSN1"; pasien[0][1]="Adi"; pasien[0][2]="21"; pasien[0][3]="SBY"; pasien[0][4]="Pusing"; pasien[0][5]="BPJS";
        pasien[1][0]="PSN2"; pasien[1][1]="Abi"; pasien[1][2]="24"; pasien[1][3]="SBY"; pasien[1][4]="Mual"; pasien[1][5]="BPJS";
        pasien[2][0]="PSN3"; pasien[2][1]="Adim"; pasien[2][2]="31"; pasien[2][3]="SDA"; pasien[2][4]="Diare"; pasien[2][5]="Umum";
        pasien[3][0]="PSN4"; pasien[3][1]="Budi"; pasien[3][2]="44"; pasien[3][3]="GRS"; pasien[3][4]="Gatal"; pasien[3][5]="BPJS";
        pasien[4][0]="PSN5"; pasien[4][1]="Adi"; pasien[4][2]="11"; pasien[4][3]="MJK"; pasien[4][4]="Batuk"; pasien[4][5]="Umum";
        jumPasien=5;

        do{
            System.out.println("MENU PASIEN RS SEHAT");
            System.out.println("1. Rekam Rawat Jalan");
            System.out.println("2. Statistik Umur");
            System.out.println("3. Statistik Asal");
            System.out.println("4. Statistik Jenis Sakit");
            System.out.println("5. Statistik Jenis Peserta");
            System.out.println("6. Rekap Pasien");
            System.out.println("7. Cari Pasien");
            System.out.println("8. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();

            switch(pilih){
                case 1: 
                    System.out.println("==Pasien Rawat Jalan==");
                    String kode="PNS".concat(String.valueOf(jumPasien+1));
                    System.out.print("Nama = ");
                    String nama = sc.next();
                    System.out.print("Umur = ");
                    String umur = sc.next();
                    System.out.print("Daerah Asal = ");
                    System.out.print("[SBY][SDA][MJK]");
                    System.out.println("[GRS][LAIN]");
                    String asal = sc.next();
                    System.out.print("Jenis Sakit = ");
                    System.out.print("[Pusing][Mual][Diare]");
                    System.out.println("[Batuk][Lainnya]");
                    String sakit = sc.next();
                    System.out.print("BPJS/Umum = ");
                    String status = sc.next();
                    rawatJalan(kode,nama,umur,asal,sakit,status);
                    break;

                case 2:
                    umurStat();
                    break;

                case 3:
                    asalStat();
                    break;
                    
                case 4:
                    sakitStat();
                    break;
                    
                case 5:
                    pesertaStat();
                    break;

                case 6:
                    rekap();
                    break;
                    
                case 7:
                    System.out.println("==Cari Nama Pasien==");
                    System.out.print("Masukkan Nama = ");
                    nama = sc.next();
                    cari(nama);
                    break;

                case 8:
                    System.out.println("Terima Kasih!!!");
                    break;
            }
            System.out.println("");
        }while(pilih!=8);
    }
}
