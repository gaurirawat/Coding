package IB;

public class Math_ib_power_of_two_integers {
    public int isPower(int n) {
        if(n==1) return 1;
        for(int i=(int)Math.sqrt(n);i>=1;--i){
            double x=Math.log10(n)/Math.log10(i);
            if(x==(int)x) return 1;
        }
        return 0;
    }
}
