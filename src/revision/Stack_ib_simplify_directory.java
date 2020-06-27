package revision;
//https://www.interviewbit.com/problems/simplify-directory-path/
public class Stack_ib_simplify_directory {
	public String simplifyPath(String s) {
        int len= s.length();
        if(len==0|| len==1)
            return s;
        String arr[]= new String[len/2+1];
        int cnt=0;
        int beg=0;
        s=s+"/";len++;
        for(int i=0; i< len; ++i){
            char c=s.charAt(i);
            if(beg==i && c=='/'){
                beg=i+1;
                continue;
            }
            else if(c=='/'){
                // System.out.println(s.substring(beg, i));
                if(s.substring(beg, i).equals(".."))
                    cnt=cnt==0?0:cnt-1;
                else if(!s.substring(beg, i).equals("."))
                    arr[cnt++]=s.substring(beg, i);
                beg=i+1;    
            }
        }
        if(cnt==0)
            return "/";
        s="";
        for(int i=0 ;i<cnt; ++i ){
            s+="/"+arr[i];
        }
        return s;
    }
}
