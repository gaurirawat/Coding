package revision;
// https://leetcode.com/problems/combination-sum-ii/submissions/
//Better solution without DP:https://leetcode.com/problems/combination-sum-ii/discuss/17006/Short-and-Easy-to-understand-Recursive-JAVA-solution
/*
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is: [  [1, 7],  [1, 2, 5],  [2, 6],  [1, 1, 6]]
Here set [1,7] can be created twice therefore an extra Set is used to handle this case.
*/

//CHECK THE LOWER COMMENTED SOLUTION FIRST


import java.util.*;
public class DP_lc_subset_sum_print_combinations {

	List<List<Integer>> result= new ArrayList<List<Integer>>();
    Set<List<Integer>> hashset= new HashSet<List<Integer>>();
       
	 public List<List<Integer>> combinationSum2(int[] nums, int sum) {
         result.clear();
         hashset.clear();
         if(nums==null)
             return null;
         Arrays.sort(nums);
         // declare both row and column of one one length extra
         boolean dp[][]= new boolean[sum+1][nums.length+1];
         subsetSumDP(dp, sum, nums);
         getResult(new ArrayList<Integer>(), nums, dp, sum, nums.length);
         return result;
    }

    public void subsetSumDP(boolean dp[][], int sum, int nums[]) {
		//remember otherwise soln will fail
    	for(int i=0; i<nums.length; ++i)
			dp[0][i]=true;
		for(int i=1; i<=sum;++i) {
			for(int j=1; j<=nums.length;++j) {
				if(i>=nums[j-1])
					dp[i][j]= dp[i][j-1]||dp[i-nums[j-1]][j-1];
				else
					dp[i][j]= dp[i][j-1];
			}
		}
	}
    
    //func is getting called with nums.length so the elements will be in num[i-1] onwards
    public void getResult(List<Integer> l, int[] nums, boolean dp[][], int sum, int i){
//        remember to keep cond as below and not sum==num[i] since even if the sum==num there 
//    	shall still be elements which could add upto that sum and we need them in our result.
//    	and then well have to add them to the list, add the likst and then delete them also 
//    	otherwise the current list shall contain that element even if we wish to ignore it.
//    	removing that element shall become extra work.
    	if(sum==0){
            if(!hashset.contains(l)){
                // System.out.println("add");
                hashset.add(l);
                result.add(l);
            }
        }
        
    	//since elements are num[i-1] we simply return for i<=0
        if(i<=0 || sum<0)
            return ;
        
        //element is being considered
        if(sum>=nums[i-1] && dp[sum-nums[i-1]][i-1]){
            // System.out.println("include: " + nums[i-1]+ " "+ sum);
            ArrayList<Integer> temp= new ArrayList<Integer>();
            temp.addAll(l);
            temp.add(0,nums[i-1]);
            getResult(temp, nums, dp, sum-nums[i-1], i-1);
        }
        
        //element is not being considered
        if(i!=0 && dp[sum][i-1]){
            // System.out.println("dont include: " + nums[i-1]+ " "+ sum);
            getResult(l, nums, dp, sum, i-1);
        }
    }
}

/*
    List<List<Integer>>ans;
    Set<List<Integer>>set;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans= new ArrayList<List<Integer>>();
        set= new HashSet<List<Integer>>();
        Arrays.sort(candidates);
        boolean dp[][]=new boolean[candidates.length+1][target+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a, true));
        combinationSumDP(candidates.length,target,candidates,  dp, new ArrayList<Integer>());
        return ans;
    }

    public boolean combinationSumDP(int i, int j, int[]nums, boolean dp[][], ArrayList<Integer> l){
        if(j==0){
           if(!set.contains(l)){
                ArrayList<Integer> newl = new ArrayList<Integer>(l);
                ans.add(newl);
                set.add(newl);
            }
            return true;
        }
        if(i<=0 || j<=0)
            return false;
        if(dp[i][j]==false)
            return false;

//        If we had created a new list here then it is important to do this first because here we are
//        adding elements of l to a new list. If we keep if after the other call then l will get modified
//        and we will get wrong answer.

        if(nums[i-1]<=j){
            // System.out.println("inside"+i+" "+j +" "+newl.toString());
            l.add(nums[i-1]);
            dp[i][j]= combinationSumDP(i-1,j-nums[i-1],nums,dp,l);
            l.remove(new Integer(nums[i-1]));
            }

            //VVIMP. In a case where we need all the solutions MAKE SURE TO PUT THE CALL FIRST because here since we are using
            // || operator then if we have true from above then the second call will not happen at all. But we need that call.
            dp[i][j]=combinationSumDP(i-1,j,nums,dp,l)||dp[i][j];
            return dp[i][j];
            }
 */


