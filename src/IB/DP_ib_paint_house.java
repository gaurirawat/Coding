package IB;
//https://www.interviewbit.com/problems/paint-house/
public class DP_ib_paint_house {
    public int solve(int[][] a) {
        int l=a.length;
        int[] red=new int[l];
        int[] blue=new int[l];
        int[] green=new int[l];
        red[0]=a[0][0];
        blue[0]=a[0][1];
        green[0]=a[0][2];
        for(int i=1;i<l;++i){
            red[i]=a[i][0]+Math.min(blue[i-1], green[i-1]);
            blue[i]=a[i][1]+Math.min(red[i-1], green[i-1]);
            green[i]=a[i][2]+Math.min(blue[i-1], red[i-1]);
        }
        return Math.min(Math.min(red[l-1], blue[l-1]), green[l-1]);
    }
}
