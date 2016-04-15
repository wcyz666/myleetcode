import java.math.*;

public class Solution {
    public boolean _isAdditive(String num, int start, BigInteger prevNum, int level) {
        
        if (start == num.length()) {
            return true;
        }
        if (num.charAt(start) == '0') {
            return false;
        }
        
        for (int i = start + 1; i <= num.length(); i++) {
            BigInteger thisNum = new BigInteger(num.substring(start, i));
            String sum = thisNum.add(prevNum).toString();
            if (level < 3) {
            	if (_isAdditive(num, start + sum.length(), thisNum, level + 1)) {
                    return true;
                }
            } else if (num.startsWith(sum) && _isAdditive(num, start + sum.length(), thisNum, level + 1)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;
        return _isAdditive(num, 0, new BigInteger("0"), 1);
    }
    
    public static void main(String[] args) {
		new Solution().isAdditiveNumber("111");
	}
}