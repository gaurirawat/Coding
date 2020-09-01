package IB;
//https://www.interviewbit.com/problems/find-duplicate-in-array/
public class Array_ib_find_duplicate_in_array {
    public int repeatedNumber(final int[] a) {
        for(int i=0;i<a.length;++i){
            int index=Math.abs(a[i])-1;
            if(a[index]<0)
                return Math.abs(a[i]);
            a[index]=-a[index];
        }
        return -1;
    }
}
