public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int m = matrix.length;
        if (m == 0)
            return list;
        int n = matrix[0].length;
        
        if (m == 1 || n == 1){
            for (int i = 0; i < n; i++)
                list.add(matrix[0][i]);
            for (int i = 1; i < m; i++)
                list.add(matrix[i][0]);
            return list;
        }
        
        int startRow = 0, startCol = 0, endRow = m, endCol = n;
        int count = 0, all = m * n;
        while (true){
            if (count == all)
                return list;
            for (int i = startCol; i < endCol; i++){
                list.add(matrix[startRow][i]);
                count++;
            }
            if (count == all)
                return list;
            startRow++;
            for (int i = startRow; i < endRow; i++){
                list.add(matrix[i][endCol - 1]);
                count++;                
            }
            if (count == all)
                return list;
            endCol--;
            for (int i = endCol - 1; i >= startCol; i--){
                list.add(matrix[endRow - 1][i]);
                count++;
            }
            if (count == all)
                return list;
            endRow--;
            for (int i = endRow - 1; i >= startRow; i--){
                list.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }
    }
}