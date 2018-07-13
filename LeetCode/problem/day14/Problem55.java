package problem.day14;

public class Problem55 {

    public static void main(String[] args) {
        int [] nums = new int[]{1,0,1,1,4};
        boolean canJump = canJump(nums);
        System.out.println(canJump);

    }
    //1. greedy  only cases  upper boundary  it is not looking for a path!!!!!!
    // Therefore, as long as we know ,  if we can reach the last index or even over the nums.length
    public static boolean canJump(int[] nums) {
        int reach=0;
        int i=0;
        while(i<nums.length && i<=reach){   // i<=reach  ensure we can reach the i  eg:  1 0 0 2, we cant reach 2nd 0 cause i=2 > 1
            reach=Math.max(reach,i+nums[i]);
            i++;
        }
        return reach>=nums.length-1; // reach  is  where the max index of nums we can reach
    }
}
