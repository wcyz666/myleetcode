public class Solution {
    public int findPeakElement(int[] A) {
        
        int left = 0, right = A.length - 1;
        while (left < right - 1){
        	int mid = (left + right) >> 1;
        	if (A[mid - 1] < A[mid] && A[mid + 1] < A[mid])
        		return mid;
        	else if (A[mid + 1] > A[mid])
        		left = mid + 1;
        	else
        	    right = mid - 1;
        }
        
        if (A[left] > A[right])
            return left;        
        return right;
    }
}