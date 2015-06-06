public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return _findKthLargest(nums, 0, nums.length - 1, k);
    }
    
    public int _findKthLargest(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pos = partition(nums, left, right);
        int diff = pos - left + 1;
        if (k == diff){
            return nums[pos];
        }
        else if (k < diff)
            return _findKthLargest(nums, left, pos - 1, k);
        else
            return _findKthLargest(nums, pos + 1, right, k - diff);
    }
    
    
    private void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	private int partition(int[] num, int left, int right){
		int x = num[right];
		int i = left - 1;
		for (int j = left; j < right; j++){
			if (num[j] >= x){ 
				i++;
				swap(num, i, j);
			}
		}
		swap(num, i + 1, right);
		return i + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution()._findKthLargest(new int[]{2, 1, 3}, 0, 2, 3));
	}
}