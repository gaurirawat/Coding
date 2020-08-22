package IB;
//https://www.interviewbit.com/problems/largest-coprime-divisor/

public class Math_ib_largest_coprime_divisor {
    public int cpFact(int a, int b) {
        int gcd=gcdF(a,b);
        while(gcd!=1){
            a=a/gcd;
            gcd=gcdF(a,b);
        }
        return a;
    }

    public int gcdF(int a, int b){
        if(b==0) return a;
        int t=b;
        b=a%b;
        a=t;
        return gcdF(a,b);
    }
}
