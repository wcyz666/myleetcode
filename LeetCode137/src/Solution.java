import java.util.HashSet;
import java.util.Set;

public class Solution {
	
/*	public int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}*/
    public int singleNumber(int[] A) {
        int sum = 0, zeros = 0, noDupSum = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int num : A) {
            if (num == 0)
                ++zeros;
            sum += num;
            set.add(num);
        }
        if (zeros == 1) return 0;
        for (Integer num : set)
            noDupSum += num;
        for (int num : A)
            if ((sum - num) == (noDupSum - num) * 3)
                return num;
        return 0;
    }
}