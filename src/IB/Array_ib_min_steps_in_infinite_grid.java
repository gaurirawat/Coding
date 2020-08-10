package IB;
//https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
public class Array_ib_min_steps_in_infinite_grid {
    public int coverPoints(int[] x, int[] y) {
        int c=0;
        for(int i=1;i<x.length;++i){
            int a=x[i]-x[i-1];
            int b=y[i]-y[i-1];
            c+=Math.max(Math.abs(a),Math.abs(b));
        }
        return c;
    }
}