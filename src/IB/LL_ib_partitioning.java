package IB;
//https://leetcode.com/problems/partition-list/submissions/
//https://www.interviewbit.com/problems/partition-list/
public class LL_ib_partitioning {
    public ListNode partition(ListNode root, int k) {
        if(root==null||root.next==null)return root;
        ListNode smHead=new ListNode(0),grHead=new ListNode(0);
        ListNode sm=smHead,gr=grHead;
        while(root!=null){
            if(root.val<k){
                sm.next=root;
                sm=sm.next;
            }
            else{
                gr.next=root;
                gr=gr.next;
            }
            root=root.next;
        }
        smHead=smHead.next;
        grHead=grHead.next;
        if(smHead==null) return grHead;
        else if(grHead==null) return smHead;

        sm.next=grHead;
        gr.next=null;
        return smHead;
    }
}
