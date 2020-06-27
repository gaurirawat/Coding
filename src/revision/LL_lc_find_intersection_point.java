package revision;
//https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/

/* below problem has two soln. First one is amazing. second one is a bit slow. As in first works in
 * 3ms, second in 8ms. Explained better in notebook.
 */

//VERY VERY EASY SOLUTION. JUST RECALL
import java.util.*;
public class LL_lc_find_intersection_point {
	public ListNode getIntersectionNode1(ListNode a, ListNode b) {
        if(a==null || b==null)
            return null;
        
//        traverse till both lists are iterable
        ListNode pa=a, pb=b;
        while(pa!=null && pb!=null){
            pa=pa.next;
            pb=pb.next;
        }
        
/*        we find jumpa and jumpb which contain the jump steps that need to be taken initially 
        after which both lists shall be of equal length. At anytime either one of them will be
        zero since one will be longer. For equal length both will be zero.
  */
        int jumpa=0, jumpb=0;
        while(pa!=null){
            pa=pa.next;
            jumpa++;
        }
        while(pb!=null){
            pb=pb.next;
            jumpb++;
        }
        
        //now whichever list is smaller shall take that no of jump steps for both to have same no of 
//        remaining nodes left
        pa=a; pb=b;
        while(jumpa--!=0){
            pa=pa.next;
        }
        while(jumpb--!=0){
            pb=pb.next;
        }
        
        //now we check for intersection when nodes are at same distance form the end.
        while(pa!=null && pb!=null){
            if(pa.equals(pb))
                return pa;
            pa=pa.next;
            pb=pb.next;
        }
        return null;
    }
	
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
