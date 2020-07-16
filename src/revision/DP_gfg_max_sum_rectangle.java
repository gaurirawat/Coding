package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0

/*there should be atleast one non negative element in the array for this thing to work. If not be check complete soln in
geeks article*/
public class DP_gfg_max_sum_rectangle {
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
            System.out.println(maxSumRectangle(arr,r,c));
        }
    }

    public static int maxSumRectangle(int arr[][], int r, int c){
        // int psum[][]= new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c-1;++j){
                arr[i][j+1]=arr[i][j]+arr[i][j+1];
            }
        }
        int mxSum=0;
        int sRow=0,eRow=0,sCol=0,eCol=0;
        for(int st=0;st<c;++st){
            for(int end=st;end<c;++end){
                //since the start and the end row are fixed we need to
                // apply kadanes vertically taking the valid row area of every
                //row as one cell
                int kCurrSum=0, kMaxSoFar=0, kSt=0;
                for(int i=0;i<r; ++i){
                    int cell= st==0? arr[i][end]: arr[i][end]-arr[i][st-1];
                    kCurrSum+=cell;
                    if(kCurrSum>kMaxSoFar){
                        kMaxSoFar=kCurrSum;
                        sRow=st;
                        eRow=end;
                        sCol=kSt;
                        eCol=i;
                    }
                    if(kCurrSum<0){
                        kCurrSum=0;
                        kSt=i+1;
                    }
                }
                mxSum=Math.max(mxSum,kMaxSoFar);
            }
        }
        return mxSum;
    }
}
