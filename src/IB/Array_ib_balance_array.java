package IB;
//https://www.interviewbit.com/problems/balance-array/
public class Array_ib_balance_array {
    public int solve(int[] a) {
        int[] even= new int[a.length];
        int[] odd=new int[a.length];
        odd[0]=a[0];
        int l=a.length;
        for(int i=1;i<l;++i) {
            if(i%2==0) {
                even[i]=even[i-1];
                odd[i]=odd[i-1]+a[i];
            }
            else{
                odd[i]=odd[i-1];
                even[i]=even[i-1]+a[i];
            }
        }
        int c= (odd[l-1]-a[0])==even[l-1]?1:0;
        for(int i=1;i<l;++i) {
            int evenSum=even[i-1]+ odd[l-1]-odd[i];
            int oddSum= odd[i-1]+ even[l-1]-even[i];
            if(evenSum==oddSum){
                c++;
            }
        }
        return c;
    }

}
