package IB;
//https://www.interviewbit.com/problems/reverse-integer/
public class Math_ib_reverse_integer {
    public int reverse(int a) {
        StringBuffer s=new StringBuffer();
        int t=Math.abs(a);
        while(t!=0){
            s.append(t%10);
            t/=10;
        }
        long num=Long.parseLong(s.toString());
        num= a<0?0-num:num;
        if(num>Integer.MAX_VALUE||num<Integer.MIN_VALUE)
            return 0;
        return (int)num;
    }
}
