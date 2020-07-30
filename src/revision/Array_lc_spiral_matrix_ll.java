package revision;
//https://www.interviewbit.com/problems/spiral-order-matrix-ii/
//https://leetcode.com/problemset/all/?search=spiral%20matrix

public class Array_lc_spiral_matrix_ll {
    public int[][] generateMatrix(int n) {
        if(n==0) return null;
        int a[][]= new int[n][n];
        int c=1;
        int x= n/2 + n%2;
        for(int i=0;i<x;++i){
            for(int p=i;p<n-i;++p)
                a[i][p]=c++;
            for(int q=i+1;q<n-i;++q)
                a[q][n-i-1]=c++;
            for(int r=n-i-2;r>=i;--r)
                a[n-i-1][r]=c++;
            for(int s=n-i-2;s>i;--s)
                a[s][i]=c++;
        }
        return a;
    }
}
