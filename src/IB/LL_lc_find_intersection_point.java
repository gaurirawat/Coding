package IB;
//https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
//https://www.interviewbit.com/problems/intersection-of-linked-lists/

/* below problem has two soln. First one is amazing. second one is a bit slow. As in first works in
 * 3ms, second in 8ms. Explained better in notebook.
 */

//VERY VERY EASY SOLUTION. JUST RECALL

import java.util.HashSet;

public class LL_lc_find_intersection_point {
	public ListNode getIntersectionNode1(ListNode a, ListNode b) {
        if(a==null||b==null) return null;
        ListNode ta=a,tb=b;

//        traverse till both lists are iterable
        while(ta!=null&&tb!=null){
            ta=ta.next;
            tb=tb.next;
        }

        ListNode sm,big;
        int k=0;

//        if both are same then simply put big sm as any of these lists
        if(ta==null && tb==null){
            sm=a;
            big=b;
        }
//        if ta is null then a is the small list, b is the big one. Now calculate k
        else if(ta==null){
            sm=a;
            big=b;
            while(tb!=null){
                k++;
                tb=tb.next;
            }
        }
//        if tb is null then b is the small list, a is the big one. Now calculate k
        else{
            sm=b;
            big=a;
            while(ta!=null){
                k++;
                ta=ta.next;
            }
        }

        //now move big by k steps irrespective of which one that is a or b
        while(k--!=0)
            big=big.next;

        //both are of equal length now. Increment them together and check for equality
        while(big!=null){
            if(sm==big)
                return sm;
            sm=sm.next;
            big=big.next;
        }
        return null;
    }

    //solution two
	public ListNode getIntersectionNode2(ListNode a, ListNode b) {
        if(a==null || b==null)
            return null;
        HashSet<ListNode> tb= new HashSet<ListNode>();
        while(a!=null){
            tb.add(a);
            a=a.next;
        }
        while(b!=null){
            if(tb.contains(b))
                return b;
            b=b.next;
        }
        return null;
    }
}
