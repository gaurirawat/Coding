
package IB;
//https://www.interviewbit.com/problems/distribute-in-circle/
public class Math_ib_distribute_in_circle {
    public int solve(int tot, int size, int st) {
        if(tot==0) {
            return st;
        }
        tot=tot%size;
        st=st%size;
        int ans=st+tot-1;
        if(ans>size) {
            ans=ans-size;
        }
        if(ans<1){
            ans=size;
        }
        return ans;
    }
}
