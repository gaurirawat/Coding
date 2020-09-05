package IB;
//https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
public class Tree_ib_sorted_list_to_BST {
    public TreeNode sortedListToBST(ListNode node) {
        if(node==null) return null;
        if(node.next==null) return new TreeNode(node.val);
        ListNode slow=node,fast=node.next;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.next.val);
        root.right=sortedListToBST(slow.next.next);
        slow.next=null;
        root.left=sortedListToBST(node);
        return root;
    }
}
