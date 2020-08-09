package IB;
//https://www.interviewbit.com/problems/add-two-numbers-as-lists/
public class LL_ib_add_two_numbers_as_list {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        return add(a,b,0);
    }

    public ListNode add(ListNode a,ListNode b, int c){
        if(a==null && b==null &&c==0)return null;
        int x= getVal(a)+getVal(b)+c;
        ListNode node=new ListNode(x%10);
        node.next=add(a==null?a:a.next,b==null?b:b.next,x/10);
        return node;
    }

    public int getVal(ListNode x){
        return x==null?0:x.val;
    }
}
