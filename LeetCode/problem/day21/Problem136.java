package problem.day21;

public class Problem136 {
    public int singleNumber(int[] nums) {
        int res =0;
        for(int i =0;i<nums.length;i++){
            res = nums[i]^res;
        }
        return res;
    }
}
