import java.util.LinkedList;
import java.util.List;


/*
 * public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new LinkedList<String>();

        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= L; w++) {
                len += words[w].length() + 1;
            }

            StringBuilder strBuilder = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) { // not 1 char, not last line
                space = (L - len) / (w - i - 1) + 1;
                extra = (L - len) % (w - i - 1);
            }
            for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) strBuilder.append(' ');
                if (extra-- > 0) strBuilder.append(' ');
                strBuilder.append(words[j]);
            }
            int strLen = L - strBuilder.length();
            while (strLen-- > 0) strBuilder.append(' ');
            list.add(strBuilder.toString());
        }

        return list;
    }
}
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> strings = new LinkedList<>();
        boolean sentenceEnd = false;
        for (int i = 0, length = words.length; i < length; ) {
            int thisLine = words[i].length();
            int thisWord = 1;
            int thisSpace = 0;
            int start = i;
 
            for (i++; i < length; i++) {
                if (thisLine + thisSpace + 1 + words[i].length() <= maxWidth) {
                    thisLine += words[i].length();
                    thisSpace++;
                    thisWord ++;
                }
                else {
                    break;
                }
            }
            sentenceEnd = i == length && words[i - 1].endsWith(".");
            StringBuilder sb = new StringBuilder();
            if (i - start > 1) {
	            int maxSpace = maxWidth - thisLine;
	            int j = 0;
	            for (int oneSpace = (maxSpace + thisSpace - 1) / thisSpace; j < thisWord - 1; j++) {
	                sb.append(words[j + start]);
	                if (sentenceEnd) {
	                    sb.append(' ');	                	
	                }
	                else if (maxSpace >= oneSpace ) {
	                    maxSpace -= oneSpace;	    
	                    thisSpace--;
	    	            for (int k = 0; k < oneSpace; k++)
	    	            	sb.append(' ');
	                    if (thisSpace > 0)
	                    	oneSpace = (maxSpace + thisSpace - 1) / thisSpace;
	                }
	                else {
	                    for (int k = 0; k < maxSpace; k++)
	                        sb.append(' ');
	                }
	            }
	            sb.append(words[i - 1]);
            }
            else {
            	sb.append(words[i - 1]);
            	for (int j = 0, spaceCount = maxWidth - words[i - 1].length(); j < spaceCount; j++) {
            		sb.append(' ');
            	}
            }
            if (sentenceEnd)
            	for (int j = 0, spaceCount = maxWidth - sb.length(); j < spaceCount; j++) 
            		sb.append(' ');            	
            strings.add(sb.toString());
            
        }
        return strings;
    }
    
    public static void main(String[] args) {
		List<String> resList = new Solution().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
		for (String string: resList)
			System.out.println(string);
		resList = new Solution().fullJustify(new String[]{"Twenty","years","from","now","you","will","be","more","disappointed","by","the","things","you","didn't","do","than","by","the","ones","you","did.","So","throw","off","the","bowlines,","Sail","away","from","the","safe","harbor.","Catch","the","trade","winds","in","your","sails.","Explore.","Dream."}, 15);
		for (String string: resList)
			System.out.println(string);
		resList = new Solution().fullJustify(new String[]{"What","must","be","shall","be."}, 12);
		for (String string: resList)
			System.out.println(string);
		resList = new Solution().fullJustify(new String[]{"Here","is","an","example","of","text","justification."}, 14);
		for (String string: resList)
			System.out.println(string);
		resList = new Solution().fullJustify(new String[]{"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."}, 20);
		for (String string: resList)
			System.out.println(string);
	}
}