package revision;
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class LL_lc_flatten_a_multilevel_DLL {
    public Node flatten(Node head) {
        if(head==null) return head;
//        CASE 1: when there is no child
        if(head.child==null)
            flatten(head.next);

//        CASE 2: child exists
        else{
//            flatten the child and find the tail
            Node child=flatten(head.child);
            while(child.next!=null)
                child=child.next;

//            connect tail and the next of the head
            child.next=head.next;
            if(head.next!=null)
                head.next.prev=child;

//            bring the child on the same level
            head.next=head.child;
            head.child.prev=head;
            head.child=null;
            flatten(child.next);
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}

