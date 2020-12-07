package IB;

public class Array_ib_pick_from_both_sides {
    public int solve(int[] a, int b) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=b;++i) {
            int sum=0;
            for(int j=0;j<i;++j){
                sum+=a[j];
            }
            for(int j=a.length-1;j>=a.length+i-b;--j){
                sum+=a[j];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}
