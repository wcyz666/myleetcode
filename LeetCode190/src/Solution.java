public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	long sum = 0;
        long nn = n & 0xffffffffL;
        int digit = 0;
        while (nn > 0)
        {
        	if ((nn & 1) == 1)
        		sum += (1 << (31 - digit));
            nn = nn >> 1;
            digit++;
        }
        return (int)sum;
    }
    
    public static void main(String[] args) {
		new Solution().reverseBits(43261596);
	}
}