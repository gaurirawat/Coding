package IB;
//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
public class LL_ib_remove_duplicates_from_sorted_LL_2 {
    public ListNode deleteDuplicates(ListNode node) {
        if(node==null||node.next==null) return node;
        if(node.val!=node.next.val){
            node.next=deleteDuplicates(node.next);
            return node;
        }
        else{
            while(node.next!=null && node.val==node.next.val)
                node=node.next;
            return deleteDuplicates(node.next);
        }
    }
}
