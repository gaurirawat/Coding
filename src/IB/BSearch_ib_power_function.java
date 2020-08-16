package IB;
//https://www.interviewbit.com/problems/implement-power-function/
//https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
public class BSearch_ib_power_function {
    public int pow(int x, int n, int d) {
        int ans= (int) pow(x*1l,n*1l,d*1l);
        if(ans<0)
            return ans+d;
        return ans;
    }

    public long pow(long x, long n, long d){
        if(x==0) return 0;
        else if(n==0) return 1;
        else if(n==1) return x%d;
        long num;
        if(n%2==0)
            num=pow((x*x)%d,n/2,d)%d;
        else
            num=x*pow((x*x)%d,n/2,d)%d;
        return num;
    }
}
