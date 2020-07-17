package revision;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class Array_lc_max_point_you_can_obtain_from_cards {
    public int maxScore(int[] c, int k) {
        if(c.length==0||k==0) return 0;
        int sum=0;
        for(int i=0;i<k && i<c.length; ++i)
            sum+=c[i];
        if(k>=c.length)
            return sum;
        int max=sum;
        for(int i=0;i<k;++i){
            sum=sum-c[k-i-1]+c[c.length-1-i];
            max=Math.max(max,sum);
        }
        return max;
    }
}
// we can use dp also but this soln is linear time and dp will definitely give TLE for such a question