package problem.day13;

public class Problem41 {

    public static void main(String[] args) {
        int []nums = new int[]{3,4,-1,1};
//        int []nums = new int[]{7,8,9,11,12};
        int maxSubArray = firstMissingPositive1(nums);
        System.out.println(maxSubArray);

    }//
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if((i+1)!=nums[i] && nums[i]>0&&nums[i]<=nums.length){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }else{
                i++;
            }
        }
        for( i = 0;i<nums.length;i++){
            if((i+1)!=nums[i] ){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static int firstMissingPositive1(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n)
        {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;}
            else
                i++;
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j]+" ");
        }
        for (i = 0; i < n; ++i)
            if (nums[i] != (i+1))
                return i+1;
        return n+1;
    }
}
