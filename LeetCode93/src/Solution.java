import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
	
    public List<String> restoreIpAddresses(String s) {
    	Set<String> strings = new HashSet<>();
    	
    	if (s.length() > 12 || s.length() < 4)
    		return new ArrayList<>(strings);
    	
    	List<List<Integer>> lists = new ArrayList<>();
    	getAll(s.length(), lists, new int[4], 0);
    	for (List<Integer> list : lists){
    		int index = 0;
    		StringBuilder sBuilder = new StringBuilder();
    		for (Integer integer : list){
    			
    			int num = Integer.parseInt(s.substring(index, index + integer), 10);
    			if (num < 0 || num > 255){
    				break;
    			}
    			index += integer;
    			sBuilder.append(num + ".");
    		}
    		if (index == s.length()){
    			sBuilder.deleteCharAt(sBuilder.length() - 1);
    			strings.add(sBuilder.toString());
    		}
    		
    	}
    	
		return new ArrayList<>(strings);
    }
	
	
	private void getAll(int target, List<List<Integer>> lists, int[] array, int pos){
		if (pos == 3){
			List<Integer> list = new ArrayList<>();
			list.add(array[0]);
			list.add(array[1]);
			list.add(array[2]);
			list.add(target);
			lists.add(list);
			return;
		}
		for (int i = 1; i <= 3; i++){
			if ((target - i <= 9 - pos * 3) && (target - i >= 3 - pos)){
				array[pos] = i;
				getAll(target - i, lists, array, pos + 1);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().restoreIpAddresses("25525511135"));
	}
}
