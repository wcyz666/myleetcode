public class Solution {
    public int maxProduct(int[] nums) {
        int max, maxAbs, cur, curAbs;
        int i = 0;
        while (i < nums.length - 1 && nums[i] == 0) i++;    
        max = maxAbs = cur = curAbs = nums[i];
        for (i++; i < nums.length; i++){
            if (nums[i] > 0) {
                cur *= nums[i];
                curAbs *= nums[i];
            }
            else if (nums[i] < 0)
                curAbs *= nums[i];
            else{
                while (i < nums.length - 1 && nums[i] == 0) i++;
                curAbs = cur = nums[i];
                max = Math.max(max, 0);
                maxAbs = Math.max(maxAbs, 0);
            }
            if (cur > max || curAbs > max)
                max = Math.max(cur, curAbs);
            if (Math.abs(curAbs) > Math.abs(maxAbs))
                maxAbs = curAbs;
        }
        return Math.max(max, maxAbs);
    }
    
    public static void main(String[] args) {
		new Solution().maxProduct(new int[]{3,-1,4});
	}
}