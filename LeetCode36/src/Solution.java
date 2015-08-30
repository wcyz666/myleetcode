public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            int bit1 = 0, bit2 = 0;
            for (int j = 0; j < 9; j++) {
                int elementH = board[i][j] - '0';
                int elementV = board[j][i] - '0';
                if (elementH >= 1 && elementH <= 9 && elementV >= 1 && elementV <= 9) {
                    if ((bit1 & (1 << elementH)) != 0 || (bit2 & (1 << elementV)) != 0) 
                        return false;
                    else {
                        bit1 |= 1 << elementH;
                        bit2 |= 1 << elementV;
                    }
                }
                else if (board[i][j] != '.' || board[j][i] != '.')
                    return false;
            }
        }
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int bit3 = 0;
                for (int iBlock = 3 * i; iBlock < 3 * i + 3; iBlock++)
                    for (int jBlock = 3 * j; jBlock < 3 * j + 3; jBlock++) {
                        if (board[iBlock][jBlock] == '.')
                            continue;
                        if ((bit3 & (1 << (board[iBlock][jBlock] - '0'))) != 0) 
                            return false;
                        else 
                            bit3 |= 1 << (board[iBlock][jBlock] - '0');
                    }
            }
        
        return true; 
    }
    
    public static void main(String[] args) {
		new Solution().isValidSudoku(new char[][]{"..5.....6".toCharArray(),"....14...".toCharArray(),".........".toCharArray(),".....92..".toCharArray(),"5....2...".toCharArray(),".......3.".toCharArray(),"...54....".toCharArray(),"3.....42.".toCharArray(),"...27.6..".toCharArray()});
	}
}