public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] matrix = new int [word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++)
            matrix[0][i] = i;
        for (int j = 0; j <= word1.length(); j++)
            matrix[j][0] = j;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int flag = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])) + flag;
            }
        }
        return matrix[word1.length()][word2.length()];
    }
    public static void main(String[] args) {
		new Solution().minDistance("a", "ab");
	}
}