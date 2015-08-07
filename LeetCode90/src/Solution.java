import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * One possible solution is to generate all possible subset using bit-mask, and use a set to test the existence of a subset. However, this method may generate duplicate subsets during the process, and has unsatisfiable time complexity. E.g. for input <1 1 1 1 1 1 1 1 1>, the above method will generate too many duplicate subsets.

I use a subset construction method, whose mechanism is illustrated with an example:

input: <1 2 2 3 3 3> (assumed to be sorted)

initialization: empty set <>. ret = {<>}

for element 1, add it to ret, and we get: <1>. ret = {<> <1>}

for element 2, add it to ret, and we get: <2> <1 2>; however, notice that we have two elements of 2, hence we further need to add <2 2> to {<> <1>}, and get <2 2> <1 2 2>. ret = {<> <1> <2> <1 2> <2 2> <1 2 2>}

for element 3, we newly construct the following:
<3> <1 3> <2 3> <1 2 3> < 2 2 3> < 1 2 2 3>
<3 3> <1 3 3> <2 3 3> <1 2 3 3> <2 2 3 3> <1 2 2 3 3>
<3 3 3> <1 3 3 3> < 2 3 3 3> <1 2 3 3 3> <2 2 3 3 3> <1 2 2 3 3 3>
finally, ret = {<> <1> <2> <1 2> <2 2> <1 2 2>
<3> <1 3> <2 3> <1 2 3> < 2 2 3> < 1 2 2 3>
<3 3> <1 3 3> <2 3 3> <1 2 3 3> <2 2 3 3> <1 2 2 3 3>
<3 3 3> <1 3 3 3> < 2 3 3 3> <1 2 3 3 3> <2 2 3 3 3> <1 2 2 3 3 3> }

class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        vector<vector<int> > ret;
        ret.push_back(vector<int>());
        sort(S.begin(), S.end());
        for (int i = 0; i < S.size(); ) {
            int j = i;
            while (j < S.size() && S[j] == S[i]) j++;
            int size = ret.size();
            for (int len = 1; i + len <= j; len++) {
                for (int cnt = 0; cnt < size; cnt++) {
                    vector<int> subset(ret[cnt]);
                    for (int k = 0; k < len; k++) subset.push_back(S[i]);
                    ret.push_back(subset);
                }
            }
            i = j;
        }
        return ret;
    }
};
 */

public class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums); 
        for (int i : nums) {
            Integer result = map.get(i);
            if (result == null)
                map.put(i, 1);
            else
                map.put(i, result + 1);
        }
        List<List<Integer>> lists = new LinkedList<>();
        int[] flag = new int[map.size()];
        
        removeDup(nums);
        
        addSubset(lists, 0, flag, nums);
        return lists;
    }
    
    public void removeDup(int[] A) {

        int i = 1, j = 0;

        for (; i < A.length; i++){
        	if (A[i] != A[j]) {
        		j++;
				if (i != j)
					A[j] = A[i];
			}
        	
        }
    }
    
    private void addSubset(List<List<Integer>> lists, int pos, int[] flag, int[] nums) {
        
        for (int i = 0, length = map.get(nums[pos]); i <= length; i++) {
            flag[pos] = i;
            if (pos + 1 != flag.length)
                addSubset(lists, pos + 1, flag, nums);
            else {
            	List<Integer> list = new LinkedList<>();
                for (int j = 0, len = flag.length; j < len; j++)
                    for (int k = 0; k < flag[j]; k++)
                        list.add(nums[j]);
                lists.add(list);
			}
             
        }
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().subsetsWithDup(new int[]{0}));
		System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2, 3}));
	}
}