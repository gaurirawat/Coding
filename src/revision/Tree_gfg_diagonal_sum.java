package revision;
// https://practice.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1/?track=sp-trees&batchId=152

import java.util.*;
public class Tree_gfg_diagonal_sum {
	static ArrayList<Integer> al = new ArrayList<Integer>();

    public void diagonalSum(Node root){
        al.clear();
        innerDiagonalSum(root, 0);
        print();
    }

    public void print(){
    	for(Integer x: al)
    		System.out.print(x+" ");
    }

    public void innerDiagonalSum(Node node, int diag){
    	if(node==null)
    		return;
    	if(al.size()<diag+1)
    		al.add(node.data);
    	else
    		al.set(diag, node.data+al.get(diag));
        innerDiagonalSum(node.left,diag+1);
        innerDiagonalSum(node.right, diag);
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node() {}
    Node(int data) { this.data = data; }
    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
