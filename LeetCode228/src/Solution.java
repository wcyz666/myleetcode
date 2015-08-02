import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[i] == j - i)
                j++;
            if (j == nums.length) j--;
            if (nums[j] - nums[i] != j - i) j--;
            if (j > i)
                list.add(nums[i] + "->" + nums[j]);
            else
                list.add(nums[i] + "");
            i = j;
        }
        return list;
    }
}