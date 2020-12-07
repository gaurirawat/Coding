package revision;
//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
public class Array_lc_min_domino_rotations_for_equal_rows {
    public int minDominoRotations(int[] a, int[] b) {
        int[] numa= new int[6];
        int[] numb= new int[6];
        for (int i=0;i<a.length;++i) {
            numa[a[i]-1]++;
            numb[b[i]-1]++;
        }
        int ans=-1;
        for(int i=0;i<6;++i) {
            if((numa[i]+numb[i])>=a.length) {
                // System.out.println(i);
                ans= check(i+1, a, b);
                if(ans!=-1) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public int check(int num, int[]a, int[]b){
        int rotationsa=0;
        int rotationsb=0;
        for(int i=0;i<a.length;++i) {
            if(a[i]==num && b[i]==num) {
                continue;
            }
            else if(a[i]==num && b[i]!=num) {
                rotationsb++;
            }
            else if(a[i]!=num && b[i]==num) {
                rotationsa++;
            }
            else{
                return -1;
            }
        }
        return Math.min(rotationsa,rotationsb);
    }
}
