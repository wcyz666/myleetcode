import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Solution {
	
    /* Too Slow....
     * Due to operations on Java Collection
     * 
     * public List<List<Integer>> threeSum(int[] num) {
    	
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	if (num.length == 0){
    		return lists;
    	}
    	   	
    	int border = partition(num);
    	HashSet<Integer> set = new HashSet<Integer>(); 
    	HashSet<Integer> set2 = new HashSet<Integer>();
    	int zeros = 0;
    	
    	for (int i = 0; i < border; i++){
    		if (0 == num[i]) ++zeros;
    		int positiveSum = 0 - num[i];
    		if (!set2.contains(positiveSum)){
    			twoSum(num, positiveSum, border, num.length, set, lists); 
    			set2.add(positiveSum);
    		}
    	}
    	for (int i = border; i < num.length; i++){
    		if (0 == num[i]) ++zeros;
    		int negativeSum = 0 - num[i];
    		if (!set2.contains(negativeSum)){
    			twoSum(num, negativeSum, 0, border, set, lists); 
    			set2.add(negativeSum);
    		}
    				
    	}
    	if (zeros >= 3){
        	List<Integer> list = new ArrayList<>();
        	list.add(0);
        	list.add(0);
        	list.add(0);
        	lists.add(list);
    	}
		return lists;
    }
    
	public void twoSum(int[] numbers, int target, int begin, int end, HashSet<Integer> set, List<List<Integer>> lists) {  
 
		set.clear();
        for (int i = begin; i < end; i++)  
        {  
            if (numbers[i] <= target - numbers[i] && set.contains(target - numbers[i])) {  
            	List<Integer> list = new ArrayList<>();
            	list.add(0 - target);
            	list.add(numbers[i]);
            	list.add(target - numbers[i]);
            	lists.add(list);
            }
            set.add(numbers[i]);
        }    
    }
    
    private int partition(int[] num){
    	int i = 0, j = num.length - 1;
    	while (true){
    		while (i <= num.length - 1 && num[i] < 0) i++;
    		while (j >= 0 && num[j] >= 0) j--;
    		if (i < j){
    			int temp = num[i];
    			num[i] = num[j];
    			num[j] = temp;
    		}
    		else break;
    		
    	}
    	return i == num.length? i - 1 : i;
    }*/
	
	public List<List<Integer>> threeSum(int[] num) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	if (num.length < 3){
    		return lists;
    	}
    	
    	quickSort(num, 0, num.length - 1);
    	int positiveStartAt = 0;
    	for (; positiveStartAt < num.length; positiveStartAt++){
    		if (num[positiveStartAt] >= 0)
    			break;
    	}
    	if (positiveStartAt == num.length){
    		return lists;
    	}
    	
    	for (int i = 0; i < num.length && num[i] <= 0; i++){
    		for (int j = i + 1; j < num.length - 1; j++){
    			if (num[i] + num[j] > 0) break;
    			
    			if (binarySearch(num, Math.max(positiveStartAt - 1, j) + 1, num.length - 1, 0 - num[i] - num[j]) != -1){
    				List<Integer> list = new ArrayList<Integer>();
    				list.add(num[i]);
    				list.add(num[j]);
    				list.add(0 - num[i] - num[j]);
    				lists.add(list);
    			}
    			while (j < num.length && num[j] == num[j + 1]){
    				j++;
    			}
    		}
    		while (i < num.length && num[i] == num[i + 1]){
    			i++;
    		}
    	}
    	
    	return lists;
	}
	
	private int binarySearch(int[] num, int left, int right, int key){
		if (left > right) return -1;
		int mid = (left + right) / 2;
		
		if (num[mid] > key){
			return binarySearch(num, left, mid - 1, key);
		}
		else if (num[mid] < key){
			return binarySearch(num, mid + 1, right, key);
		}
		else return mid;
	}
	
	private void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public static final Random RANDOM = new Random();
	public static int getRandom(int min, int max){
		return RANDOM.nextInt(max - min) + min; 
	}
	
	private int partition(int[] num, int left, int right){
		swap(num, right, getRandom(left, right));
		int x = num[right];
		int i = left - 1;
		for (int j = left; j < right; j++){
			if (num[j] <= x){ 
				i++;
				swap(num, i, j);
			}
		}
		swap(num, i + 1, right);
		return i + 1;
	}
	
	private void quickSort(int[] num, int left, int right){
		if (left < right){
			int q = partition(num, left, right);
			quickSort(num, left, q - 1);
			quickSort(num, q + 1, right);
		}
	}
    
    public static void main(String[] args) {
    	//int[] num = new int[]{13,-11,-14,4,-9,-10,-11,7,-14,-9,14,0,-5,-7,6,-9,11,6,-14,-12,-10,9,-8,-7,5,6,8,-12,-1,-4,14,-3,0,7,9,7,12,13,-9,13,11,-10,-10,-9,-10,12,-10,8,-5,13,11,-8,7,-12,0,-11,2,-14,-8,8,-3,13,-9,5,5,7,-11,-6,5,-13,-7,1,14,-10,-1,-11,-13,4,12,-11,2,0,-4,-14,4,4,-10,13,-3,-10,6,1,-12,4,-9,1,-4,-13,10,8,-11,10,-14,-12,-14,1,-8,10,-10,11,-15,0,-3,-12,1,-14,-1,-1,6,11,-4,-3,-2,-1,-13};
    	int[] num = new int[]{-1, 0, 1, 2, -1, -4};
    	System.out.println(new Solution().threeSum(num));
    	
	}
}