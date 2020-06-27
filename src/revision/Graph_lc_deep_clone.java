package revision;
// https://leetcode.com/problems/clone-graph/submissions/
import java.util.*;

public class Graph_lc_deep_clone {
	class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

    public Node cloneGraph(Node node) {
    	HashMap<Integer, Node> map= new HashMap<Integer, Node>();
    	map.put(node.val, new Node(node.val));
        Queue<Node> q= new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()){
        	Node tmp= q.poll();
        	Iterator<Node> itr= tmp.neighbors.listIterator();
        	while(itr.hasNext()){
        		Node x= itr.next();
        		if(!map.containsKey(x.val)) {
        			q.add(x);
        			map.put(x.val, new Node(x.val));
        		}
        		map.get(tmp.val).neighbors.add(map.get(x.val));
        	}
        }
        return map.get(node.val);
    }
}