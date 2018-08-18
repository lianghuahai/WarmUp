package problem.day18;

import helperClass.Interval;

import java.util.ArrayList;
import java.util.List;

public class Problem57 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /* first,  loop intervals, to add the intervals which are not overlap with newInterval
     * second, loop intervals again,  update the newInterval.start and newInterval.end  which are overlap
     * last time, loop for rest of the intervals which are not overlap with newInterval
     * 
     *  
   intervals:         |__|   |__|  |__|  |__|
   newInterval :            |________|     
     time O(n)  space O(n)
   */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null)return intervals;
        List<Interval> res = new ArrayList<Interval>();
        int i=0;
        while(i<intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i++));
        }
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end ){
            newInterval.start  = Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end  = Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        res.add(newInterval);
        while(i<intervals.size()){
            res.add(intervals.get(i++));
        }
        return res;
    }
}
