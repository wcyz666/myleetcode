public class Solution {
	
/*    
 * O(N) + O(lgN) algorithm, not optimized
 * 
 * 	public int search(int[] A, int target) {
        int i = 0;
        for (; i < A.length - 1 && A[i] < A[i + 1]; i++)
            if (A[i] == target)
                return i;
        
        return binarySearch(A, i, A.length - 1, target);
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
    }*/
	
	public int search(int[] A, int target) {
		int left = 0, right = A.length - 1;
        while (left <= right){
        	int mid = (left + right) / 2;
        	if (A[mid] == target)
        		return mid;
        	else if (A[mid] < target){
        		if (A[right] >= A[mid] && A[right] >= target)
        			return binarySearch(A, mid + 1, right, target);
        		else if (A[mid] >= A[left])
        			left = mid + 1;
        		else
        			right = mid - 1;	
        	}
        	else if (A[mid] > target){
        		if (A[left] <= target && A[mid] >= A[left])
        			return binarySearch(A, left, mid - 1, target);
        		else if (A[mid] <= A[right])
        			right = mid - 1;
        		else{
        			left = mid + 1;
        		}		
        	}        	
        }
        return -1;
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
    
    public static void main(String[] args) {
		System.out.println(new Solution().search(new int[]{4,5,6,7,8,1,2,3}, 8));
	}
    
    
}