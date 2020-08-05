package revision;
//https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
/*
Below soln is logically correct but works in O(n2). The expected soln is O(n).

public int minNumberOperations(int[] target) {
        return minNoRec(0,target.length-1,target,new int[target.length]);
    }

    public int minNoRec(int l, int r, int[]trr,int[]arr){
        if(l>r)return 0;
        int trrMin=Integer.MAX_VALUE;
        for(int i=l;i<=r;++i)
            trrMin=Math.min(trrMin,trr[i]);
        int cnt=trrMin-arr[l];
        Arrays.fill(arr,l,r+1,trrMin);
        for(int i=l;i<=r;++i){
            if(trr[i]>arr[i]){
                int st=i;
                while(i<r && trr[i+1]>arr[i+1])
                    i++;
                cnt+=minNoRec(st,i,trr,arr);
            }
        }
        return cnt;
    }
 */

/*
Now for an O(n) soln, the idea is to keep tracking the num of up steps. So every time we go up we increase the counter
by the different between the current steps and the previous step. And once we go down we don't do anything.
 */
public class Array_lc_minimum_inc_on_subarray_to_form_target_array {
    public int minNumberOperations(int[] t) {
        if(t==null||t.length==0) return 0;
        int cnt=t[0];
        for(int i=1;i<t.length;++i){
            if(t[i]>t[i-1])
                cnt+=(t[i]-t[i-1]);
        }
        return cnt;
    }

}
