package IB;
//https://www.interviewbit.com/problems/sort-list/
public class LL_ib_sorting_merge_sort {
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next==null) return head;
        int len=0;
        ListNode node=head;
        while(node!=null){
            ++len;
            node=node.next;
        }
        len/=2;

        node=head;
        while(--len!=0)
            node=node.next;

        ListNode l1=head;
        ListNode l2=node.next;
        node.next=null;
        l1=sortList(l1);
        l2=sortList(l2);
        head=merge(l1,l2);
        return head;
    }

    public ListNode merge(ListNode a, ListNode b){
        if(a==null) return b;
        if(b==null) return a;
        if(a.val<b.val){
            a.next=merge(a.next,b);
            return a;
        }
        b.next=merge(a,b.next);
        return b;
    }
}
