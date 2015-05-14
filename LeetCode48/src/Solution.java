public class Solution {
    public void rotate(int[][] a) {
        int n = a.length;
        
        for (int m = 0; m < n / 2; m++) {
            for (int i = m; i < n - m - 1; i++) {
                int tmp = a[m][i];
                a[m][i] = a[n - 1 - i][m];
                a[n - 1 - i][m] = a[n - m - 1][n - i - 1];
                a[n - m - 1][n - i - 1] = a[i][n - m - 1];
                a[i][n - m - 1] = tmp;
            }
        }
    }
}