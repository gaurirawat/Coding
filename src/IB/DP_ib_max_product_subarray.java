package IB;
//https://www.interviewbit.com/problems/max-product-subarray/
public class DP_ib_max_product_subarray {
    public int maxProduct(final int[] arr) {
        if(arr.length==1) return arr[0];
        int min=arr[0],max=arr[0];
        int tmax=arr[0];
        for(int i=1;i<arr.length;++i){
            int min2=Math.min(arr[i],max*arr[i]);
            min2=Math.min(min2,min*arr[i]);
            int max2=Math.max(arr[i],arr[i]*max);
            max2=Math.max(max2,arr[i]*min);
            max=max2;
            min=min2;
            tmax=Math.max(tmax,max);
        }
        return tmax;
    }
}
