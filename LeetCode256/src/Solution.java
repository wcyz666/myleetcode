public class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        findCombo( k, n, 1, new LinkedList<Integer>() );
        return res;
    }
    public void findCombo(int k, int n, int start, List<Integer> list){
        if( k == 1 ){
            if( n < start || n > 9 ) return;
            list.add( n );
            res.add( list );
            return;
        }
        for( int i = start; i <= n / k && i < 10; i++ ){
            List<Integer> subList = new LinkedList<Integer>( list );
            sub.add( i );
            findCombo( k - 1, n - i, i + 1, subList );
        }
    }
}
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]