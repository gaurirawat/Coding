package IB;
//https://www.interviewbit.com/problems/reverse-the-string/
public class String_ib_reverse_string {
    public String solve(String s) {
        String arr[]=s.split(" ");
        StringBuffer sb= new StringBuffer();
        for(int i=arr.length-1;i>=0;--i){
            if(arr[i].length()!=0)
                sb.append(arr[i]+" ");
        }
        String ans=sb.toString();
        if(ans.length()!=0)
            ans=ans.substring(0,ans.length()-1);
        return ans;
    }
}
