package problem.day23;

public class Problem238 {
    /*
     * idea is to loop array from left to right,  get the left product of current value,
     *       and  loop array from right to left,  get the right product of current value,
     *    then, times them up, will give the res
     */
    public int[] productExceptSelf(int[] nums) {
        int res [] = new int [nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i-1]* res[i-1];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]=res[i]*right;
            right=right*nums[i];
        }
        return res;
    }
}
