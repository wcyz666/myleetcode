public class Solution {
    public void nextPermutation(int[] num) {
        
    	int m = num.length - 1;
    	
        for (; m > 0; m--)
            if (num[m-1] < num[m]){
                break;
            }
        if (m == 0) {
        	reverse(num, 0, num.length-1);
        	return;
        }
        for (int i = num.length-1; i > m-1; i--)
            if (num[i] > num[m-1]){
            	swap(num, i, m-1);
            	break;
            }
        reverse(num, m, num.length-1);
      
    }
    
    private void reverse(int[] array, int begin, int end) {
		int i = begin, j = end;
		while (j > i){
			swap(array, i, j);
			j--;i++;
		}
	}    
    
    private void swap(int[] array, int a, int b){
        array[a] = array[a] ^ array[b];
        array[b] = array[a] ^ array[b];
        array[a] = array[a] ^ array[b];
    }
}