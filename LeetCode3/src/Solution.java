import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	
	
	public int leng(String s){
		int len = 0;
		for (int i = 0; i < s.length(); i++){
			int tmp = 0;
			for (int j = i + 1; j < s.length(); j++){
				if (s.charAt(i) != s.charAt(j))
					++tmp;
				else {
					len = Math.max(len, tmp);
					break;
				}
			}
		}
		return len;
				
	}
	
    public int lengthOfLongestSubstring(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	int length = s.length(), lenLS = 0, j = -1;
        for (int i = 0; i < length; i++){
        	Integer pos = map.get(s.charAt(i));
        	if (pos != null && pos >= j){
        		lenLS = lenLS >= i - 1 - j ? lenLS : i - 1 - j;
        		j = pos;
			}
        	map.put(s.charAt(i), i);
        }
        return lenLS < length - 1 - j ? length - 1 - j : lenLS;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().lengthOfLongestSubstring("hchzvfrkmlnozjk"));
    	System.out.println(new Solution().lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
    	System.out.println(new Solution().lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
		System.out.println(new Solution().lengthOfLongestSubstring("abcaaaa"));
		System.out.println(new Solution().lengthOfLongestSubstring("abc"));
		System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));

	}
}