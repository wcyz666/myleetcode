import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	
/*    
 * void permute(vector<int> &num, size_t start, vector<vector<int>> &result){
        if (start == num.size()-1){
            result.push_back(num);
        }
        else{
            for (size_t i = start; i < num.size(); i++){
                swap(num[start], num[i]);
                permute(num, start + 1, result);
                swap(num[start], num[i]);
            }
        }
    }
 * 
 * 
 * 
 * */

	
    
    private List<List<Integer>> lists;
    private Integer[] array;    
    public List<List<Integer>> permute(int[] nums) {
        lists = new LinkedList<>();
        array = new Integer[nums.length];
        getAllPermute(0, nums.length, nums);
        return lists;
        
    }
    
    private void getAllPermute(int current, int length, int[] nums) {
    	for (int i = 0; i < length; i++){
            boolean flag = true;
            array[current] = nums[i];
            
            for (int j = 0; j < current; j++) 
                if (array[i] == array[j]) {
                    flag = false;
                    break;
                }
            if (!flag) continue;
    		if (current == length - 1)
    			lists.add(new ArrayList<Integer>(Arrays.asList(array)));
    		else
    			getAllPermute(current + 1, length, nums);
    	}
    }
    public static void main(String[] args) {
		new Solution().permute(new int[]{0, 1});
	}
}