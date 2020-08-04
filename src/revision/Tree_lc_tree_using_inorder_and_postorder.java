package revision;

import java.util.*;
//https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
public class Tree_lc_tree_using_inorder_and_postorder {
    int c;
    public TreeNode buildTree(int io[], int po[]) {
        if(io==null||io.length==0) return null;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<io.length;++i)
            map.put(io[i],i);
        c=io.length-1;
        return buildTreeInner(map,po,0,io.length-1);

    }
    public TreeNode buildTreeInner(HashMap<Integer,Integer> map, int po[], int li, int ui){
        if(c<0||li>ui)return null;
        int x=po[c];
        TreeNode root =null;
        int pos=map.get(x);
        if(pos>=li && pos<=ui){
            root= new TreeNode(x);
            c--;
            root.right=buildTreeInner(map,po,pos+1,ui);
            root.left=buildTreeInner(map,po,li,pos-1);
        }
        return root;
    }
}
