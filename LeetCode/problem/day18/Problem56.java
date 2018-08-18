package problem.day18;

import helperClass.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem56 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*  先排序，排序需要nlogn的时间  ，再进行n次比较 ，比较只有两种情况，1是start<之前的end，就是overlap ，update end、 2。不是overlap ，把之前的start和end存起来
     * 
     *  overlap      not overlap
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
