package IB;
//https://www.interviewbit.com/problems/jump-game-array/
public class DP_ib_jump_game_array {
    public int canJump(int[] arr) {
        int c=0;
        for(int i=0;i<arr.length;++i){
            if(c<0) return 0;
            c=Math.max(arr[i],c);
            c--;
        }
        return 1;
    }
}
