package mix;


public class Nov20 
{
    public static void main(String[] args)
    {
        int data[]={12,59,26,15,53};
        System.out.println("Bubble Sort");
        
        //menampilkan array sebelum diurutkan
        System.out.print("Data Awal : ");
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.println("");
        
        //pengurutan array memakai bubble sort
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data.length-1; j++)
            {
                if(data[j]>data[j+1])
                {
                    //tukar data
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                } //end if
            } //end loop j
        } //end loop i
        
        //menampilkan array setelah diurutkan
        System.out.print("Data Akhir : ");
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.println("");
    }
}