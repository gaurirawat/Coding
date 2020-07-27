package revision;
//https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
public class LL_gfg_remove_a_loop {
    public static void removeLoop(Node head){
        if(head==null) return;
        Node slow=head;
        Node fast=head;
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
        Node target=slow;
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
        whenever both are at the same Node we have found the starting point of the cycle
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

    class Node
    {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }
    
}
