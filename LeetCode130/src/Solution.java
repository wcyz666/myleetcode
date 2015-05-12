import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    private int n;
    private int m;
    
    public void solve(char[][] grid) {

        m = grid.length;
        if (m == 0) return;
        n = grid[0].length;
        for (int i = 0; i < n; i++)
            if (grid[0][i] == 'O') 
                DFSMarking(grid, 0, i);
        for (int i = 0; i < n; i++)
            if (grid[m - 1][i] == 'O') 
                DFSMarking(grid, m - 1, i);
        for (int i = 0; i < m; i++)
            if (grid[i][0] == 'O') 
                DFSMarking(grid, i, 0);
        for (int i = 0; i < m; i++)
            if (grid[i][n - 1] == 'O') 
                DFSMarking(grid, i, m - 1);        
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) { 
                if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
                else if (grid[i][j] == 'b')
                    grid[i][j] = 'O';
            }
    }

/*    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n  || grid[i][j] == 'X' || grid[i][j] == 'b') return;
        grid[i][j] = 'b';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
*/
    private class Pair {
    	public int i;
    	public int j;
    	public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
    }
    private void DFSMarking(char[][] grid, int i, int j) {
    	Queue<Pair> pairs = new LinkedList<>();
    	pairs.offer(new Pair(i, j));
    	while (!pairs.isEmpty()) {
    		Pair pair = pairs.poll();
    		int x = pair.i, y = pair.j;
    		grid[x][y] = 'b';
    		if (x + 1 >= 0 && y > 0 && x + 1 < m && y < n && grid[x + 1][y] == 'O')
    			pairs.offer(new Pair(x + 1, y));
    		if (x - 1 >= 0 && y > 0 && x - 1 < m && y < n && grid[x - 1][y] == 'O')
    			pairs.offer(new Pair(x - 1, y));
    		if (x >= 0 && y + 1 > 0 && x < m && y + 1 < n && grid[x][y + 1] == 'O')
    			pairs.offer(new Pair(x, y + 1));
    		if (x >= 0 && y - 1 > 0 && x < m && y - 1 < n && grid[x][y - 1] == 'O')
    			pairs.offer(new Pair(x, y - 1));
    	}
    }
    public static void main(String[] args) {
    	new Solution().solve(new char[][]{{'O', 'O'}, {'O', 'O'}});
		new Solution().solve(new char[][]{{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}});
	}
}
