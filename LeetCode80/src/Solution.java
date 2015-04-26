public class Solution {
    public int removeDuplicates(int[] A) {

        int j = 0;
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1 && A[i] == A[i + 1])
                flag = true;
            else{
                A[j++] = A[i];
                if (flag){
                    flag = false;
                    A[j++] = A[i];
                }
            }
        }

        return j;
    }
}