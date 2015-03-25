

public class Solution {
    public int atoi(String str) {
    	if (str == null || str.length() == 0)
    		return 0;
    	int result = 1, i = 0, tmp, flag, sign = 0;
    	int len = str.length();
    	for (; i < len && !Character.isDigit(str.charAt(i)) && str.charAt(i) != '0'; i++){
    	    if (str.charAt(i) == '+') 
    		    ++sign;
    	    else
	    		if (str.charAt(i) == '-'){
	    			result = -1;
	    			++sign;
	    		}
	    		else
					if (str.charAt(i) == ' ')
						continue;
					else {
						return 0;
					}
    	    if (sign > 0){
    	    	if (i + 1 == len)
    	    		return 0;
    	    	if (!Character.isDigit(str.charAt(i + 1)))
    	    		return 0;
    	    }
    	}

    	flag = result;
    	result = result * (str.charAt(i) - '0');

        	
    	for (i++; i < len && Character.isDigit(str.charAt(i)); i++){
    		tmp = result * 10 + (str.charAt(i) - '0') * flag;
    		if (result > 214748364 || (result > 0 && tmp < 0))
    			return Integer.MAX_VALUE;
    		if (result < -214748364 || (result < 0 && tmp > 0))
    			return Integer.MIN_VALUE;
    		result = tmp;
    	}
    	return result;
    	
    }
    public static void main(String[] args) {
		System.out.println(new Solution().atoi("    10522545459"));
	}

}