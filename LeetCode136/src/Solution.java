import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] A) {
    	
    	
    	BitSet bitSetPositive = new BitSet();
    	BitSet bitSetNegative = new BitSet();
        for (int i = 0; i < A.length; i++)
        	if (A[i] >= 0)
        		bitSetPositive.flip(A[i]);
        	else 
        		bitSetNegative.flip(-A[i]);
        
        for (int i = 0; i < A.length; i++)
        	if (A[i] >= 0){
        		if (bitSetPositive.get(A[i]))
            		return A[i];
        	}
        	else{
        		if (bitSetNegative.get(A[i]))
            		return A[i];
        	}
        	
        return A[0];
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().singleNumber(new int[]{1,1,2,2,3,3,4,4,5,6,7,7,6}));
	}
}