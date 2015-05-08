public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] a = new int[nums.length - 1], b = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            a[i] = nums[i + 1] - nums[i];
            b[i] = nums[i] - nums[i + 1];
        }
        return Math.max(maxSubSum(a), maxSubSum(b));
    }
    
    private int maxSubSum(int[] a) 
    { 
       int maxSum = 0, thisSum = 0; 
       for (int j = 0; j < a.length; j++) 
       { 
          thisSum += a[j]; 
          if (thisSum > maxSum) 
              maxSum = thisSum; 
          else if (thisSum < 0) 
              thisSum = 0; 
       } 
       return maxSum; 
    }
    
    public static void main(String[] args) {
		new Solution().maximumGap(new int[]{3,6,9,1});
	}
}