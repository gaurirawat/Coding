package revision;
// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
import java.util.*;
public class Array_lc_Kth_largest_element {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> q= new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<nums.length;++i){
			q.add(nums[i]);
		}
		while(--k!=0)
			q.poll();
		return q.poll();
	}

//	public int findKthLargest(int[] nums, int k) {
//        if(nums.length==1)
//            return nums[0];
//        else
//            return findRank(nums, 0,nums.length-1,nums.length-k+1);
//    }

    public int findRank(int arr[], int l, int r, int k){
        	if(l==r)
    		return arr[l];
    	// System.out.print(l+" "+ r+ " "+ k+":");
    	int rPivot= (new Random()).nextInt(r-l+1);
    	// System.out.print(arr[rPivot +l]);
    	swap(arr, rPivot+l,l);
      	int pos= partition(arr,l,r);
      	int rank= pos-l+1;
      	// System.out.println(Arrays.toString(arr));
      	if (k== rank)
      		return arr[pos];
      	else if(k> rank)
      		return findRank(arr, pos+1, r, k-rank);
      	else 
      		return findRank(arr, l, pos-1, k);
    }

    //partition function returns rank of the pivot ie if the pivot is at cell 5(0,1,2...), 
    //the func returns 6(1,2,3...).

    public int partition(int arr[], int l, int r){
        int p= arr[l];
        int a=l;
    	l=l+1;
    	if(l==r & p>arr[l]) {
    		swap(arr,a,l);
    		return l;
    	}
        while(l<r){
            while(l<=r && arr[l]<=p )++l;
            while(l<r && arr[r]>p )--r;
            if(l<r)
            	swap(arr, l, r);
        }
        swap(arr,a,l-1);
        return l-1;
    }
 public void swap(int arr[], int a,int b){
	int t= arr[a];
	arr[a]= arr[b];
	arr[b]= t;
	}
}

//    public int findKthLargest(int[] nums, int k) {
//         if(nums.length==1)
//             return nums[0];
//         else
//             return findRank(nums, 0,nums.length-1,nums.length-k);  
//     }

// 	public int findRank(int arr[], int l,int r, int rnk){
//         if(l==r)
//             return arr[l];
// 		int rp= (new Random()).nextInt(r-l+1);
//         // System.out.println(l+" "+r+" "+arr[rp+l]);
// 		swap(rp+l,l, arr);
// 		int p= partition(arr, l, r);
//         // System.out.println("rank "+p+ " "+ rnk);
// 		if(p==rnk)
// 			return arr[p];
// 		else if(p<rnk)
// 			return findRank(arr, p+1, r, rnk);
// 		else 
// 			return findRank(arr, l, p-1, rnk);
// 	}

// 	public void swap(int a, int b, int arr[]){
// 		int t= arr[a];
// 		arr[a]= arr[b];
// 		arr[b]=t;
// 	} 

// 	public int partition(int arr[], int l, int r){
//         // System.out.println(l+" "+r+" "+arr[rp]);
		
//         int a=l;
// 		for(int i=l+1; i<=r; ++i){
// 			if(arr[i]<arr[l])
// 				swap(++a, i, arr);
// 		}
// 		swap(a, l, arr);
// 		return a;
// 	}