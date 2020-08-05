package revision;
//https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
public class Math_lc_count_odd_no_in_an_interval {
    public int countOdds(int low, int high) {
        int x=low%2==0?low/2:(low+1)/2;
        int y=high%2==0?high/2:(high+1)/2;
        return (y-x)+(low%2==0?0:1);
    }
}
