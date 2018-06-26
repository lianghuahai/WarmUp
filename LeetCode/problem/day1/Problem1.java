package problem.day1;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    //solution 1  , slow   O(n^2)
        public int[] twoSum(int[] nums, int target) {
            int [] result= {0,0};
            for(int i =0;i<=nums.length-1;i++){  
                boolean flag = false;
                for(int j =i+1;j<=nums.length-1;j++){
                    if(j==i){
                        continue;
                    }
                    if((nums[i]+nums[j])==target){
                        result[0]=i;
                        result[1]=j;
                        flag=true;
                        return result;
                    }
                }
                if(flag){
                    break;
                }
            }
            return null;
    }
        //solution hash table,  O(n)
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
}
