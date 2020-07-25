package revision;
//https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
public class LL_gfg_remove_a_loop {
    public static void removeLoop(Node2 head){
        if(head==null) return;
        Node2 slow=head;
        Node2 fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next!=null? fast.next.next: fast.next;
            if(slow==fast)
                break;
        }
        if(fast==null) return;

        //if we come here, it we got a loop
        //now calculate the length of the loop.
        int k=0;
        Node2 target=slow;
        int len=1;
        slow=slow.next;
        while(target!=slow){
            len++;
            slow=slow.next;
        }
        System.out.println(len);
        /*
        start again from head. take fast pointer ahead by steps equal
        to the length of the cycle. Now both start traversing the LL together.
        whenever both are at the same Node2 we have found the starting point of the cycle
        */
        slow=head;
        fast=head;
        while(len--!=0)
            fast=fast.next;

        //we find the starting of the loop
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        //now search for the last node of the loop
        while(fast.next!=slow)
            fast=fast.next;
        fast.next=null;
    }



    public static void main(String[] args) {
        Node2 a=new Node2(1);
        a.next=new Node2(2);
        a.next.next=new Node2(3);
        Node2 b=new Node2(4);
        b.next=new Node2(5);
        b.next.next=a.next.next;
        a.next.next.next=b;
        removeLoop(a);
        
    }
}
class Node2
{
    int data;
    Node2 next;
    public Node2(int data){
        this.data=data;
    }
}