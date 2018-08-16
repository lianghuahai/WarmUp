package problem.day8;

public class Problem33 {

    public static void main(String[] args) {
        int [] nums = new int[]{3,1};
        int search1 = search2(nums,1);
        System.out.println(search1);
    }
    public static int search(int[] nums, int target) {
        return 0;
    }
    
    
    // mine  winning 100%
    // The idea here is to work with partial sorted array. eg   456123, we cut at mid of position 3, which is value 1, 
    // now we compare  Array[leftmost]< Array[mid], if it is true, means left part is sorted, and we could get into left-array to find 
    // whether  target is in (left, mid). if it's true, we recursive call (left, mid-1). if not  call (mid+1,right)
    // again, the key is the partial sorted array!
        
    public static int search2(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        if(nums[0]>target && nums[nums.length-1]<target){
            return -1;
        }
        return search(nums,0,nums.length-1,target);
    }
    public static int search(int[] nums,int left,int right, int target){
        if(left>right){
            return -1;
        }
        int mid = (left+ right)/2;
        if(nums[mid]==target){
            return mid;
        }
        
        if(nums[mid]>=nums[left] ){  //left part is sorted , property: min(left) > max(right)   4 5 6 1 2 3,  4>3!
            if( target>=nums[left] && target< nums[mid]){
                return search(nums,left,mid-1,target);
            }else{
                return search(nums,mid+1,right,target);
            }
        }else{  //right part is sorted
            if( target>nums[mid] && target<= nums[right]){
                return search(nums,mid+1,right,target);
            }else{
                return search(nums,left,mid-1,target);
            }
        }
    }
    
    
    //others2
    public static int search1(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {   //5,6,7,1,2,3
            int mid = lo + (hi - lo) / 2;
            long num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
                : target < nums[0] ? Long.MIN_VALUE : Long.MAX_VALUE;
            if (num > target) {
                hi = mid - 1;
            } else if (num < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
