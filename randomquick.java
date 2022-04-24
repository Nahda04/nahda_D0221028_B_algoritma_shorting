package shorting;

import java.util.*;
public class randomquick {
    public static void main(String[] args) {
        ArrayList<Double>data=new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Panjang Array : ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("index ke "+i+" : ");
            Double nilai = scan.nextDouble();
            data.add(nilai);
        }
        System.out.println("Data Original : "+data );
        randomquick(data,0,data.size()-1);
        System.out.print("Random Quick Sort : ");
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i)+" ");
        }
        scan.close();
    }
    public static void swap (ArrayList<Double>data,int i,int j){
        Double temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }
    public static int partition(ArrayList<Double>data,int beg, int end){
        
        int random = beg +((int)Math.random()*(data.size()))/(end-beg+1);
        int last=end;
        swap (data,random,end);
        
        while(beg<=end){
            if(data.get(beg)<data.get(last))beg++;
            else{
                swap(data,beg,last);
                end--;
            }
        }
        swap(data, beg, last);
        return beg;
        
    }
    public static void randomquick(ArrayList<Double>data,int beg, int end){
        if(beg>end) return;
        if(beg<0) return;
        if(end>data.size()-1) return;
        
        int pivot = partition (data,beg,end);
        randomquick (data,beg,pivot-1);
        randomquick (data,pivot+1,end);
    }   
}
