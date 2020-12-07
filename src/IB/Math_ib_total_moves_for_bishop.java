package IB;
//https://www.interviewbit.com/problems/total-moves-for-bishop/
public class Math_ib_total_moves_for_bishop {
    public int solve(int i, int j) {
        return Math.min(i,j)-1+ Math.min(j,8-i+1)-1+ Math.min(i,8-j+1)-1+Math.min(8-i+1,8-j+1)-1;
    }
}
