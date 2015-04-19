public class Solution {
	
/*	Two binarySearches 
 * 
 *  
 * 
 * 
 * int i = 0, j = n - 1;
	    vector<int> ret(2, -1);
	    // Search for the left one
	    while (i < j)
	    {
	        int mid = (i + j) /2;
	        if (A[mid] < target) i = mid + 1;
	        else j = mid;
	    }
	    if (A[i]!=target) return ret;
	    else ret[0] = i;

	    // Search for the right one
	    j = n-1;  // We don't have to set i to 0 the second time.
	    while (i < j)
	    {
	        int mid = (i + j) /2 + 1;   // Make mid biased to the right
	        if (A[mid] > target) j = mid - 1;  
	        else i = mid;               // So that this won't make the search range stuck.
	    }
	    ret[1] = j;
	    return ret; */
	
    public int[] searchRange(int[] A, int target) {
        int left = binarySearch(A, 0, A.length-1, target);
        int right = left;
        if (left == -1)
            return new int[]{-1, -1};
        while (true){
            int nextLeft = binarySearch(A, 0, left-1, target);
            if (nextLeft == -1)
                break;
            else
                left = nextLeft;
        }
        while (true){
            int nextRight = binarySearch(A, right+1, A.length-1, target);
            if (nextRight == -1)
                break;
            else
                right = nextRight;
        }
        return new int[]{left, right};
    }
    
    private int binarySearch(int[] array, int left, int right, int target){
        if (left > right)
            return -1;
        int mid = (left + right) >> 1;
        if (target < array[mid])
            return binarySearch(array, left, mid-1, target);
        else if (target > array[mid])
            return binarySearch(array, mid+1, right, target);
        else
            return mid;
    }
}