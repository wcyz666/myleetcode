import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	if (num.length < 4){
    		return lists;
    	}
    	
    	quickSort(num, 0, num.length - 1);

    	for (int i = 0; i < num.length - 3; i++){
    	    if (num[i] > target && num[i+1] >=0) break;
    	    for (int k = i + 1; k < num.length - 2; k++){
    	        if (num[i] + num[k] > target && num[k+1] >=0) break;
    	        int front = k + 1;
    	        int back = num.length - 1;
    	        while(front < back) {

                    int two_sum = num[front] + num[back];

                    if (two_sum < target - num[i] - num[k]) front++;

                    else if (two_sum > target - num[i] - num[k]) back--;

                    else {

        				List<Integer> list = new ArrayList<Integer>();
        				list.add(num[i]);
        				list.add(num[k]);
        				list.add(num[front]);
        				list.add(num[back]);
        				lists.add(list);

                        // Processing the duplicates of number 3
                        while (front < back && num[front] == list.get(2)) ++front;

                        // Processing the duplicates of number 4
                        while (front < back && num[back] == list.get(3)) --back;

                    }
                }
        		while (k < num.length - 2 && num[k] == num[k + 1]) k++;
    	    }
    	    while (i < num.length - 3 && num[i] == num[i + 1]) i++;
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
}