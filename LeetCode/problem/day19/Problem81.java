package problem.day19;

public class Problem81 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1},1));

    }
    public static boolean search(int[] nums, int target) {
        //  2,5,6,0,0,1,2
        if(nums==null || nums.length==0)return false;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (end-start)/2+start;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>nums[start]){ //left part is sorted
                if(nums[mid]>=target && target>=nums[start]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{  //right part is sorted
                if(nums[mid+1]<=target && target <=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return false;
    }
}
