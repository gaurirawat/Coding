package revision;
//https://www.interviewbit.com/problems/add-two-numbers-as-lists/
public class LL_ib_add_two_no_as_list {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if(a==null|| b==null)
            return a==null?b:a;
        ListNode saveA=a;
        int carry=0;
        while(a.next!=null && b.next!=null){
            a.val= a.val+b.val+carry;
            carry=a.val/10;
            a.val=a.val%10;
            a=a.next;
            b=b.next;
        }
        a.val= a.val+b.val+carry;
        carry=a.val/10;
        a.val=a.val%10;
        if(!(a.next==b.next && a.next==null)){
            if(a.next==null)
                a.next=b.next;
            a=a.next;
            while(a.next!=null){
                a.val= a.val+carry;
                carry=a.val/10;
                a.val=a.val%10;
                a=a.next;
            }
            a.val= a.val+carry;
            carry=a.val/10;
            a.val=a.val%10;
        }
        if(carry!=0)
            a.next=new ListNode(1);
        return saveA;  
    }
}
