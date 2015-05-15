public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) return 0;
        int m = obstacleGrid[0].length;
        
        int[] result = new int[m];
        int pass = 1;
        
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1)
                pass = 0;
            result[i] = pass;
        }
        
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1)
                result[0] = 0;
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1)
                    result[j] = 0;
                else
                    result[j] += result[j - 1];
            }
        }
        return result[m - 1];
    }
}