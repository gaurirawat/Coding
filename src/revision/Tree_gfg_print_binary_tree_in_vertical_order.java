package revision;
//https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
import java.util.*;

public class Tree_gfg_print_binary_tree_in_vertical_order {

    static ArrayList<Integer> verticalOrder(Node root)
    {
        if(root==null) return null;
        int minHd=Integer.MAX_VALUE;
        int maxHd=Integer.MIN_VALUE;
        HashMap<Integer,List<Integer>> map= new HashMap<Integer,List<Integer>>();

        Deque<QueueNode> q= new LinkedList<QueueNode>();
        q.addLast(new QueueNode(0,root));
        while(q.size()!=0){
            QueueNode qnode=q.pollFirst();
            minHd=Math.min(minHd, qnode.hd);
            maxHd=Math.max(maxHd, qnode.hd);

            if(map.containsKey(qnode.hd))
                map.get(qnode.hd).add(qnode.root.data);
            else{
                ArrayList<Integer> ls= new ArrayList<Integer>();
                ls.add(qnode.root.data);
                map.put(qnode.hd,ls);
            }
            if(qnode.root.left!=null)
                q.add(new QueueNode(qnode.hd-1,qnode.root.left));
            if(qnode.root.right!=null)
                q.add(new QueueNode(qnode.hd+1,qnode.root.right));
        }

        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=minHd;i<=maxHd;++i)
            ans.addAll(map.get(i));
        return ans;
    }

}
class QueueNode{
    int hd;
    Node root;
    public QueueNode(int hd, Node root){
        this.hd=hd; this.root=root;
    }
}
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}