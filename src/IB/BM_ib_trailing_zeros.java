package IB;
//https://www.interviewbit.com/problems/trailing-zeroes/
public class BM_ib_trailing_zeros {
    public int solve(int a) {
        int c=0;
        while(true){
            if((a&1)==1){
                break;
            }
            else{
                c++;
                a=a>>1;
            }
        }
        return c;
    }
}
