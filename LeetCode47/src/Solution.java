import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        permute(lists, nums, 0);
        return lists;
    }
    
    public void permute(List<List<Integer>> lists, int[] nums, int i) {
        if (i == nums.length - 1) {
            List<Integer> intList = new ArrayList<Integer>();
            for (int num : nums) {
                intList.add(num);
            }
            lists.add(intList);
            return;
        }
        for (int k = i; k < nums.length; k++) {
            if (k != i && nums[i] == nums[k])
                continue;
            swap(nums, i, k);
            permute(lists, Arrays.copyOf(nums, nums.length), i + 1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}