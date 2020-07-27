package revision;
//https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
public class LL_gfg_sort_list_of_012 {
    static Node segregate(Node head)
    {
        if(head==null) return head;
        int ones=0;
        int zeros=0;
        int twos=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0)zeros++;
            else if(temp.data==1) ones++;
            else twos++;
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(zeros>0){
                temp.data=0;
                zeros--;
            }
            else if(ones>0){
                temp.data=1;
                ones--;
            }
            else{
                temp.data=2;
                twos--;
            }
            temp=temp.next;
        }
        return head;
    }
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
}
