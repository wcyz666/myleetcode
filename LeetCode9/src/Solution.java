public class Solution {
	
/* A better Solution, only compare a half of input number
 * 
 * public boolean isPalindrome(int x) {
	    if (x<0 || (x!=0 && x%10==0)) return false;
	    int rev = 0;
	    while (x>rev){
	        rev = rev*10 + x%10;
	        x = x/10;
	    }
	    return (x==rev || x==rev/10);
	}*/
	
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