public class Solution {
    public int uniquePaths(int m, int n) {
        double result = 1;
        int max = Math.max(m, n);
        for (int i = max; i <= (m + n - 2); i++) {
            result *= i;
        }
        for (int i = 2; i <= m + n - max - 1; i++) {
            result /= i;
        }
        return (int)result;
    }
}