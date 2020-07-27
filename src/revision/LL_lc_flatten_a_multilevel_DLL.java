package revision;

public class LL_lc_flatten_amultilevel_DLL {
    public Node flatten(Node head) {
        if(head==null) return head;
        if(head.child==null)
            flatten(head.next);
        else{
            Node child=flatten(head.child);
            while(child.next!=null)
                child=child.next;
            child.next=head.next;
            if(head.next!=null)
                head.next.prev=child;

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

