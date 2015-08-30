/*
 * class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i >=0 && j>=0)
        {
            if(A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        while(j>=0)
            A[k--] = B[j--];
    }
};
 */

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = nums1.clone();
        int i, j, k;
        i = j = k = 0;
        while (i < m && j < n) {
            if (tmp[i] <= nums2[j]) {
                nums1[k] = tmp[i];
                i++;
            }
            else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            nums1[k] = tmp[i];
            i++;
            k++;
        }
        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}