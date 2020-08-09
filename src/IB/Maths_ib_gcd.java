package IB;
//https://www.interviewbit.com/problems/greatest-common-divisor/
public class Maths_ib_gcd {
    public int gcd(int a, int b) {
        if(b==0)return a;
        int t=b;
        b=a%b;
        a=t;
        return gcd(a,b);
    }
}
