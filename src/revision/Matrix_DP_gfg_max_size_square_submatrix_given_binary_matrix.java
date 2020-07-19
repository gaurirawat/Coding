package revision;

import java.util.Scanner;
//https://www.youtube.com/watch?v=aYnEO53H4lw
//https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix/0

public class Matrix_DP_gfg_max_size_square_submatrix_given_binary_matrix {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        while(t--!=0){
            String s[]= sc.nextLine().split(" ");
            int r=Integer.parseInt(s[0]);
            int c=Integer.parseInt(s[1]);
            String a[]=sc.nextLine().split(" ");
            int x=0;
            int arr[][]= new int[r][c];
            for(int i=0;i<r;++i){
                for(int j=0;j<c;++j)
                    arr[i][j]=Integer.parseInt(a[x++]);
            }
            System.out.println(maxSizeSquareSubmatrix(arr));
        }
    }
    public static int maxSizeSquareSubmatrix(int m[][]){
        int dp[][]= new int[m.length][m[0].length];
        int max=0;
        for(int i=0;i<m.length;++i){
            for(int j=0;j<m[0].length;++j){
                if(i==0||j==0)
                    dp[i][j]=m[i][j];
                else if(m[i][j]==1)
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]))+1;
                else
                    dp[i][j]=0;
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
