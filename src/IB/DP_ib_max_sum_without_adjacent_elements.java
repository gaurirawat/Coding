package IB;
//https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
public class DP_ib_max_sum_without_adjacent_elements {
    public int adjacent(int[][] arr) {
        int inc=0;
        int exc=0;
        for(int i=0;i<arr[0].length;++i){
            int nexc=Math.max(inc,exc);
            int ninc=Math.max(exc+Math.max(arr[0][i],arr[1][i]),inc);

            inc=ninc;
            exc=nexc;
        }
        return Math.max(inc,exc);
    }
}
