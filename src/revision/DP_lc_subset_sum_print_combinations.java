package revision;
// https://leetcode.com/problems/combination-sum-ii/submissions/
//Better solution without DP:https://leetcode.com/problems/combination-sum-ii/discuss/17006/Short-and-Easy-to-understand-Recursive-JAVA-solution
/*
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is: [  [1, 7],  [1, 2, 5],  [2, 6],  [1, 1, 6]]
Here set [1,7] can be created twice therefore an extra Set is used to handle this case.
*/
import java.util.*;
public class DP_lc_subset_sum_print_combinations {

	List<List<Integer>> ans= new ArrayList<List<Integer>>();
	Set<List<Integer>> set = new HashSet<List<Integer>>(); 
       
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	 	ans.clear();
	 	set.clear();
         Arrays.sort(candidates);
	 	// array is declared of one cell extra in both x and y axis
	 	boolean dp[][]= new boolean[target+1][candidates.length+1];
	 	combinationSum2DP(dp, candidates, target);
	 	getCombinationsResult(new ArrayList<Integer>(), dp, candidates, target, candidates.length);
	 	return ans;
    }

    public void combinationSum2DP(boolean[][]s, int []nums, int sum){
    	for(int i=0; i<=nums.length; ++i)
    		s[0][i]= true;// very important otherwise overall solution will fail
    	for(int i=1; i<=sum;++i) {
			for(int j=1; j<=nums.length;++j) {
				if(i>=nums[j-1])
					s[i][j]= s[i][j-1]||s[i-nums[j-1]][j-1];
				else
					s[i][j]= s[i][j-1];
			}
		}
    }

    //here i: 0 -> <sum+1, j: 0-> <nums.lenght+1
    public void getCombinationsResult(List<Integer> l, boolean [][]s, int nums[], int i, int j){
    	if(i==0){
            if(!set.contains(l)){
    		    ans.add(l);
                set.add(l);                
            } //make sure there is no duplicate     		
    		return;
    	}
    	if(i<=0 || j<=0)
    		return;

    	// If sum can be made using this element.
    	if(i>=nums[j-1] && s[i-nums[j-1]][j-1]){
    		List<Integer> temp= new ArrayList<Integer>();
    		temp.addAll(l); 
    		temp.add(0,nums[j-1]);
    		getCombinationsResult(temp, s, nums, i-nums[j-1], j-1);
    	}

    	// If sum can be made ignoring this element.
    	if(s[i][j-1]){
    		getCombinationsResult(l, s, nums, i, j-1 );
        }
    }
}