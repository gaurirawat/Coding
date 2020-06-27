package revision;
//https://leetcode.com/problems/delete-node-in-a-linked-list/

public class LL_lc_delete_node {
	 public void deleteNode(ListNode node) {
	        node.val =node.next.val;
	        node.next=node.next.next;
	    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}