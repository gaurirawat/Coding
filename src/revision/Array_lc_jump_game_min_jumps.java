package revision;
//https://leetcode.com/problems/jump-game-ii/submissions/

//DP_lc_jump_game_isPossible
//Array_lc_jump_game_min_jumps
// dp approach is slow
public class Array_lc_jump_game_min_jumps {
    public int jump(int[] arr) {
        if(arr.length<=1) return 0;

        int mxReach=arr[0], steps=arr[0], jumps=1;
        for(int i=1;i<arr.length;++i){
            if(i==arr.length-1)
                return jumps;
            mxReach= Math.max(mxReach, arr[i]+i);
            steps--;
            if(steps==0){
                jumps++;
                if(i==mxReach)
                    return -1;
                steps=mxReach-i;
            }
        }
        return -1;
    }
}
