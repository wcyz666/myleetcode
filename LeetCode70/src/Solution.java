public class Solution {
    public int climbStairs(int n) {
        int result = 1;
        int tmp = 1;
        for (int i = 1; i < n; i++) {
            int preResult = result;
            result += tmp;
            tmp = preResult;
        }
        return result;
    }
}