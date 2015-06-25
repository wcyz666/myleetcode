public class Solution {
   public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int sign = ((dividend >> 31) ^ (divisor >> 31)) & 1;
        long dividendLong = Math.abs(dividend == Integer.MIN_VALUE ? (long)Integer.MIN_VALUE : dividend),
             divisorLong = Math.abs(divisor == Integer.MIN_VALUE ? (long)Integer.MIN_VALUE : divisor);
        
        if (dividendLong < divisorLong) return 0;
        long result = 0;
        
        while (dividendLong >= divisorLong) {
            long diff = 1;
            long tmp = divisorLong;
            do  {
                diff <<= 1;
                tmp <<= 1;
            } while (dividendLong > tmp);
            diff >>= 1;
            tmp >>= 1;
            result += diff;
            dividendLong -= tmp;
        }
        
        return (int)((sign == 0) ? result : -result);
        
    }
}