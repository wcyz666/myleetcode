public class Solution {
	int findInsertPosition(int array[], int left, int right, int key){
	    if (left == right){
	        if (key <= array[left])
	            return left;
	        else
	            return left + 1;
	    }
	    int mid = (left + right) / 2;
	    if (array[mid] == key)
	        return mid;
	    else
	        if (array[mid] > key)
	            return findInsertPosition(array, left, mid, key);
	        else
	            return findInsertPosition(array, mid + 1, right, key);
	}
    public double findMedianSortedArrays(int A[], int B[]) {
    	if (A.length == 0)
    		return calArrayMid(B, 0, B.length - 1);
    	if (B.length == 0)
    		return calArrayMid(A, 0, A.length - 1);
        return _findMedianSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1);
    }
    
    
    private double _findMedianSortedArrays(int[] a, int aLeft, int aRight, int[] b,
			int bLeft, int bRight) {
		// TODO Auto-generated method stub
    	
    	if (aLeft == aRight){
    		if (bLeft == bRight)
    			return (a[aLeft] + b[bLeft]) / 2.0;
    		else {
				return calMedianByInsert(b, bLeft, bRight, a[aLeft]);
			}
    	}
    	if (bLeft == bRight)
    		return calMedianByInsert(a, aLeft, aRight, b[bLeft]);
    	
    	int lena = (aRight - aLeft + 1) / 2;
    	int lenb = (bRight - bLeft + 1) / 2;
    	int lenDelete = lena > lenb ? lenb : lena;
    	double mida = calArrayMid(a, aLeft, aRight);
    	double midb = calArrayMid(b, bLeft, bRight);
    	if (mida == midb) 
    		return mida;
    	else 
    		if (mida < midb)
    			return _findMedianSortedArrays(a, aLeft + lenDelete, aRight, b, bLeft, bRight - lenDelete);
    		else 
    			return _findMedianSortedArrays(a, aLeft, aRight - lenDelete, b, bLeft + lenDelete, bRight);
	}
    private double calArrayMid(int[] array, int left, int right) {
    	int mid = (right - left + 1) / 2 + left;
    	if (right - left == 1)
    		return (array[left] + array[right]) / 2.0;
		if ((right - left + 1) % 2 == 0)
			return (array[mid] + array[mid - 1]) / 2.0;
		else
			return array[mid];
	}
    
	private double calMedianByInsert(int[] array, int left, int right, int key) {
		// TODO Auto-generated method stub
		int pos = findInsertPosition(array, left, right, key);
		
		if ((right - left + 2) % 2 != 0){
			int origPos = (right - left + 2) / 2 + left;
			if (pos == origPos)
				return key;
			else
				if (pos < origPos)
					return array[origPos - 1];
				else
					return array[origPos];
		}
		else {
			int origPos = (right - left + 2) / 2 + left - 1;
			if (pos < origPos)
				return (array[origPos - 1] + array[origPos]) / 2.0;
			else 
				if (pos == origPos || pos  == origPos + 1)
					return (array[origPos] + key) / 2.0;
				else 
					return (array[origPos + 1] + array[origPos]) / 2.0;
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().findMedianSortedArrays(
				new int[]{3} , new int[] {1,2,4}));
	}
}