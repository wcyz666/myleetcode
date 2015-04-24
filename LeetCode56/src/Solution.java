import java.util.Arrays;
import java.util.LinkedList;
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
public class Solution {
	
	
/*    // Sort by ascending starting point using an anonymous Comparator
    Collections.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    });*/

    class Terminal implements Comparable<Terminal> {
        public int value;
        public boolean isLeft;
    
        public Terminal(int _value, boolean _isLeft) {
            this.value = _value;
            this.isLeft = _isLeft;
        }
    
        public int compareTo(Terminal other) {
            if (this.value > other.value || (this.value == other.value && this.isLeft == false && other.isLeft != false))
                return 1;
            if (this.value == other.value && this.isLeft == other.isLeft)
                return 0;
            return -1;
        }
    }
    
    public List<Interval> merge (List<Interval> intervals) {
        List<Interval> list = new LinkedList<>();
        int size = intervals.size();
        if (size == 0) 
            return list;
        Terminal[] terminals = new Terminal[size * 2];
        int num = 0;
        for (Interval interval :  intervals) {
            terminals[num++] = new Terminal(interval.start, true);
            terminals[num++] = new Terminal(interval.end, false);
        }
        Arrays.sort(terminals);
        int openTer = 0, begin = 0;
        for (int i = 0; i < size; i++) {
            if (terminals[i].isLeft) {
                if (openTer == 0)
                    begin = terminals[i].value;
                ++openTer;
            }
            else {
                if (openTer == 1) {
                    list.add(new Interval(begin, terminals[i].value));
                }
                --openTer;
            }
        }
        return list;
    }

}