public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        int product = nums[0];
        for (int i = 1; i < length; i++) {
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }
}