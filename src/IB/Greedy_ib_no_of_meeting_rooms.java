package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/meeting-rooms/
public class Greedy_ib_no_of_meeting_rooms {
    public int solve(int[][] arr) {
        if(arr==null||arr.length==0) return 0;
        int s[]= new int[arr.length];
        int e[]= new int[arr.length];
        for(int i=0;i<arr.length;++i){
            s[i]=arr[i][0];
            e[i]=arr[i][1];
        }
        Arrays.sort(s);
        Arrays.sort(e);
        int c=0, max=0;
        int si=0,ei=0;
        while(si!=arr.length){
            if(s[si]==e[ei]){
                si++;
                ei++;
            }
            else if(s[si]<e[ei]){
                si++;
                c++;
                max=Math.max(max,c);
            }
            else{
                ei++;
                c--;
            }
        }
        return max;
    }

}
