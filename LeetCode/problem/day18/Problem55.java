package problem.day18;

public class Problem55 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public boolean canJump(int[] nums) {
        //1. greedy  only cases  upper boundary
        int reach=0,i = 0;
        while(i<nums.length && i<=reach){
            reach = Math.max(reach,i + nums[i]);
            i++;
        }
        return reach>=nums.length-1;
    }
}
