public class Solution {
    public int searchInsert(int[] A, int target) {
        return binarySearch(A, 0, A.length-1, target);
    }
    
    private int binarySearch(int[] num, int left, int right, int key) {
		if (left > right)
			return left;

		int mid = (left + right) / 2;

		if (num[mid] > key) {
			return binarySearch(num, left, mid - 1, key);
		} else if (num[mid] < key) {
			return binarySearch(num, mid + 1, right, key);
		} else
			return mid;
	}
}