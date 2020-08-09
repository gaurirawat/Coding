package IB;
//https://www.interviewbit.com/problems/prime-sum/
public class Math_ib_prime_sum {
    public int[] primesum(int a) {
        int f=2;
        int ans[]=new int[2];
        while(f<=a){
            if((f==2||f%2!=0)&&isPrime(f) && isPrime(a-f)){
                ans[0]=f;
                ans[1]=a-f;
                break;
            }
            f++;
        }
        return ans;
    }

    public boolean isPrime(int a){
        if(a==2||a==3||a==5)return true;
        if(a%2==0)return false;
        for(int i=2;i<=Math.sqrt(a);++i){
            if(a%i==0)
                return false;
        }
        return true;
    }
}
