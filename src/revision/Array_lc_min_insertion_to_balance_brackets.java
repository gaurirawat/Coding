package revision;
//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
public class Array_lc_min_insertion_to_balance_brackets {
    public int minInsertions(String s) {
        char arr[]=s.toCharArray();
        int o=0;
        int c=0;
        int ans=0;
        for(int i=0;i<arr.length;++i){
            if(arr[i]=='('){
                o++;
                // System.out.println(ans+"(");
            }
            else if(arr[i]==')' && (i+1)==arr.length){
                if(o==0)
                    ans+=2;
                else
                {
                    ans++;
                    o--;
                }
                // System.out.println(ans+")end");
            }
            else if(arr[i]==')'){
                if(arr[i+1]==')'){
                    if(o==0) ans++;
                    else{
                        o--;
                    }
                    i++;
                    // System.out.println(ans+"))");
                }
                else{
                    if(o==0) ans+=2;
                    else{
                        o--;
                        ans++;
                    }
                    // System.out.println(ans+")");

                }
            }
        }
        if(o>=0)
            ans+=o*2;
        return ans;
    }
}
