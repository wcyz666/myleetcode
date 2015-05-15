public class Solution {
	
/*	class Solution {
		public:
		    bool searchMatrix(vector<vector<int> > &matrix, int target) {
		        int n = matrix.size();
		        int m = matrix[0].size();
		        int l = 0, r = m * n - 1;
		        while (l != r){
		            int mid = (l + r - 1) >> 1;
		            if (matrix[mid / m][mid % m] < target)
		                l = mid + 1;
		            else 
		                r = mid;
		        }
		        return matrix[r / m][r % m] == target;
		    }
		};
	*/
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowPos = binarySearchInMatrix(matrix, 0, matrix.length - 1, target);
        if (rowPos < matrix.length && matrix[rowPos][0] == target)
            return true;
        if (rowPos == 0) 
            return false;
        return binarySearch(matrix[rowPos - 1], 0, matrix[0].length - 1, target);
    }
    
    
    private int binarySearchInMatrix(int[][] num, int left, int right, int key) {
		if (left > right)
			return left;

		int mid = (left + right) / 2;

		if (num[mid][0] > key) {
			return binarySearchInMatrix(num, left, mid - 1, key);
		} else if (num[mid][0] < key) {
			return binarySearchInMatrix(num, mid + 1, right, key);
		} else
			return mid;
	}
	
	private boolean binarySearch(int[] num, int left, int right, int key) {
		if (left > right)
			return false;

		int mid = (left + right) / 2;

		if (num[mid] > key) {
			return binarySearch(num, left, mid - 1, key);
		} else if (num[mid] < key) {
			return binarySearch(num, mid + 1, right, key);
		} else
			return true;
	}
}