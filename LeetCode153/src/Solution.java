import java.util.List;

public class Solution {
	public int findMin(List<Integer> A) {
		int left = 0, right = A.size() - 1;
        while (left < right - 1){
        	int mid = (left + right) >> 1;
        	int minElement = A.get(mid);
        	int leftElement = A.get(left);
        	int rightElement = A.get(right);
        	if (A.get(mid - 1) > minElement && A.get(mid + 1) > minElement)
        		return minElement;
        	else if (minElement > leftElement){
        	    if (rightElement < leftElement)
        		    left = mid + 1;
        		else
        		    right = mid - 1;
        	}
        	else {
        	    if (rightElement < leftElement)
        		    right = mid - 1;  
        		else
        		    left = mid + 1;
        	}

        	
        }
        return Math.min(A.get(left), A.get(right));
    }
}