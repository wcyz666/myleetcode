public class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int startRow = 0, startCol = 0, endRow = n, endCol = n;
        int count = 0, all = n * n;
        
        while (true){
            if (count == all)
                return matrix;
            for (int i = startCol; i < endCol; i++){
                matrix[startRow][i] = ++count;
            }
            if (count == all)
                return matrix;
            startRow++;
            for (int i = startRow; i < endRow; i++){
                matrix[i][endCol - 1] = ++count;                
            }
            if (count == all)
                return matrix;
            endCol--;
            for (int i = endCol - 1; i >= startCol; i--){
                matrix[endRow - 1][i] = ++count;
            }
            endRow--;
            for (int i = endRow - 1; i >= startRow; i--){
                matrix[i][startCol] = ++count;
            }
            startCol++;
        }
    }
}