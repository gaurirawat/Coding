package revision;

//https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Tree_lc_kth_ancester_of_a_tree {
	
	String ans=null;

	public Node buildTree (String s){
		if(s.length()==0 || s==null)
			return null;
		String a[] = s.split(" ");

		Node head= new Node(Integer.parseInt(a[0]));
		int ctr=1;
		Queue<Node> q= new LinkedList<Node>();
		q.add(head);

		while(q.size()!=0 && ctr<a.length){
			Node node= q.poll();
			
			node.left= a[ctr].equals("N")? null:new Node(Integer.parseInt(a[ctr]));
			if(node.left!=null)
				q.add(node.left);
			ctr++;

			if(!(ctr<a.length))
				break;

			node.right= a[ctr].equals("N")? null: new Node(Integer.parseInt(a[ctr]));
			if(node.right!=null)
				q.add(node.right);
			ctr++;
		}
		return head;
	}

	
	public void printInorder(Node node){
		if(node==null)
			return;
		printInorder(node.left);
		System.out.println(node.data);
		printInorder(node.right);
	}

	public int kthAncestor(Node node, int k, int val){
		ans=null;
		innerKthAncestor(node, k, val); 
		if(ans==null)
			return -1;
		else
			return Integer.parseInt(ans);
	} 

	public int innerKthAncestor(Node node, int k, int val){
		if(node==null)
			return 0;
		if(node.data ==val)
			return -1;

		int x= innerKthAncestor(node.left, k, val);
		if(x==0) 
			x= innerKthAncestor(node.right,k,val);

		if(x==0)
			return 0;
		else if(x+k==0 && ans==null)
			ans=""+node.data;
		return x-1;
	}
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t--!=0){
			String a[]= br.readLine().split(" ");
			int k= Integer.parseInt(a[0]);
			int val= Integer.parseInt(a[1]);
			String s= br.readLine();
			Tree_lc_kth_ancester_of_a_tree obj= new Tree_lc_kth_ancester_of_a_tree();
			Node node= obj.buildTree(s);
			System.out.println(obj.kthAncestor(node, k, val));
			}
		}
	
	class Node{
		Node left;
		Node right;
		int data;
		public Node(int data){
			this.data= data;
			left= right=null;
		}
	}
	
}

