import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
    
    public static void main(String[] args) {
		System.out.println(new Solution().threeSum(new int[]{13,-11,-14,4,-9,-10,-11,7,-14,-9,14,0,-5,-7,6,-9,11,6,-14,-12,-10,9,-8,-7,5,6,8,-12,-1,-4,14,-3,0,7,9,7,12,13,-9,13,11,-10,-10,-9,-10,12,-10,8,-5,13,11,-8,7,-12,0,-11,2,-14,-8,8,-3,13,-9,5,5,7,-11,-6,5,-13,-7,1,14,-10,-1,-11,-13,4,12,-11,2,0,-4,-14,4,4,-10,13,-3,-10,6,1,-12,4,-9,1,-4,-13,10,8,-11,10,-14,-12,-14,1,-8,10,-10,11,-15,0,-3,-12,1,-14,-1,-1,6,11,-4,-3,-2,-1,-13}));
    	
	}
}