public class Solution {
	
	boolean isVisited[];

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    	int max = numCourses - 1;
    	if (prerequisites.length == 0)
    	    return true;

        boolean[][] matrix = new boolean[max + 1][max + 1];
        isVisited = new boolean[max + 1];		
        for (int i = 0; i < isVisited.length; i++)
            isVisited[i] = false;
        for (int i = 0; i <= max; i++)
        	for (int j = 0; j <= max; j++)
        		matrix[i][j] = false;
    	for (int i = 0; i < prerequisites.length; i++)
    		matrix[prerequisites[i][0]][prerequisites[i][1]] = true;
        for (int i = 0; i <= max; i++) {
        	if (checkCycle(i, matrix))
        		return false;
        }
        return true;
    }
    
    private boolean checkCycle(int i, boolean[][] matrix) {
		if (isVisited[i])
			return true;
    	isVisited[i] = true;
    	for (int j = 0; j < matrix.length; j++)
    		if (matrix[i][j] && checkCycle(j, matrix))
    			return true;
		isVisited[i] = false;
    	return false;
	}
    public static void main(String[] args) {
		System.out.println(new Solution().canFinish(2, new int[][]{{0, 1}}));
	}
}