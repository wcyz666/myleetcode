public class Solution {
	public boolean search(int[] A, int target) {
		int left = 0, right = A.length - 1;
        while (left <= right){
        	int mid = (left + right) / 2;
        	if (A[mid] == target)
        		return true;
        	else if (A[mid] < target){
        		if (A[right] >= A[mid] && A[right] >= target)
        			return binarySearch(A, mid + 1, right, target) == -1 ? false : true;
        		else if (A[mid] >= A[left])
        			left++;
        		else
        			right--;	
        	}
        	else if (A[mid] > target){
        		if (A[left] <= target && A[mid] >= A[left])
        			return binarySearch(A, left, mid - 1, target) == -1 ? false : true;
        		else if (A[mid] <= A[right])
        			right--;
        		else{
        			left++;
        		}		
        	}        	
        }
        return false;
    }
	
    private int binarySearch(int[] A, int left, int right, int key){
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (A[mid] < key)
            return binarySearch(A, mid + 1, right, key);
        else if (A[mid] > key)
            return binarySearch(A, left, mid - 1, key);
        else
            return mid;
    }
}