public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int range = nums[0];
        int i = 1;
        for (int length = nums.length; i < length && range != 0; i++) {
            range--;
            if (range < nums[i])
                range = nums[i];
            if (range > length - i)
                return true;
        }
        if (i == nums.length) 
            return true;
        return false;
    }
}