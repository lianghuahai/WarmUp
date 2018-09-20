package problem.day8;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem84 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)return 0;
         Deque<Integer> stack = new ArrayDeque();
        // stack.push(0);
        int res =0;
        for(int i=0;i<=heights.length;i++){
            int hei=(i==heights.length?0:heights[i]);
            if(stack.size()==0 || heights[stack.peek()]<=hei){
                stack.push(i);
            }else{
                int localMax=stack.pop();
                res = Math.max(res,heights[localMax]*(stack.size()==0?i:i-stack.peek()-1));
                i--;
            }
        }
        return res;
    }
}
