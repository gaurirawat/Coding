package SupportMaterial.DataStructureImplementation;

//https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
//https://www.baeldung.com/java-avl-trees
public class AVL_impl_generic<T extends Comparable<T>> {


    public AVLTreeNode<T> insert(T t,AVLTreeNode<T> root) {
        if(root==null){
            return new AVLTreeNode<T>(t);
        }
        if(t.compareTo(root.val)<0) {
            root.left=insert(t,root.left);
        } else{
            root.right=insert(t,root.right);
        }

        root.ht=1+Math.max(root.left.ht,root.right.ht);
        int balance=getBalance(root);
        if (balance>1 && t.compareTo((T) root.left.val)>0){
            root=leftRight(root.left);
        }
        else if (balance>1 && t.compareTo((T) root.left.val)<0){
            root=leftLeft(root.left);
        }
        else if (balance<-1 && t.compareTo((T) root.right.val)>0){
            root=rightRight(root.left);
        }
        else if (balance<-1 && t.compareTo((T) root.right.val)<0){
            root=rightLeft(root.left);
        }
        return root;
    }

    public AVLTreeNode<T> leftLeft(AVLTreeNode<T> root){
        AVLTreeNode<T> a=root;
        AVLTreeNode<T> b=root.left;
        a.left=b.right;
        b.right=a;
        a.ht=1+Math.max(getHeight(a.left), getHeight(a.right));
        b.ht=1+Math.max(getHeight(b.left), getHeight(b.right));
        return b;
    }

    public AVLTreeNode<T> rightRight(AVLTreeNode<T> root){
        AVLTreeNode<T> a=root;
        AVLTreeNode<T> b=root.right;
        a.right=b.left;
        b.left=a;
        a.ht=1+Math.max(getHeight(a.left), getHeight(a.right));
        b.ht=1+Math.max(getHeight(b.left), getHeight(b.right));
        return b;
    }

    public AVLTreeNode<T> leftRight(AVLTreeNode<T> root){
        AVLTreeNode<T> a=root;
        AVLTreeNode<T> b=root.left;
        AVLTreeNode<T> c=root.left.right;
        a.left=c.right;
        b.right=c.left;
        c.left=b;
        c.right=a;
        a.ht=1+Math.max(getHeight(a.left), getHeight(a.right));
        b.ht=1+Math.max(getHeight(b.left), getHeight(b.right));
        a.ht=1+Math.max(getHeight(a.left), getHeight(a.right));
        return c;
    }

    public AVLTreeNode<T> rightLeft(AVLTreeNode<T> root){
        AVLTreeNode<T> a=root;
        AVLTreeNode<T> b=root.right;
        AVLTreeNode<T> c=root.right.left;
        a.right=c.left;
        b.left=c.right;
        c.left=a;
        c.right=b;
        a.ht=1+Math.max(getHeight(a.left), getHeight(a.right));
        b.ht=1+Math.max(getHeight(b.left), getHeight(b.right));
        a.ht=1+Math.max(getHeight(a.left), getHeight(a.right));
        return c;
    }

    public int getBalance(AVLTreeNode<T> root) {
        return getHeight(root.left)-getHeight(root.right);
    }

    public int getHeight(AVLTreeNode<T> root) {
        return root==null?0:root.ht;
    }

    public void inorder(AVLTreeNode<T> root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}

class AVLTreeNode<T>{
    int ht;
    T val;
    AVLTreeNode left;
    AVLTreeNode right;

    public AVLTreeNode(T t) {
        ht=1;
        val=t;
    }

}

