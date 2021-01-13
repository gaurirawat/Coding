package revision;
//https://leetcode.com/problems/copy-list-with-random-pointer/submissions/

import java.util.*;
// maps are being used here since we cannot modify the original list
public class LL_lc_deep_copy_list_with_random_pointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node clone = generateNewList(head, map);
        setRandomPointers(head, clone, map);
        return clone;
    }

    public Node generateNewList(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        newNode.next = generateNewList(node.next, map);
        map.put(node, newNode);
        return newNode;
    }

    public void setRandomPointers(Node node, Node clone, HashMap<Node, Node> map) {
        if (node == null) {
            return;
        }
        if (node.random != null) {
            clone.random = map.get(node.random);
        }
        setRandomPointers(node.next, clone.next, map);
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
