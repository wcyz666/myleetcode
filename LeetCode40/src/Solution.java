import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 /*
  * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
  */
public class Solution {
	public List<List<Integer>> combinationSum2(int[] cand, int target) {
	    Arrays.sort(cand);
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    List<Integer> path = new ArrayList<Integer>();
	    dfs_com(cand, 0, target, path, res);
	    return res;
	}
	void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
	    if (target == 0) {
	        res.add(new ArrayList(path));
	        return ;
	    }
	    if (target < 0) return;
	    for (int i = cur; i < cand.length; i++){
	        if (i > cur && cand[i] == cand[i-1]) continue;
	        path.add(path.size(), cand[i]);
	        dfs_com(cand, i+1, target - cand[i], path, res);
	        path.remove(path.size()-1);
	    }
	}
}