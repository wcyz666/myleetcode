

public class Solution {
    public String longestPalindrome(String s) {
    	if (s.length() <= 2)
    		return s;
    	
    	String s1 = new StringBuilder(s).reverse().toString();
    	if (s.equals(s1))
    		return s;
    	int length = s.length();
    	int[][] b = new int[length][length];
    	int subLength = Integer.MIN_VALUE;
    	
    	for (int i = 1; i < length; i++){
    		for (int j = 1; j < length; j++){
    			if (s1.charAt(i) == s.charAt(j)){
    				b[i][j] = b[i-1][j-1] + 1;
    				if (b[i][j] > subLength)
    					subLength = b[i][j];
    			}    				
    			else
    				b[i][j] = 0;
    		}
    	}
    	for (int i = length - 1; i >= subLength - 1; i--)
    		for (int j = length - 1; j >= subLength - 1; j--)
    			if (b[i][j] == subLength){
    				StringBuilder sBuilder = new StringBuilder();
    				while (subLength > 0){
    					sBuilder.append(s.charAt(j--));
    					subLength--;
    				}
    				return sBuilder.toString();
    			}
    				
    	return null;
    	
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("characteristic"));
	}
}