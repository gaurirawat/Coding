package revision;

//https://ide.geeksforgeeks.org/chSenMwO5G
//https://www.youtube.com/watch?v=hgA4xxlVvfQ&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=8
//https://www.youtube.com/watch?v=YXwmt55nl7I/
public class DP_gfg_optimal_binary_search_tree {
    public static void main(String[] args) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        //ans 142

        // int keys[]= {10,12,16,21};
        // int freq[]={4,2,6,3};

        // sort(keys, freq);
        //here we are giving sorted lists. In real time keys shall have to be sorted.

        for(int i=1; i<freq.length; ++i)
            freq[i]=freq[i-1]+freq[i];
        //now freq is basically a cumulative freq so that we can find the sum easily

        int n = keys.length;
        int dp[][]=new int[freq.length][freq.length];

        System.out.println("Cost of Optimal BST is " +
                optimalSearchTreeDP(freq, 0,freq.length-1, dp));
    }

    public static int optimalSearchTreeDP(int[] freq, int i, int j, int dp[][]){
        if(i>j)
            return 0;
        else if(i==j)
            return dp[i][j]= (i==0? freq[0]: freq[i]-freq[i-1]);//gives freq of current element;
        if(dp[i][j]!=0)
            return dp[i][j];
        int val=Integer.MAX_VALUE;
        for(int k=i; k<=j;++k){
            val=Math.min(val, (optimalSearchTreeDP(freq,i,k-1,dp)+optimalSearchTreeDP(freq,k+1,j,dp)) );
        }

        //We need to add the cost of the all the elements from i to j. Since freq[] contains the cumulative freq,
        //in order to find sum of frequencies, we shall have to find difference.

        dp[i][j]= i==0? val+ freq[j]: val+ freq[j]-freq[i-1];
        return dp[i][j];
    }
}
