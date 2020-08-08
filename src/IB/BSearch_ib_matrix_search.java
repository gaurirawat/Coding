package IB;
//https://www.interviewbit.com/problems/matrix-search/
public class BSearch_ib_matrix_search {
    public int searchMatrix(int[][] a, int k) {
        if(a.length==0) return 0;
        int i=0;
        for(i=a.length-1;i>0;--i)
            if(k>=a[i][0])
                break;
        return binarySearch(a[i],k)?1:0;
    }

    public boolean binarySearch(int arr[], int k){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==k)
                return true;
            else if(arr[mid]<k)
                l=mid+1;
            else
                r=mid-1;
        }
        return false;
    }
}
