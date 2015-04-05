public class Solution {
	
/*    
 * O(N) + O(lgN) algorithm, not optimized
 * 
 * public int search(int[] A, int target) {
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
    
    public static void main(String[] args) {
		new Solution().search(new int[]{3, 1},  1);
	}
    
    
}