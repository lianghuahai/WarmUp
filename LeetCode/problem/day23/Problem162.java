package problem.day23;

public class Problem162 {
    //binary search  if nums[i]<nums[i+1] we can always find peek element from right sub-array of nums[i]; or left-subarray
    public int findPeakElement(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;
        while(low < high) {
            mid = low + (high-low)/2;
            if(a[mid] < a[mid+1]) low = mid+1;
            else high = mid;
        }
        return low;
    }
    
    //linear O(n)
    public int findPeakElement2(int[] nums) {
        if(nums.length<=1)return 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1]<nums[i]&&nums[i]>nums[i+1])return i;
        }
        return nums[0]>nums[nums.length-1]?0:nums.length-1;
    }
}
