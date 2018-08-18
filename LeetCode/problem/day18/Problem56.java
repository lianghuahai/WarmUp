package problem.day18;

import helperClass.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem56 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*    overlap      not overlap
    eg:  |__|       |__|
           |__|          |__| 
   time O(nlogn)  space O(n)
    */
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()<=1)return intervals;
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        
        for(Interval interval : intervals){
            if(interval.start<=end){
                end=Math.max(end,interval.end);
            }else{
                res.add(new Interval(start,end));
                start=interval.start;
                end=interval.end ;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}
