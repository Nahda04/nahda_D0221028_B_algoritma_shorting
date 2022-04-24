package shorting;

import java.util.ArrayList;
import java.util.Scanner;

public class bubble_selection_insertion_merge_quick_SHORT {
        //method isi data
    static ArrayList<Double>inisialisasiArrayList(){
        ArrayList<Double>ArrList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Inputkan Panjang Array : ");
        int n = sc.nextInt();
        for (int i = 0 ; i < n ; i++){
            Double nilai = sc.nextDouble();
            ArrList.add(nilai);
        }
        return ArrList;
    }
    //method cetak
    static void cetak (ArrayList<Double>cetak){
        System.out.print("[");
        for (Double value : cetak){
             System.out.print(" "+value);
        }
        System.out.println("]");
    }
    //method kloning
    static ArrayList<Double>kloning(ArrayList<Double>kloning){
        ArrayList<Double>arrListNew = null;
        if(kloning != null){
            arrListNew = new ArrayList<>();
            for (Double value1 : kloning){
                arrListNew.add(value1);
            }
        }
        return arrListNew;
    }
    //method sorting
    static void tukarNilai (ArrayList<Double> tukarNilai, int indexA, int indexB){
        if (indexA >= 0 && indexA < tukarNilai.size() && indexB >= 0 && indexB < tukarNilai.size() && indexA != indexB){
            Double A, B, C;
            A = tukarNilai.get(indexA);
            B = tukarNilai.get(indexB);
            C = A;
            A = B;
            B = C;
            tukarNilai.set( indexA, A);
            tukarNilai.set( indexB, B);
        }
    }
    //Algoritma Sorting Bubble Sort
    static void bubbleSort (ArrayList<Double>ArrList){
        int n = ArrList.size();
        boolean adaPertukaran = true;
        do{
            adaPertukaran = false;
            for (int i = 1; i < n; i++) {
                if(ArrList.get(i-1) > ArrList.get(i)){
                    tukarNilai(ArrList, (i-1) , i);
                    adaPertukaran = true;
                }

            }
            n--;
        }while(adaPertukaran);
    }

    //Algoritma Selection Sort
    static void selectionSort (ArrayList<Double>ArrList){
        int n = ArrList.size();
        for(int i = 0 ; i < n-1; i++){
            int JMIN = i;
            for (int j = i +1 ; j < n; j++) {
                JMIN = j;

            }
            if(JMIN != i){
                tukarNilai(ArrList , i, JMIN);
            }
        }
    }

    //Algoritma Insertion Sort
    static void insertionSort (ArrayList<Double>ArrList){
        int n = ArrList.size();
        int i = 1;
        int j;
        while (i<n){
            Double temp = ArrList.get(i);
            for (j=i ; j>0;j--){
                if (temp<ArrList.get(j-1)){
                    ArrList.set(j, ArrList.get(j-1));
                }else{
                    break;
                }
            }
            ArrList.set(j,temp);
            i++;
        }
    }
    
    //Algoritma Sorting Merge Sort
    static void mergeSort (ArrayList<Double>ArrList){
        int n = ArrList.size();
        if(n<2){
            return;
        }
        
        int tengah =n/2;
        ArrayList<Double>ArrListKiri = new ArrayList<>();
        for (int i = 0; i < tengah; i++) {
            ArrListKiri.add(ArrList.get(i));
        }
        ArrayList<Double>ArrListKanan = new ArrayList<>();
        for (int i = tengah; i < n; i++) {
            ArrListKanan.add(ArrList.get(i));
        }
        mergeSort(ArrListKiri);
        mergeSort(ArrListKanan);
        
        merge(ArrList,ArrListKiri,ArrListKanan);
    }
    static void merge(ArrayList<Double>ArrList,ArrayList<Double>ArrListKiri,ArrayList<Double>ArrListKanan){
        int i=0,j=0,k=0;
        int sKiri = ArrListKiri.size();
        int sKanan = ArrListKanan.size();
        
        while(i<sKiri && j<sKanan){
            if(ArrListKiri.get(i) < ArrListKanan.get(j)){
                ArrList.set(k++,ArrListKiri.get(i++));
            }else{
                ArrList.set(k++,ArrListKanan.get(j++));
            }
        }
        while (i<sKiri){
            ArrList.set(k++,ArrListKiri.get(i++));
        }
        while(j<sKanan){
            ArrList.set(k++,ArrListKanan.get(j++));
        }
    }
    
    //Algoritma Quick sort
    static int partisi(ArrayList<Double>ArrList,int low,int high){
        Double pivot = ArrList.get(high);
        int i = low-1;
        for(int j = low; j<high;j++){
            if(ArrList.get(j)<pivot){
                i++;
                tukarNilai(ArrList,i,j);
            }
        }
        tukarNilai(ArrList,i+1,high);
        return i+1;
    }
    
    static void quickSort (ArrayList<Double>ArrList,int low, int high){
        if (low<high){
            int indexPartisi= partisi (ArrList,low,high);
            quickSort(ArrList,low,indexPartisi-1);
            quickSort(ArrList,indexPartisi+1,high);
        }
    }


    public static void main(String[] args) {
        ArrayList<Double>data = inisialisasiArrayList();
        System.out.print("data original");
        cetak(data);

        ArrayList<Double>data1 = kloning(data);
        System.out.print("Bubble Sort");
        bubbleSort(data1);
        cetak(data1);

        ArrayList<Double>data2 = kloning(data);
        System.out.print("Selection Sort");
        selectionSort(data2);
        cetak(data1);
        
        ArrayList<Double>data3 = kloning(data);
        System.out.print("Insertion Sort");
        insertionSort(data3);
        cetak(data3);
        
        ArrayList<Double>data4 = kloning(data);
        System.out.print("Merge Sort");
        mergeSort(data3);
        cetak(data1);
        
        ArrayList<Double>data5 = kloning(data);
        System.out.print("Quick Sort");
        quickSort(data5);
        cetak(data1);


    }

    private static void quickSort(ArrayList<Double> data5) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


