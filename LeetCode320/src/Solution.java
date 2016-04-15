import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateAbbreviations(String word) {
        Set<String> set = new HashSet<>();
        
        if (word.length() == 0) {
            return new ArrayList<>(set);
        }
        
        boolean[] results = new boolean[word.length()];
        Arrays.fill(results, false);
        
        _generateAbbreviations(results, set, 0, word);
        
        return new ArrayList<>(set);
    }
    
    public void _generateAbbreviations(boolean[] results, Set<String> list, int cur, String word) {
        if (cur == word.length()) {
        	list.add(generateResult(results, word));
        } else if (cur < word.length()) {
        
            results[cur] = false;
            _generateAbbreviations(results, list, cur + 1, word);
            results[cur] = true;
            _generateAbbreviations(results, list, cur + 1, word);

        }
    }
    
    public String generateResult(boolean[] results, String word) {
        int length = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            if (results[i]) {
                length++;
            } else {
                if (length > 0) {
                    sb.append(length);
                }
                length = 0;
                sb.append(word.charAt(i));
            }
        }
        if (length > 0) {
            sb.append(length);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().generateAbbreviations("word"));
	}
}