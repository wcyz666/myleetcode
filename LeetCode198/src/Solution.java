public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
        return result[result.length - 1];
    }
}
/*
 * int rob(int num[], int n) {
    int a = 0;
    int b = 0;

    for (int i=0; i<n; i++)
    {
        if (i%2==0)
        {
            a = max(a+num[i], b);
        }
        else
        {
            b = max(a, b+num[i]);
        }
    }

    return max(a, b);
}
 */
