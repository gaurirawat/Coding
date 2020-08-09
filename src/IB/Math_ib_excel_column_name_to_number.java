package IB;
//https://www.interviewbit.com/problems/excel-column-number/
public class Math_ib_excel_column_name_to_number {
    public int titleToNumber(String a) {
        if(a==null) return 0;
        int n=0;
        for(int i=a.length()-1;i>=0;--i)
            n+=Math.pow(26,(a.length()-i-1))*(a.charAt(i)-'A'+1);
        return n;
    }
}
