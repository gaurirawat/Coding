package IB;

//https://www.interviewbit.com/problems/simplify-directory-path/
//https://leetcode.com/problems/simplify-path/submissions/

public class Stack_ib_simplify_directory_path {
    public String simplifyPath(String a) {
        String st[]=new String[a.split("/").length];
        int top=0;
        for(String s:a.split("/")){
            if(s.equals(".."))
                top=top==0?0:top-1;
            else if(!s.equals("") && !s.equals("."))
                st[top++]=s;
        }
        if(top==0) return "/";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<top;++i)
            sb.append("/").append(st[i]);
        return sb.toString();
    }
}
