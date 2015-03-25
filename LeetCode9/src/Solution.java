public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0)
    		return false;
        StringBuilder stringBuilder = new StringBuilder(x + "");
        if (stringBuilder.reverse().toString().equals(x+""))
        	return true;
        else
        	return false;
    }
}