/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

    /**
    * @param intervals - list of intervals
    * @param newInterval
    * @return insert - new list of intervals after original one been merged
    *                  [new.s, new.e]
    * [iter.s, iter e]       [iter.s,   iter e]
    * connercase: list is empty=> add object in intervals list and return intervals
    * i < intervals.size() in 3 while
    * 1 while new.start > iteration.end => add all the intervals to result
    * 2 get the new end >= iteration.start => merge all overlapping intervals to one considering newInterval
    * 3 while add rest of intervals to list
    * 4 add rest of intervals
    * 
    **/
   public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(intervals.isEmpty()){
            intervals.add(newInterval);
            return intervals;
        }
        
        int i = 0;
        while(i < intervals.size() && newInterval.start > intervals.get(i).end){
            result.add(intervals.get(i));
            i++;
        }
        
        while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            
            i++;
        }
        result.add(newInterval);
        while(i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        
        return result;
        
    }
}
