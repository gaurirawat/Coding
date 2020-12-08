package IB;
//https://www.interviewbit.com/problems/next-smallest-palindrome/
public class Math_ib_next_smallest_palindrome {
    public String solve(String s) {
        if(s.length()==1){
            int num=Integer.parseInt(s);
            num++;
            return (num==10?num+1:num)+"";
        }
        char[] ch=s.toCharArray();
        int i=s.length()/2;
        int mid=i;
        while(i!=-1){
            String a=new String(ch);
            StringBuffer halfa=new StringBuffer(a.substring(0,mid));
            StringBuffer finala=new StringBuffer(halfa.toString());
            halfa.reverse();
            if(a.length()%2==0){
                finala.append(halfa);
            }
            else{
                finala.append(ch[mid]+""+halfa);
            }
            // System.out.println(finala.toString()+" "+ finala.toString().compareTo(a));
            if(finala.toString().compareTo(s)>0){
                return finala.toString();
            }
            while(i!=-1 && ++ch[i]==('9'+1)){
                ch[i]='0';
                i--;
            }

        }
        StringBuffer sb= new StringBuffer("1");
        for(i=1;i<s.length();++i){
            sb.append(0);
        }
        sb.append(1);
        return sb.toString();
    }
}
