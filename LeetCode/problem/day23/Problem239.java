package problem.day23;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem239 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*  idea:  using a deque, loop nums from 0 ->nums.length
     * deque should be descending, if nums[i]>nums[deque.peekLast()],  deque.pollLast
     * also we have to remove index out of range k in deque
           [1  3  -1] -3  5  3  6  7
     * i=0 :    deque:  1    
     * i=1 :    deque:  3    
     * i=2 :    deque:  3 -1
            1  [3  -1 -3]  5  3  6  7  
      
     * i=3 :    deque:  3 -1 -3  
     *  
            1  3  [-1 -3  5]  3  6  7 
     * i=4 :    deque:  3 -1 -3   =>  deque : 5    remove 3 cause is out of range k, remove -1,-3 cause  less than 5
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
                return new int[0];
        }
        int len = nums.length;
        int []res=new int[len-k+1];
        int ri = 0;
        Deque<Integer> map= new ArrayDeque();
        for(int i=0;i<len;i++){
           // remove numbers out of range k
            if (map.size()>0 && map.peek() < i - k + 1) {
                    map.poll();
            }
         // remove smaller numbers in k range as they are useless
            while(map.size()>0 && nums[map.peekLast()]<nums[i]){
                map.pollLast();
            }
            map.offerLast(i);
            if(i+1>=k){
                res[ri++]=nums[map.peek()];
            }
        }
        return res;
    }
}
