package mix;


public class Des11 {

    public static void main(String[] args) {
        // Mendefinisikan array 3 dimensi dengan ukuran tertentu
        int[][][] array3D = new int[3][3][3];

        // Mengisi array dengan nilai acak
        fillArray(array3D);

        // Menampilkan isi array 3 dimensi
        displayArray(array3D);
    }

    // Metode untuk mengisi array 3 dimensi dengan nilai acak
    private static void fillArray(int[][][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    array[i][j][k] = (int) (Math.random() * 100);
                }
            }
        }
    }

    // Metode untuk menampilkan isi array 3 dimensi
    private static void displayArray(int[][][] array) {
        System.out.println("Isi Array 3 Dimensi:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println(); // Pindah ke baris baru setelah setiap baris kedua
            }
            System.out.println(); // Pindah ke blok baru setelah setiap blok kedua
        }
    }
}
