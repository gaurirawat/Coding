package revision;
//https://leetcode.com/problems/cracking-the-safe/discuss/110264/Easy-DFS
import java.util.HashSet;

//https://leetcode.com/problems/cracking-the-safe/submissions/
public class Graph_lc_cracking_the_safe {
    String fans;
    public String crackSafe(int n, int k) {
        fans="";
        StringBuilder sb=new StringBuilder();
        if(n==1){
            for(int i=0;i<k;++i) {
                sb.append(i);
            }
            return sb.toString();
        }
        for(int i=0;i<n;++i) {
            sb.append(0);
        }
        int tot=(int)Math.pow(k,n);
        HashSet<Integer> visited=new HashSet<Integer>();
        visited.add(0);
        dfs(sb.toString(),visited,tot,k,sb.toString());
        return fans;
    }

    public boolean dfs(String s, HashSet<Integer> visited, int c, int k, String ans){
        if(c==1){
            fans=ans;
            return true;
        }
        int num=Integer.parseInt(s);
        visited.add(num);
        String old=s.substring(1,s.length());
        for(int i=0;i<k;++i) {
            String newS=old+i;
            if(!visited.contains(Integer.parseInt(newS))&& dfs(newS,visited,c-1,k,ans+i)){
                return true;
            }
        }
        visited.remove(num);
        return false;
    }
}
