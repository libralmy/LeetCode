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
    * @param intervals a list of Interval 
    * @return List<Interval> merge the intervals
    * 
    * conner case: list.size() <= 1 ---return @param
    * collection sort intervals based on start point
    * 
    * curStart <= preEnd
    * [preStart,        preEnd]
    * [curStart, curEnd]         curEnd]
    * preEnd =  Max(preEnd, curEnd)
    * 
    * curStart > preEnd
    * [preStart, preEnd]
    *                   [curStart, curEnd]
    * add(new Interval(preStart, preEnd)),  reassign [preStart, preEnd], 
    * 
    * add(new Interval(curStart, curEnd)) - for the last pair
    * 
    **/
public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        if(intervals.size() <= 1){return intervals;}
        
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare (Interval i1, Interval i2){
                return Integer.compare(i1.start, i2.start);
            }
            
        });
        
        int preStart = intervals.get(0).start;
        int preEnd = intervals.get(0).end;
        for(Interval cur : intervals){

           if(cur.start <= preEnd){
               preEnd = Math.max(cur.end, preEnd);

           }else{
               result.add(new Interval(preStart, preEnd));
               preStart = cur.start;
               preEnd = cur.end;
           }
        }
        result.add(new Interval(preStart, preEnd));
        return result;

    }
}
