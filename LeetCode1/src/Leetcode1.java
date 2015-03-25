import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Leetcode1 {
	
	/*public void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public final Random RANDOM_INT = new Random();
	private int getRondomIndex(int left, int right) {
		return RANDOM_INT.nextInt(right - left) + left;
	}
	public int partition(int left, int right, int array[]){
		if (left == right){
			return left;
		}
		//randomized quicksort
		swap(right, getRondomIndex(left, right), array);
		int i = left;
		int j = right - 1;
		int partitioner = array[right];
		//i = j must be executed
		while (i <= j){
			//check boundary first
			while (i <= right - 1 && array[i] <= partitioner)
				i++;
			while (j >= 0 && array[j] >= partitioner)
				j--;
			if (i < j)
				swap(i, j, array);
		}
		if (i < right)
			swap(right, i, array);
		return i < right - 1 ? i : right - 1;
	}
	
	public void quickSort(int left, int right, int[] array){
		if (right <= left){
			return;
		}
		//first partition, then quick sort
		int q = partition(left, right, array);
		quickSort(left, q, array);
		quickSort(q + 1, right, array);
	}
	
    public int[] twoSum(int[] numbers, int target) {
		//index Map
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int numCount = numbers.length;
        int[] result = new int[2];
		//hash value and indices
		for (int i = 0; i < numbers.length; i++){
			if (indexMap.get(numbers[i]) == null)
				indexMap.put(numbers[i], new ArrayList<Integer>());
			indexMap.get(numbers[i]).add(i);
		}
		for (List<Integer> list : indexMap.values()){
			if (list.size() > 1){
				//Duplicate value: 
				//1. 2 * value = target
				//2. [exactly one answer] -> no possibility to be answer
				if (numbers[list.get(0)] * 2 != target){
					for (Integer integer : list){
						//Set these integers to be null
						numbers[integer] = Integer.MAX_VALUE;
					}
					numCount -= list.size(); 
				}
				else return new int[]{list.get(0) + 1, list.get(1) + 1};
			}
		}
		
		quickSort(0, numbers.length - 1, numbers);
		int boundary = getBounder(numCount, target, numbers);
		for (int i = 0; i < boundary; i++){
			int temp = binary_search(i, numCount - 1, target - numbers[i], numbers);
			if (temp != -1){
				int int1 = indexMap.get(numbers[i]).get(0) + 1;
				int int2 = indexMap.get(numbers[temp]).get(0) + 1;
				if (int1 > int2)
					return new int[] {int2, int1};
				else {
					return new int[] {int1, int2};
				}
			}
		}
		
		return null;
    }
    
    public int getBounder(int numCount, int target, int[] numbers){
    	int i;
		for (i = 0; i < numCount; i++){
			if (2 * numbers[i] > target)
				break;
		}
		return i;
    }
    
    public int binary_search(int left, int right, int key, int[] numbers){
    	int mid = (left + right) / 2;
    	if (right < left)
    		return -1;
    	if (numbers[mid] == key)
    		return mid;
    	if (numbers[mid] > key)
    		return binary_search(left, mid - 1, key, numbers);
    	else {
			return binary_search(mid + 1, right, key, numbers);
		}
    }*/
    
    public int[] twoSum(int[] numbers, int target) {
		//index Map
        Map<Integer, Short> indexMap = new HashMap<>();
        int x;
		//hash value and indices
		for (short i = 0; i < numbers.length; i++){
		    x = numbers[i];
			if (indexMap.get(x) == null)
				indexMap.put(x, i);
			else {
				if (target == x * 2){
					return new int[] {indexMap.get(x) + 1, i + 1};
				}
			}
		}

		for (short i = 0; i < numbers.length; i++){
		    x = numbers[i];
			if (target != x * 2 && indexMap.get(target - x) != null){
				int int1 = indexMap.get(x) + 1;
				int int2 = indexMap.get(target - x) + 1;
				if (int1 > int2)
					return new int[] {int2, int1};
				else {
					return new int[] {int1, int2};
				}
			}
		}
		
		return null;
    }
    
    
    public static void main(String[] args) {
		int[] result = new Leetcode1().twoSum(new int[] {0,3,4,0}, 0);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}