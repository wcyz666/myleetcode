public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        long nn = n & 0xffffffffL;
        while (nn > 0)
        {
            sum += nn & 1;
            nn = nn >> 1;
        }
        return sum;
    }
    
    public static void main(String[] args) {
		new Solution().hammingWeight(-1);
	}
}