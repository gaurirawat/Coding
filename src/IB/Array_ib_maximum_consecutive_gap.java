package IB;
//https://leetcode.com/articles/maximum-gap/#
//https://leetcode.com/problems/maximum-gap/discuss/761750/Java-Buckets-Solution
//https://leetcode.com/problems/maximum-gap/submissions/
/*
1. The Pigeonhole Principle states that if n items are put into m containers, with n>m , then at least one container
must contain more than one item.
2. So here we can say that for n elements we should take n-1 buckets.
3. Now coming to the capacity, for n-1 buckets and range of (max-min) the cap should be t=(max−min)/(n−1). ie. each
bucket will hold a max of t range of numbers. ie the diff btw the numbers would be a max of t. To stay on the safer side
we take a smaller gap tobe on the safer side so that by any chance the diff within a bucket doesn't become exceed t.
4. Since the cap changed we'll calculate the no of buckets again. now buckets= (max−min)/capacity +1. (why +1? LATER)
5. place elements in their correct buckets. index of bucket will be calculated as is (element-min)/cap.
6. at the time of placing elements keep track of min and max for each bucket.
7. now considering only the buckets which have an item find the diff btw curr bucket min and prev bucket max.

now why this plus one?
If array is [1,100] and current element=100 & min=1 then :
cap=(100-1)/1=99, no of buckets= 99/99=1 and for element =100, when we calc the index of bucket then (100-1)/99 gives 1
so we go out of array index. Hence we take one more bucket.
 */
import java.util.Arrays;
public class Array_ib_maximum_consecutive_gap {

    public int maximumGap(final int[] a) {
        if(a.length<=1) return 0;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int x:a){
            min=Math.min(min,x);
            max=Math.max(max,x);
        }
        if(max-min==0)
            return 0;

        int cap=Math.max(1,(max-min)/(a.length-1)); //important to take max with 1. otherwise we might get result as 1.
        int noOfBuck= (max-min)/cap +1;
        int mxb[]= new int[noOfBuck];
        int mnb[]= new int[noOfBuck];
        Arrays.fill(mxb, Integer.MIN_VALUE);
        Arrays.fill(mnb, Integer.MAX_VALUE);

        for(int x:a){
            int val=x-min;
            int i= val/cap;
            mxb[i]=Math.max(x,mxb[i]);
            mnb[i]=Math.min(x,mnb[i]);
        }
        // System.out.println(Arrays.toString(mxb));
        // System.out.println(Arrays.toString(mnb));
        int mxdiff=mxb[0]-mnb[0];
        int lastmin=mxb[0];
        for(int i=1;i<mxb.length;++i){
            if (mnb[i]==Integer.MAX_VALUE && mxb[i]==Integer.MIN_VALUE)
                continue;
            mxdiff=Math.max(mxdiff, mnb[i]-lastmin);
            lastmin=mxb[i];
            // System.out.println(mxdiff+" "+ lastmin);
        }
        return mxdiff;
    }
}
