package revision;

// https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1

public class Tree_gfg_isomorphic_tree {

	public int getdata(Node root) {
		if(root==null)
			return -999;
		else
			return root.data;
	}
	public boolean isIsomorphic(Node t1, Node t2) {
		if(t1.data== t2.data)
			return isIsomorphicInner(t1,t2);
		else
			return false;
	}
	public boolean isIsomorphicInner(Node t1, Node t2) {
	    if(t1==null&& t2==null) 
	        return true;
        boolean ans=false; 
		if(getdata(t1.left)==getdata(t2.left) && getdata(t1.right)==getdata(t2.right))
		    ans= isIsomorphicInner(t1.left, t2.left)&& isIsomorphicInner(t1.right, t2.right);
		if (getdata(t1.left)==getdata(t2.right) && getdata(t1.right)==getdata(t2.left))
		    ans= ans || isIsomorphicInner(t1.left, t2.right)&& isIsomorphicInner(t1.right, t2.left);
		return ans;
	}
}