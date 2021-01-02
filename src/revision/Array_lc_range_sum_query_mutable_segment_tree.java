package revision;

import java.util.Arrays;

//https://leetcode.com/problems/range-sum-query-mutable/

public class Array_lc_range_sum_query_mutable_segment_tree {
    int[] nums;
    int[] tree;
    public Array_lc_range_sum_query_mutable_segment_tree(int[] a) {
        if(a.length==0) {
            nums=new int[0];
            tree= new int[3];
            return ;
        }
        nums=a;
        //Maximum size of segment tree
        int x = (int) (Math.ceil(Math.log(nums.length) / Math.log(2)));
        int size = 2 * (int) Math.pow(2, x) - 1;
        tree=new int[size];
        constructTree(0,0,nums.length-1);
//        System.out.println(Arrays.toString(tree));
    }

    public int constructTree(int iTree, int l, int r) {
        if(l==r) {
            tree[iTree]=nums[l];
            return tree[iTree];
        }
        int mid=l+(r-l)/2;
        tree[iTree]=constructTree(2*iTree+1,l,mid);
        tree[iTree]+=constructTree(2*iTree+2, mid+1, r);
        return tree[iTree];
    }

    public void update(int i, int newValue) {
        int diff=newValue-nums[i];
        nums[i]=newValue;
        updateInner(0, nums.length - 1, 0, diff,i);
    }

    public void updateInner(int l,int r, int iTree, int diff, int i) {
        tree[iTree]+=diff;
        if(l==r) {
            return;
        }
        int mid=l+(r-l)/2;
        if (i<=mid) {
            updateInner(l,mid,2*iTree+1, diff, i);
        } else {
            updateInner(mid+1,r,2*iTree+2, diff, i);
        }
    }

    public int sumRange(int i, int j) {
        return getSum(0,nums.length-1,i,j,0);
    }

    public int getSum(int l, int r, int lQuery, int rQuery, int iTree) {
        int retVal=0;
        if(r<lQuery || rQuery<l) {
            retVal= 0;
        } else if(lQuery<=l && r<=rQuery) {
            retVal= tree[iTree];
        } else{
            int mid=l+(r-l)/2;
            retVal= getSum(l,mid,lQuery,rQuery,iTree*2+1)+getSum(mid+1, r, lQuery, rQuery,iTree*2+2);
        }
        System.out.println(l+ ","+r+ ","+iTree+","+retVal);
        return retVal;
    }
}
