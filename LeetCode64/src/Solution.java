public class Solution {
    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	int[] solution = new int[n];
    	
    	solution[0] = grid[0][0];
    	for (int i = 1; i < n; i++){
    		solution[i] = grid[0][i] + solution[i-1];
    	}
    	for (int i = 1; i < m; i++){
    		solution[0] += grid[i][0];
    		for (int j = 1; j < n; j++){
    			solution[j] = Math.min(solution[j-1], solution[j]) + grid[i][j];
    		}
    	}
    	
        return solution[n-1];
    }
}