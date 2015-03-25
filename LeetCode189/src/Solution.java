import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        int realK = k % nums.length;
        reverse(nums, 0, nums.length - realK - 1);
        reverse(nums, nums.length - realK, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
    
    public void reverse(int[] array, int begin, int end) {
		int i = begin, j = end;
		while (j > i){
			swap(array, i, j);
			j--;i++;
		}
	}
    
    public static void main(String[] args) {
    	int array[] = new int[]{1,2,3,4,5,6,7};
		new Solution().rotate(array, 3);
		System.out.println(Arrays.toString(array));
	}
}