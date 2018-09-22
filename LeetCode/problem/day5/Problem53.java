package problem.day5;

public class Problem53 {
    //if  current sum is negative , we will drop it and start next value!
    // else , current sum += next value
    // and max sum = max(curren, maxsum)
    public static void main(String[] args) {
        int []nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);

    }
    public static int maxSubArray(int[] A) {
        int sum = A[A.length - 1];
           int maxSum = sum;
           for (int i = A.length - 2; i >= 0; i--) {
             sum = Math.max(A[i], sum + A[i]);                 // super smart
            maxSum = Math.max(maxSum, sum);
          }
          return maxSum;
    }
    
    //not smart enough, but the idea is same as above
    public static int maxSubArray2(int[] nums) {
        int max_sum = Integer.MAX_VALUE;
        int tmp_sum = 0;
        for(int i=0;i<nums.length;++i)
        {
            if (tmp_sum >= 0)   
                tmp_sum += nums[i];
            else
                tmp_sum = nums[i];
            if (tmp_sum > max_sum)
                max_sum = tmp_sum;
        }
        return max_sum;
    }
}
