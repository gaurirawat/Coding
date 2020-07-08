package revision;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/subset-with-sum-divisible-by-m/0
//https://practice.geeksforgeeks.org/editorial.php?pid=2248

public class DP_gfg_subset_sum_divisible_by_k {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t= Integer.parseInt(sc.nextLine());
		while(t--!=0) {
			int l= sc.nextInt();
			int k= sc.nextInt();

			int nums[]= new int[l];
			int sum=0;
			for(int i=0; i< l; ++i){
				nums[i]=sc.nextInt();
				sum+=nums[i];
			}
			if(sum<k || k==0) {
				System.out.println(0);
				continue;
			}
			System.out.println(subsetSumDP(nums,k)?1:0);
		}
	}

	//easy soln. Just understand
	public static boolean subsetSumDP(int nums[], int k){
		if(nums.length>k) return true;
		boolean dp[]= new boolean[k];
		for(int x: nums){
			if(dp[0]) return true;
			boolean temp[]= new boolean[k];
			for(int i=0;i<k;++i){
				if(dp[i])
					temp[(i+x)%k]=true;
			}
			for(int i=0 ;i<k;++i){
				dp[i]= dp[i]|| temp[i];
			}
			dp[x%k]=true;
		}
		return dp[0];
	}


//	Below soln is correct but TLE. O(m* sum) sum= sum of all m elements)
//	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
//		int t= Integer.parseInt(sc.nextLine());
//		while(t--!=0) {
//			int l= sc.nextInt();
//			int k= sc.nextInt();
//
//			int nums[]= new int[l];
//			int sum=0;
//			for(int i=0; i< l; ++i){
//				nums[i]=sc.nextInt();
//				sum+=nums[i];
//			}
//			if(sum<k || k==0) {
//				System.out.println(0);
//				continue;
//			}
//			System.out.println(subsetSumDivisibleByKDP(nums,k,sum)?1:0);
//		}
//	}
//
//	public static boolean subsetSumDivisibleByKDP(int nums[], int k, int sum){
//		boolean dp[][]= new boolean[nums.length+1][sum+1];
//		for(int i=0; i<=nums.length;++i)
//			dp[i][0]=true;
//
//		for(int i=1 ;i<=nums.length; ++i){
//			for(int j=1;j<=sum;++j){
//				if(j>=nums[i-1]){
//					dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
//				}
//				else
//					dp[i][j]=dp[i-1][j];
//				if(j%k==0 && dp[i][j])
//					return true;
//			}
//		}
//		return false;
//	}

}
