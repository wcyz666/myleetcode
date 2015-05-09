public class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0) return 1;
        
        long power = Math.abs(n);
        double result = 1.0;
        
        while (power > 0) {
            if ((power & 1) == 1)
                result *= x;
            x *= x;
            power >>= 1;
        }
        
        if (n < 0) { 
             return 1 / result;
        }
        
        return result;
    }
}