package IB;
//https://www.interviewbit.com/problems/ways-to-color-a-3xn-board/
public class DP_ib_ways_to_colour_a_3N_matrix {
    public int solve(int n){
        if(n==0) return 0;
        int three=24;
        int two=12;
        for(int i=1;i<n;++i){
            int nthree=11*three+10*two;
            int ntwo=5*three+7*two;
            three=nthree;
            two=ntwo;
        }
        return three+two;
    }
}
