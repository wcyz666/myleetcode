public class Solution {
	
/*    void sortColors(int A[], int n) {
        int second=n-1, zero=0;
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second) swap(A[i], A[second--]);
            while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
        }
    }*/
    public void sortColors(int[] A) {
        int[] countArray = new int[] {0, 0, 0};
        for (int i = 0, last = A.length; i < last; i++){
            countArray[A[i]]++;
        }   
        int j = 0;
        for (int i = 0; i < countArray[0]; i++, j++)
            A[j] = 0;
        for (int i = 0; i < countArray[1]; i++, j++)
            A[j] = 1;   
        for (int i = 0; i < countArray[2]; i++, j++)
            A[j] = 2;
    }
}