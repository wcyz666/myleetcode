import java.util.Set;


public class Solution {
    /*public boolean wordBreak(String s, Set<String> wordDict) {

        Queue<Integer> queue = new LinkedList<>();
        int length = s.length();
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            for (int i = 0, queueLength = queue.size(); i < queueLength; i++) {
                int pos = queue.poll();
                for (String word : wordDict) {
                    if (s.charAt(pos) == word.charAt(0) && s.indexOf(word, pos) == pos) { 
                        if (pos + word.length() == length)
                            return true;
                        queue.offer(pos + word.length());
                    }
                }
            }
        }
        return false;
    }*/
	
    public boolean wordBreak(String s, Set<String> wordDict) {

    	int length = s.length();
    	boolean[] result = new boolean[length + 1];
    	result[0] = true;
    	
    	for (int i = 1; i < length; i++) {
    		for (int j = 0; j < i; j++) {
    			if (result[j] && wordDict.contains(s.substring(j, i))) {
    				result[i] = true;
    				break;
    			}
    		}
    	}
    	
    	return result[length];
    	
    }
}
