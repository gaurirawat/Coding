package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/maximum-edge-removal/
public class Tree_ib_maximum_edge_removal {

    int removedEdgesCount;
    public int solve(int n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<nAryTree> l= new ArrayList<nAryTree>();
        for(int i=0;i<n;++i)
            l.add(new nAryTree(i));
        int[] in = new int[n];
        for(ArrayList<Integer> t: edges){
            l.get(t.get(0)-1).children.add(l.get(t.get(1)-1));
            in[t.get(1)-1]++;
        }
        nAryTree root=null;
        for(int i=0;i<n;++i)
            if(in[i]==0){
                root=l.get(i);
                break;
            }
        removedEdgesCount=0;
        removeEdges(root, null);
        return removedEdgesCount;
    }

    public int removeEdges(nAryTree root, nAryTree parent){
        if(root==null) return 0;
        int count=1;

        for(int i=0;i<root.children.size();++i){
            nAryTree child=root.children.get(i);
            if(child==parent) continue;
            int x=removeEdges(child, root);
            if(x%2==0){
                root.children.remove(child);
                removedEdgesCount++;
                --i;
            }
            else
                count+=x;
        }
        return count;
    }
}
class nAryTree{
    int val;
    ArrayList<nAryTree> children;
    public nAryTree(int a){
        val=a;
        children= new ArrayList<nAryTree>();
    }
}