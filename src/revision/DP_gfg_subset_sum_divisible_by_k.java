package revision;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/subset-with-sum-divisible-by-m/0

public class DP_gfg_subset_sum_divisible_by_k {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		while(t--!=0) {
			String s[]= sc.nextLine().split(" ");
			int l=Integer.parseInt(s[0]);
			int k=Integer.parseInt(s[1]);
			int nums[]= new int[l];
			s= sc.nextLine().split(" ");
			for(int i=0; i< l;++i)
				nums[i]=Integer.parseInt(s[i]);
			System.out.println(subsetSumDP(nums, k)?1:0);	
		}
	}
	
	public static boolean subsetSumDP(int nums[], int k){
		boolean dp[]= new boolean[k];
		for(int i=0; i< nums.length; ++i) {
			if(dp[0]) return true;
			boolean temp[]= new boolean[k];
			for(int j=0; j<k;++j) {
				if(dp[i] && !dp[(j+nums[i])%k])
					temp[(j+nums[i])%k]=true;
			}
			for(int j=0; j<k; ++j)
				if(temp[j]) dp[j]= true;
			dp[i]= true;
		}
		return dp[0];		
	}
}
