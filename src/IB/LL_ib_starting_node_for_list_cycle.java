package IB;
//https://www.interviewbit.com/problems/list-cycle/
public class LL_ib_starting_node_for_list_cycle {
    public ListNode detectCycle(ListNode node) {
        ListNode slow=node,fast=node;
        while(slow!=null && fast!=null){
            slow=slow.next;
            fast= fast.next==null? fast.next : fast.next.next;
            if(slow==fast) break;
        }
        if(fast==null)return null;

        slow=node;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;

    }
}
