import java.util.HashSet;

public class Solution {
	
	
/*	void setZeroes(vector<vector<int> > &matrix) {
	    int col0 = 1, rows = matrix.size(), cols = matrix[0].size();

	    for (int i = 0; i < rows; i++) {
	        if (matrix[i][0] == 0) col0 = 0;
	        for (int j = 1; j < cols; j++)
	            if (matrix[i][j] == 0)
	                matrix[i][0] = matrix[0][j] = 0;
	    }

	    for (int i = rows - 1; i >= 0; i--) {
	        for (int j = cols - 1; j >= 1; j--)
	            if (matrix[i][0] == 0 || matrix[0][j] == 0)
	                matrix[i][j] = 0;
	        if (col0 == 0) matrix[i][0] = 0;
	    }
	}*/
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return;
        int cols = matrix[0].length;
        if (cols == 0) return;
        HashSet<Integer> colSet = new HashSet<>();
        HashSet<Integer> rowSet = new HashSet<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    colSet.add(j);
                    rowSet.add(i);
                }
            }
        }
        
        for (Integer row : rowSet) {
            int _row = row;
            for (int i = 0; i < cols; i++)
                matrix[_row][i] = 0;
        }
        
        for (Integer col : colSet) {
            int _col = col;
            for (int i = 0; i < rows; i++)
                matrix[i][_col] = 0;
        }
        
    }
}