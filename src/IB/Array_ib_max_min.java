package IB;
//https://www.interviewbit.com/problems/max-min-05542f2f-69aa-4253-9cc7-84eb7bf739c4/
public class Array_ib_max_min {
    public int solve(int[] a) {
        int min=a[0];
        int max=a[0];
        for(int i=1;i<a.length;++i){
            if(a[i]>max){
                max=a[i];
            }
            else if(a[i]<min){
                min=a[i];
            }
        }
        return max+min;
    }
}
