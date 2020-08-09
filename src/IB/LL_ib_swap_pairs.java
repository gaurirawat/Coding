package IB;
//https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
public class LL_ib_swap_pairs {
    public ListNode swapPairs(ListNode a) {
        if(a==null||a.next==null)return a;
        ListNode nextSet=a.next.next;
        a.next.next=a;
        a=a.next;
        a.next.next=swapPairs(nextSet);
        return a;
    }
}
