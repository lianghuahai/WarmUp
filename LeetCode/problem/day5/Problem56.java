package problem.day5;

import helperClass.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem56 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /* 这道题目给了我们一个区间的list，让我们返回一个list，是合并了所有有重叠的区间之后的list。
                  这道题目的关键在于如何判断两个区间有重叠，根据原题给的例子可以看出，在按照每个区间的start排序之后很容易判断出是否相邻的两个区间有交集。
                  我们看第一个区间[1,3] 中的end 3 > 第二个区间[2,6] 的start 2。在排序完之后，只要前面一个区间的end 大于等于 后面一个区间的start，它们就是重叠的。
                  那么为了merge 这两个区间，保留第一个区间的start， 在两个end里面拿大的。设一个temp 等于第一个区间，遍历剩下的区间。
                  然后每次拿temp 和这个区间比较，要注意的是，如果遇到了重叠的，把temp 更新为merge 后的区间，这时不需要加入list，因为还有可能继续和下一个区间重叠。
                  当temp和这个区间不重叠的时候，把temp 加入list，再把这个区间设为新的temp
   */
    /*
      comparetor  接口:
                          该接口用于对象与对象间的比较，返回值意味着这两对象之间的大小关系。
          -1代表前者小，0代表两者相等，1代表前者大。从小到大排列
    */
    public static List<Interval> merge(List<Interval> intervals) {
     // sort the intervals list according to start
        List<Interval> res = new ArrayList<>();
         Collections.sort(intervals, new Comparator<Interval>(){
             public int compare(Interval a, Interval b)
             {
                 return a.start - b.start;
             }
         });;
         
        // get first one
         Interval temp = intervals.get(0);
         
         // if intervals only has one element
         if(intervals.size() == 1)
         {
             res.add(temp);
             return res;
         }
         
         // iterate intervals from [1] to end
         for(int i=1; i<intervals.size(); i++)
         {
             // case 1: if temp interval end >= this interval start -> 
             //            merge tempStart, max(tempEnd, thisEnd) and make this merge one as new temp;
             if(temp.end >= intervals.get(i).start)
             {
                 temp.end = Math.max(temp.end, intervals.get(i).end);
             }
             // case 2: if temp interval is not overlapping this interval ->
             //            add temp into list and make this new temp
             else
             {
                 res.add(temp);
                 temp = intervals.get(i);
             }
         }
         // add the last temp into list
         res.add(temp);
         
 
         return res;
    }
}
