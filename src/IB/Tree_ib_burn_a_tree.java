package IB;
//https://www.interviewbit.com/problems/burn-a-tree/
public class Tree_ib_burn_a_tree {
    TreeWithParentPointer burningLeaf;
    public int solve(TreeNode root, int k) {
        burningLeaf=null;
        generateNewTree(root, null, k);
        return maxLengthOfPath(burningLeaf, null)-1;
    }

    public TreeWithParentPointer generateNewTree(TreeNode root, TreeWithParentPointer parent, int k){
        if(root==null) return null;
        TreeWithParentPointer currRoot = new TreeWithParentPointer(root.val, parent);
        currRoot.left=generateNewTree(root.left, currRoot, k);
        currRoot.right=generateNewTree(root.right, currRoot, k);
        if(currRoot.left==null && currRoot.right==null && root.val==k)
            burningLeaf=currRoot;
        return currRoot;
    }

    public int maxLengthOfPath(TreeWithParentPointer root, TreeWithParentPointer parent){
        int len= (root.left!=null && root.left!=parent)?maxLengthOfPath(root.left, root):0;
        len=Math.max(len, (root.right!=null && root.right!=parent)?maxLengthOfPath(root.right, root):0);
        len=Math.max(len, (root.parent!=null && root.parent!=parent)?maxLengthOfPath(root.parent, root):0);
        return len+1;
    }
    class TreeWithParentPointer{
        TreeWithParentPointer parent, left, right;
        int val;
        public TreeWithParentPointer(int n, TreeWithParentPointer x){
            parent=x;
            val=n;
        }
    }
}