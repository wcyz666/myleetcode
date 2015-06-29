public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val)
                ++count;
            else {
                if (count > 0) {
                    nums[i - count] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        return length - count;
    }
}