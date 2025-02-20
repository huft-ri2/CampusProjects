package mix;

public class Nov13 {
    public static void main(String[] args) {
    
    int[] nilai;
    double ipk[] = new double[5];
    int npm[] = new int[5];
    
    double rata2, jumlah=0;
    
    byte[]absen = {11,12,13,14,15};
    nilai = new int[5];
    nilai[0]=89; nilai[1]=77; nilai[2]=86; nilai[3]=75; nilai[4]=92;
    ipk[0]=3.45; ipk[1]=3.33; ipk[2]=3.18; ipk[3]=3.21; ipk[4]=3.76;
    npm[0]=101; npm[1]=102; npm[2]=103; npm[3]=104; npm[4]=105;
    System.out.println("DATA MAHASISWA");
    System.out.println("Absen   Nilai   IPK   NPM");
    System.out.print(absen[3]+"      ");
    System.out.print(nilai[3]+"      ");
    System.out.print(ipk[3]+"  ");
    System.out.println(npm[3]);
    System.out.println("");
    
    for (int i = 0; i < 5; i++){
        jumlah = jumlah + ipk[i];
    }
    rata2 = (double)jumlah/5;
    System.out.println("Rata-Rata IPK : "+rata2);
    
    }
}
