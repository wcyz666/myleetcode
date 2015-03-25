public class Solution {
    public int removeDuplicates(int[] A) {
    	if (A.length <= 1)
    		return A.length;

        int i = 1, j = 0;

        for (; i < A.length; i++){
        	if (A[i] != A[j]) {
        		j++;
				if (i != j)
					A[j] = A[i];
			}
        	
        }
        return j + 1;
    }
    
    public static void main(String[] args) {
    	int [] A = new int[]{0,0,0,0};
		System.out.println(new Solution().removeDuplicates(A));
		for (int i = 0; i < A.length; i++)
			System.out.println(A[i]);
	}
}