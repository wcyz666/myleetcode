public class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        int result = 0;
        int length = nums.length;
        if (length == 1) return nums[0];

        for (int i=1; i < length; i++) {
            if (i%2==0) {
                a = Math.max(a+nums[i], b);
            }
            else {
                b = Math.max(a, b+nums[i]);
            }
        }
        result = Math.max(a, b);
        a = b = 0;
        for (int i = 0; i < length - 1; i++) {
            if (i%2==0) {
                a = Math.max(a+nums[i], b);
            }
            else {
                b = Math.max(a, b+nums[i]);
            }
        }

        return Math.max(result, Math.max(a, b));
    }
}