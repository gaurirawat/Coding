package revision;
//https://www.interviewbit.com/problems/matrix-median/

//understanding: https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
import java.util.*;
public class Matrix_BSearch_ib_median_of_2D_matrix {
	public int findMedian(int[][] a) {
        int r=a.length;
        int c=a[0].length;
        int mn= Integer.MIN_VALUE;
        int mx= Integer.MAX_VALUE;
        for(int i=0; i<a.length; ++i){
            mx=Math.max(mx, a[i][a[0].length-1]);
            mn=Math.max(mn, a[i][0]);
        }
        
        int mdCnt= (r*c+1)/2;
        while(mn<mx){
            int mid=(mn+mx)/2;
            int tCnt=0;//total no of elements smaller than mid
            for(int i=0; i<r;++i){
                int pos=Arrays.binarySearch(a[i], mid);//gets pos where mid element should be present
                // gets the no of elements smaller than mid for current row
                if(pos<0)
                    pos=Math.abs(pos)-1;
                else
                    while(pos<c && a[i][pos]<=mid)
                        pos++;//to handle duplicate elements
                tCnt+=pos;
            }
            if(tCnt<mdCnt)
                mn=mid+1;
            else
                mx=mid;
        }
    // System.out.println(mn);
       return mn; 
    }
}
