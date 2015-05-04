public class Solution {
    public void sortColors(int[] A) {
        for (int i = 0, start = -1, last = A.length; i < last; i++){
            if (A[i] == 0) {
                ++start;
                int tmp = A[start];
                A[start] = A[i];
                A[i] = tmp;
            }
            else if (A[i] == 2) {
                --last;
                int tmp = A[last];
                A[last] = A[i];
                A[i] = tmp;
            }
        }   
    }
    public static void main(String[] args) {
		new Solution().sortColors(new int[1,2,0]{);
	}
}