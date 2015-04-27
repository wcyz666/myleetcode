public class Solution {
    
    private static int m = 0;
    private static int n = 0;
    private static String Word = "";
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0)
            return word.length() == 0? true : false;
        n = board[0].length;
        Word = word;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                if (_exist(board, i, j, 0))
                    return true;
        return false;
    }
    
    private boolean _exist(char[][] board, int mPos, int nPos, int charPos) {
        if (mPos < 0 || mPos >= m || nPos < 0 || nPos >= n || board[mPos][nPos] != Word.charAt(charPos))
            return false;
        if (charPos == Word.length() - 1)
            return true;
        board[mPos][nPos] += 256;
        boolean match = _exist(board, mPos + 1, nPos, charPos + 1) || _exist(board, mPos, nPos + 1, charPos + 1) || _exist(board, mPos - 1, nPos, charPos + 1) || _exist(board, mPos, nPos - 1, charPos + 1);
        board[mPos][nPos] -= 256;
        return match;
    }
}