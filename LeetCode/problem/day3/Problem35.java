package problem.day3;

public class Problem35 {
    public static <E> void main(String[] args) {
        int[] x = {2,3,4,3};
        System.out.println(x);
        int reverse = searchInsert(x,3);
        System.out.println(reverse);
    }
    public static int searchInsert(int[] nums, int target) {
        for(int i =0; i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }
    public static int searchInsert2(int[] nums, int target) {
        // binary search, size/2
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
