package IB;
//https://www.interviewbit.com/problems/inversions/
public class Array_ib_inversion_pair {
    public int countInversions(int[] a) {
        return inversionPair(a,0,a.length-1);
    }

    public int inversionPair(int[]a,int l,int r){
        while(l<r){
            int mid=l+(r-l)/2;
            return inversionPair(a,l,mid)+inversionPair(a,mid+1,r)+mergeInversionPair(a,mid, l, r);
        }
        return 0;
    }

    public int mergeInversionPair(int arr[], int mid, int l, int r){
        if(l==r)return 0;
        int temp[]= new int[r-l+1];
        int count=0;
        int i=l,j=mid+1,c=0;
        while(i<=mid&&j<=r){
            if(arr[i]<=arr[j]){
                count+=j-mid-1;
                temp[c++]=arr[i++];
            }
            else
                temp[c++]=arr[j++];
        }
        while(j<=r)
            temp[c++]=arr[j++];
        while(i<=mid){
            count+=j-mid-1;
            temp[c++]=arr[i++];
        }
        for(i=0;i<temp.length;++i)
            arr[i+l]=temp[i];
        return count;
    }

}
