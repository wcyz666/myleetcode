import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> mapFunction = new HashMap<>();
        Set<Character> testMap = new HashSet<>();
        for (int i = 0, length = s.length(); i < length; i++) {
            char curChar = t.charAt(i);
            Character prevChar = mapFunction.put(s.charAt(i), curChar);
            if (prevChar != null && prevChar != curChar)
                return false;
        }
        
        for (Character ch : mapFunction.values()) {
            if (testMap.add(ch) != true)
                return false;
        }
        return true;
    }
}