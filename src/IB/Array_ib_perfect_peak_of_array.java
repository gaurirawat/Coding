package IB;
//https://www.interviewbit.com/problems/perfect-peak-of-array/
public class Array_ib_perfect_peak_of_array {
    public int perfectPeak(int[] a) {
        boolean valid[]=new boolean[a.length];
        int max=a[0];
        for(int i=1;i<a.length;++i){
            if(a[i]>max){
                valid[i]=true;
                max=a[i];
            }
        }
        int min=a[a.length-1];
        for(int i=a.length-2;i>=0;--i){
            if(a[i]<min && valid[i])
                return 1;
            min=Math.min(min, a[i]);
        }
        return 0;
    }
}