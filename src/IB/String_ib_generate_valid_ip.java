package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/valid-ip-addresses/
public class String_ib_generate_valid_ip {
    ArrayList<String> ans;
    public ArrayList<String> restoreIpAddresses(String s) {
        ans= new ArrayList<String>();
        ipInner("",s,0,3);
        return ans;
    }

    public void ipInner(String curr, String s, int i, int minRem){
        if(minRem==0 ){
            if(s.length()-i==1&& s.charAt(i)=='0'){
                curr+="0";
                ans.add(curr);
            }

            if(s.length()-i<=3 && s.charAt(i)!='0' && Integer.parseInt(s.substring(i))<=255){
                curr+=s.substring(i);
                ans.add(curr);
            }
            return;
        }
        // System.out.println(i);
        if(s.charAt(i)=='0')
            ipInner(curr+"0.",s,i+1,minRem-1);
        else{
            for(int x=0; x<3 && (i+x+minRem)<s.length();++x){
                String t=s.substring(i,i+x+1);
                if(Integer.parseInt(t)<=255)
                    ipInner(curr+t+".",s,i+x+1,minRem-1);
            }
        }
    }
}

