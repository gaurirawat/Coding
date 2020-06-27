package revision;
//https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
public class LL_ib_swap_in_pairs {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	    public ListNode swapPairs(ListNode a) {
	        if(a!=null && a.next!=null){
	            ListNode temp=a.next;
	            a.next=a.next.next;
	            temp.next=a;
	            a=temp;
	            a.next.next=swapPairs(a.next.next);
	        }
	        return a;    
	    }
}
