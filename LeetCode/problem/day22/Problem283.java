package problem.day22;

import java.util.Arrays;

public class Problem283 {
    public static void main(String[] args) {
        int []n=new int[100];
        moveZeroes(new int[]{0,1,0});

    }
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
     }
}
