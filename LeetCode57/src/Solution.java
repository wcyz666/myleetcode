import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
	

	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        if (intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        
        int rightMost = intervals.size() - 1;
        int leftPos = binarySearchEnd(intervals, 0, rightMost, newInterval.start);
        int rightPos = binarySearchstart(intervals, 0, rightMost, newInterval.end);
            
        
        Interval mergedInterval = new Interval(leftPos == intervals.size() ? 
        			newInterval.start == intervals.get(leftPos - 1).end ? intervals.get(leftPos - 1).start
        					: newInterval.start
        					: Math.min(newInterval.start, 
        		intervals.get(leftPos).start), rightPos == 0 ? 
        				newInterval.end : Math.max(newInterval.end, intervals.get(rightPos - 1).end));
        for (int i = leftPos; i < rightPos; i++){
            intervals.remove(leftPos);
        }
        intervals.add(leftPos, mergedInterval);
        return intervals;
    }
    
    
    private int binarySearchstart(List<Interval> num, int left, int right, int key) {
		if (left > right)
			return left;

		int mid = (left + right) / 2;
		int midValue = num.get(mid).start;

		if (midValue > key) {
			return binarySearchstart(num, left, mid - 1, key);
		} else {
			return binarySearchstart(num, mid + 1, right, key);
		} 
    }
    
    private int binarySearchEnd(List<Interval> num, int left, int right, int key) {
		if (left > right)
			return left;

		int mid = (left + right) / 2;
		int midValue = num.get(mid).end;

		if (midValue >= key) {
			return binarySearchEnd(num, left, mid - 1, key);
		} else {
			return binarySearchEnd(num, mid + 1, right, key);
		} 
    }
}