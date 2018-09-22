package problem.day5;

public class Problem55 {

    public static void main(String[] args) {
        int [] nums = new int[]{1,0,1,1,4};
        boolean canJump = canJump1(nums);
        System.out.println(canJump);

    }
    //1. backtracking brute force 
    public static boolean canJump1(int[] nums) {
        return backtracking(0,nums);
    }
    public static boolean backtracking(int position,int[] nums) {
        if(position>=nums.length-1){
            return true;
        }
        int distance = position+nums[position];
        for(int i = position +1;i<=distance;i++){  // from small to large jump
//            for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)  // from large to small jump
            if(backtracking(i,nums)){
                return true;
            }
        }
        return false;
    }
    
    
    
    //2. greedy  only cases  upper boundary  it is not looking for a path!!!!!!
    // Therefore, as long as we know ,  if we can reach the last index or even over the nums.length
    public static boolean canJump2(int[] nums) {
        int reach=0;
        int i=0;
        while(i<nums.length && i<=reach){   // i<=reach  ensure we can reach the i  eg:  1 0 0 2, we cant reach 2nd 0 cause i=2 > 1
            reach=Math.max(reach,i+nums[i]);
            i++;
        }
        return reach>=nums.length-1; // reach  is  where the max index of nums we can reach
    }
}
