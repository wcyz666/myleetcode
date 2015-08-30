public class Solution {
	public class Solution {
	    public int compareVersion(String version1, String version2) {
	        int i, j, len1, len2;

	        String[] versionSeg1 = (version1).split("\\.");
	        String[] versionSeg2 = (version2).split("\\."); 
	        len1 = versionSeg1.length;
	        len2 = versionSeg2.length;
	        i = j = 0;
	        while (len1 > 0 && Integer.parseInt(versionSeg1[len1 - 1], 10) == 0) len1--;
	        while (len2 > 0 && Integer.parseInt(versionSeg2[len2 - 1], 10) == 0) len2--;        

	        while (i < len1 && j < len2) {
	            int verNum1 = Integer.parseInt(versionSeg1[i], 10);
	            int verNum2 = Integer.parseInt(versionSeg2[j], 10);
	            if (verNum1 != verNum2)
	                return verNum1 > verNum2 ? 1 : -1;
	            i++;
	            j++;
	        }
	        return len1 > len2 ? 1 : len2 == len1 ? 0 : -1;
	    }
	}
    
    public static void main(String[] args) {
		System.out.println(new Solution().compareVersion("1", "0"));
	}
}