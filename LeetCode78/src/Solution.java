import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        int allCount = 1 << nums.length;
        
        for (int i = 0; i < allCount; i++) {
            addSubset(lists, allCount, nums);
        }
        return lists;
    }
    
    private void addSubset(List<List<Integer>> lists, int allCount, int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            if ((allCount & 1) == 1)
                list.add(nums[i]);
            allCount >>= 1;
        }
        lists.add(list);
    }
    public static void main(String[] args) {
		new Solution().subsets(new int[]{0});
	}
}