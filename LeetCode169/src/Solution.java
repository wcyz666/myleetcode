public class Solution {
/*	
 * An O(N) algorithm using bit algorithm
 * 
	public int majorityElement(int[] num) {

	    int ret = 0;

	    for (int i = 0; i < 32; i++) {

	        int ones = 0, zeros = 0;

	        for (int j = 0; j < num.length; j++) {
	            if ((num[j] & (1 << i)) != 0) {
	                ++ones;
	            }
	            else
	                ++zeros;
	        }

	        if (ones > zeros)
	            ret |= (1 << i);
	    }

	    return ret;
	}*/
	
    public int majorityElement(int[] num) {
        int curItem = 0;
        int counter = 0;
        for (int each : num){
            if (counter == 0){
                curItem = each;
                counter = 1;
            }
            else if (each == curItem)
                counter++;
            else if (each != curItem)
                counter--;
        }
        return curItem;
    }
}