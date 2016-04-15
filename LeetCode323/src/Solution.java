import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < edges.length; i++) {
            int src = parent[edges[i][0]];
            int des = parent[edges[i][1]];
            
            if (src != des) {
                union(parent, edges[i][0], edges[i][1]);
            }
        }
        for (int i = 0; i < n; i++) {
            set.add(find(parent, i));
        }
        return set.size() - 1;
    }
    
    public void union(int[] parent, int src, int des) {
        parent[find(parent, src)] = find(parent, des);
    }
    
    public int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        } 
        //parent[node] = find(parent, parent[node]);
        return parent[node];
    }
    
    public static void main(String[] args) {
		new Solution().countComponents(5, new int[][] {
			{0,1},
			{1,2},
			{2,3},
			{3,4}
			
		});
	}
    /*private void bfs(int i, Map<Integer, List<Integer>> graph, boolean[] visit) {
        if (visit[i]) {
            return;
        }
        visit[i] = true;
        List<Integer> neighbors = graph.get(i);
        for (Integer integer: neighbors) {
            bfs((int)integer, graph, visit);
        }
    }*/
}