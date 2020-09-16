package revision;
//https://leetcode.com/problems/count-unhappy-friends/
public class Array_lc_unhappy_friends {
    public int unhappyFriends(int n, int[][] pref, int[][] pair) {
        int partner[]=new int[n];
        for(int i=0;i<pair.length;++i){
            partner[pair[i][0]]=pair[i][1];
            partner[pair[i][1]]=pair[i][0];
        }
        int c=0;
        for(int i=0;i<n;++i){
            if(pref[i][0]==partner[i])
                continue;
            outer:  for(int j=0;j<n;++j){
                int other=pref[i][j];
                if(other==partner[i])
                    break;
                for(int k=0;k<n;++k){
                    if(pref[other][k]==partner[other])
                        break;
                    if(pref[other][k]==i){
                        c++;
                        break outer;
                    }
                }
            }
        }
        return c;
    }
}
