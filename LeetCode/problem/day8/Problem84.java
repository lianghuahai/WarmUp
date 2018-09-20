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
            int hei=(i==heights.length?0:heights[i]);   //最后一次还要做 为什么是0，一定要保证 hei比stack里面所有的数都小，这样就能做完所有剩下的
            if(stack.size()==0 || heights[stack.peek()]<=hei){
                stack.push(i);
            }else{
                int localMax=stack.pop();
                res = Math.max(res,heights[localMax]*(stack.size()==0?i:i-stack.peek()-1));  //stack empty 乘以i是因为例如 3,2,1 area=(3-0) * 1=3
                i--;
            }
        }
        return res;
    }
}
