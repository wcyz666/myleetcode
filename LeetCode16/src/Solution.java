import java.util.Random;
public class Solution {
	public int threeSumClosest(int[] num, int target) {
	
		quickSort(num, 0, num.length - 1);	

		int closestSum = Integer.MAX_VALUE;

		for (int i = 0; i < num.length - 2; i++) {
		 
			for (int j = i + 1; j < num.length - 1; j++) {
				

				int localCloest = binarySearchClosest(num, j + 1,
						num.length - 1, target - num[i] - num[j]);
				if (num[i] + num[j] + localCloest == target)
					return target;
				if (Math.abs(closestSum) > Math.abs(target - num[i] - num[j] - localCloest))
					closestSum = num[i] + num[j] + localCloest - target;
			}
			if (target <= 0 && num[i] > 0) break;
		}

		return closestSum + target;
	}

	private int binarySearchClosest(int[] num, int left, int right, int key) {
		if (left >= right)
			return num[right];
		if (right - left == 1)
			return (Math.abs(key - num[left]) < Math.abs(key - num[right]))? num[left] : num[right];
		int mid = (left + right) / 2;

		if (num[mid] > key) {
			return binarySearchClosest(num, left, mid, key);
		} else if (num[mid] < key) {
			return binarySearchClosest(num, mid, right, key);
		} else
			return num[mid];
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static final Random RANDOM = new Random();

	public static int getRandom(int min, int max) {
		return RANDOM.nextInt(max - min) + min;
	}

	private int partition(int[] num, int left, int right) {
		swap(num, right, getRandom(left, right));
		int x = num[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (num[j] <= x) {
				i++;
				swap(num, i, j);
			}
		}
		swap(num, i + 1, right);
		return i + 1;
	}

	private void quickSort(int[] num, int left, int right) {
		if (left < right) {
			int q = partition(num, left, right);
			quickSort(num, left, q - 1);
			quickSort(num, q + 1, right);
		}
	}


}