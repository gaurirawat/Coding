package IB;
//https://www.interviewbit.com/problems/excel-column-title/
public class Math_ib_excel_to_column {
    public String convertToTitle(int a) {
        StringBuilder ans=new StringBuilder();
        while(a!=0){
            int rem=a%26;
            char ch;
            if(rem==0){
                ch='Z';
                a=a-26;
            }
            else
                ch=(char)('A'+(a%26)-1);
            a=a/26;
            ans.append(ch);
        }
        ans.reverse();
        return ans.toString();
    }
}
