package IB;

import java.util.*;

//https://www.interviewbit.com/problems/clone-graph/
public class Graph_ib_clone_graph {
    HashMap<Integer, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map=new HashMap<Integer, UndirectedGraphNode> ();
        populateMapwithAllNodes(node);
        HashSet<Integer> set =new HashSet<Integer>();
        createNewGraph(node, set);
        return map.get(node.label);
    }

    public void populateMapwithAllNodes(UndirectedGraphNode node){
        map.put(node.label, new UndirectedGraphNode(node.label));
        for(UndirectedGraphNode child: node.neighbors){
            if(map.get(child.label)==null)
                populateMapwithAllNodes(child);
        }
    }

    public void createNewGraph(UndirectedGraphNode node, HashSet<Integer> set){
        set.add(node.label);
        ArrayList<UndirectedGraphNode> l=new ArrayList<UndirectedGraphNode>();
        for(UndirectedGraphNode child: node.neighbors){
            l.add(map.get(child.label));
            if(!set.contains(child.label))
                createNewGraph(child, set);
        }
        map.get(node.label).neighbors=l;
    }
}
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}