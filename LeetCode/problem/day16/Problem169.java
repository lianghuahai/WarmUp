package problem.day16;

import java.util.HashMap;
import java.util.Map;

public class Problem169 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        majorityElement(new int[]{1,1,3});
        
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int mid = nums.length/2;
        for(int n:nums){
            map.put(n,map.getOrDefault(n, 0)+1);
//            int x = map.getOrDefault(n, 0);
            if(map.getOrDefault(n, 0)>mid)return n;
        }
        return 0;
    }
}
