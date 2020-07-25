package revision;
//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

public class Tree_gfg_convert_BT_to_DLL {
    Node bToDLL(Node root)
    {
        if(root ==null) return null;
        Node head=root;
        if(root.right!=null){
            root.right=bToDLL(root.right);
            root.right.left=root;
        }
        if(root.left!=null){
            head=bToDLL(root.left);
            Node temp=head;
            while(temp.right!=null)
                temp=temp.right;
            temp.right=root;
            root.left=temp;
        }
        return head;
    }
}
