import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
 
 public class Solution {
	    
	    Map<Integer, UndirectedGraphNode> nodePool;
	    
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if (node == null) return null;
	        nodePool = new HashMap<>();
	        return _clone(node);
	    }
	    
	    private UndirectedGraphNode _clone(UndirectedGraphNode src) {
	        UndirectedGraphNode dest = new UndirectedGraphNode(src.label);
	        nodePool.put(src.label, dest);
	        
	        for (UndirectedGraphNode neighbor : src.neighbors) {
	            if (nodePool.get(neighbor.label) == null) {
	                dest.neighbors.add(_clone(neighbor));
	            }
	            else
	                dest.neighbors.add(nodePool.get(neighbor.label));
	        }
	        return dest;
	    }
	    
	    
	}