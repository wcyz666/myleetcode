public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length < 1) return 1;
        int i = 0, length = nums.length;
        while (i < length) {
            if (nums[i] <= 0 || nums[i] == i || nums[i] >= length)
                i++;
            else {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        for (i = 1; i < length; i++)
            if (nums[i] != i)
                break;
        return i;
    }
    public static void main(String[] args) {
		new Solution().firstMissingPositive(new int[]{1,0});
	}
} 