

public class Solution {
	
	public int reverse(int x)
	{
/*	  
 * A better solution
 * 
 *   int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
	*/
	public static int reverse(int x) {
        StringBuilder string = new StringBuilder(x + "");
        int flag = 1;
        if (string.charAt(0) == '-'){
        	flag = -1;
        	string.reverse().deleteCharAt(string.length()-1);
        	
        }
        else {
        	string.reverse();
		}
        try{
        	return flag == 1 ? Integer.parseInt(string.toString()) : -1 *Integer.parseInt(string.toString());
        }
        catch (Exception e){
        	return 0;
        }
    }    
    
    public static void main(String[] args) {
    	System.out.println(reverse(1000000002));
	}
}