package revision;
//https://www.interviewbit.com/problems/first-missing-integer/
//https://leetcode.com/problems/first-missing-positive/

/* below approach is nice. A better approach is to traverse array once. Ignore all -ve numbers and put the +ve numbers
on index (no-1). ie if we get no 5, we swap it with element at index 4. For numbers grater than a.length we ignore them.
Now traverse the array again. The first index which we find where no is not equal to it's index, we get our ans as
index+1
 */
public class Array_ib_first_missing_positive_integer {
    public int firstMissingPositive(int[] a) {
        int l=0,r=a.length-1;
        //here we are swapping the numbers such that all negatives and zeros come to the initial part of the list
        while(l<r){
            while(l<r && a[l]<=0)++l;
            while(l<r && a[r]>0)--r;
            if(l<r){
                int t=a[l];
                a[l]=a[r];
                a[r]=t;
                ++l;--r;
            }
        }
        //we replace all negatives and all zeros by 1
        int i=0;
        while(i<a.length && a[i]<=0){
            a[i]=1;
            i++;
        }

        //if there are no positives then return 1 to be first missing positive number
        if(i==a.length)
            return 1;

        /*now we traverse the remaining positive numbers. For each positive number, if the no-1 is greater that the
        length then we ignore it otherwise we goto that index(no-1) and make it -ve. Remember that the same number can
        come multiple times so before changing the sign we need to check if it's already -ve.
         */

        for(;i<a.length;++i){
            if((Math.abs(a[i])-1)<a.length && a[Math.abs(a[i])-1]>0)
                a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
        }

        /*for all the positive no that are there in the array the no-1 index is negative. We search for the first +ve
        index and return that index+1 value
         */
        for(i=0;i<a.length;++i){
            if(a[i]>0)
                return i+1;
        }

        /*since we are changing sign of no-1 index we can track max of n.length number. if all are negative then return
        a.length+1
        */
        return a.length+1;
    }
}
