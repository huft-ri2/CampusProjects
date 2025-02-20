package mix;



public class Des11a {

    public static void main(String[] args) {
        // Mendefinisikan array 3 dimensi
        int[][][] array3D = {
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                
        };

        // Menampilkan isi array 3 dimensi
        displayArray(array3D);
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
