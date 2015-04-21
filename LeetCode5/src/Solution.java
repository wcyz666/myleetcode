

public class Solution {
    public String longestPalindrome(String s) {
    	
/* Manacher's algorithm   	
 * 
 * def longestPalindrome(self, s):
    	    #The main idea is  manacher's algorithm
    	    string="#"+"#".join(s)+"#"      # a trick that simplifies the problems
    	                                    # e.g.:"aaa" ->"#a#a#a#" or "aa"->"#a#a#"
    	    i=0
    	    mxBorder=0                #stores the max Border that has been reached
    	    mxCenter=0                # ------mxCenter------mxBorder
    	    p=[0]*len(string)
    	    res=[0,0]

    	    while i< len(string):
    	        if mxBorder>i:            #------mxCenter---i--mxBorder
    	            p[i]=min(p[2*mxCenter-i],mxBorder-i) # pickes the min in(center to i or i to border) 

    	        else:
    	            p[i]=1

    	        while i-p[i]>=0 and i+p[i]<len(string)and string[i-p[i]]==string[i+p[i]]:
    	            p[i]+=1

    	        if mxBorder<p[i]+i:
    	            mxBorder=p[i]+i
    	            mxCenter=i
    	            if mxBorder-mxCenter>res[1]-res[0]:
    	                res=[mxCenter,mxBorder]#records the temp maxCenter and mxBorder

    	        i+=1

    	    return "".join([x for x in string[2*res[0]-res[1]+1:res[1]] if x!='#'])*/
    	
    	
        int maxLength = 1, start = 0;
        for (int i = 1; i < s.length() - 1; i++){
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(k) == s.charAt(j)){
                j--; k++;
            }
            if (k - j - 1 > maxLength){
                start = j + 1;
                maxLength = k - j - 1;
            }
        }
        for (int i = 0; i < s.length() - 1; i++){
        	if (s.charAt(i) != s.charAt(i + 1)) continue;
            int j = i - 1, k = i + 2;
            while (j >= 0 && k < s.length() && s.charAt(k) == s.charAt(j)){
                j--; k++;
            }
            if (k - j - 1 > maxLength){
                start = j + 1;
                maxLength = k - j - 1;
            }
        }
        return s.substring(start, start + maxLength);     
    }

}