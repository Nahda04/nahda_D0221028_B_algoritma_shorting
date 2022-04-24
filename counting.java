package shorting;

public class counting {
    public static void main(String[] args) {
    int n,i;
    n=5;
    int[] data =new int[n];
    data[0]=1;
    data[1]=9;
    data[2]=5;
    data[3]=3;
    data[4]=4;
    
    //cetak array data
        System.out.print("[");
        for (i = 0; i <= n-1; i++) {
            System.out.print(" "+data[i]);
        }
        System.out.println("]");
        
        //memulai quick sort
        quickSort(data, 0 ,n-1);
        
        //cetak hasil sorting
        System.out.print("[");
        for(i=0 ; i<=n-1;i++){
            System.out.print(" "+data[i]);
        }
        System.out.println("]");
    }
    
    public static int partisi(int[]data,int low,int high){
        int indexPartisi;
        int pivot, i, j, temp;
        
        pivot = data[high];
        i = low - 1;
        for(j = low; j <= high -1;j++){
            if(data[j] < pivot){
              i = i+1;
              
              //tukar data pada index i dan j
              temp = data[i];
              data[i] = data[j];
              data[j] = temp;
            }
        }
        
        //tukar data pada index i+1 dan high
        temp = data [i +1];
        data[i +1 ]=data[high];
        data[high]= temp;
        indexPartisi = 1+i;
        
        return indexPartisi;
    }
    public static void quickSort(int[] data,int low,int high){
        if(low < high){
            int indexPartisi;
            
            indexPartisi = partisi(data , low, high);
            quickSort(data, low,indexPartisi -1);
            quickSort(data,indexPartisi +1,high);
        }
    }
}
