package problem.day8;

public class Problem34 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    // binary search
    // if find the index of target , the do left scan and right sacn,
    // low , high = index,   low to left, and high to right, find the leftmost and rightmost of target.
    public static int[] searchRange(int[] nums, int target) {
        int [] res = new int []{-1,-1};
        if(nums==null ||nums.length==0){
            return res;
        }
        int index = search(nums, 0,nums.length-1,target);
        if(index==-1){
            return res;
        }
        int low= index;
        int high = index;
        while(low >= 0 && nums[low]==target){
            res[0]=low--;
        }
        while(high <nums.length && nums[high]==target){
            res[1]=high++;
        }
        return res;
    }
    
    public static int search(int[] nums, int left,int right,int target) {
        if(left > right ){
            return -1;
        }
        int mid = (right+left) /2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
            return search(nums, left,mid-1,target);
        }else{
            return search(nums, mid+1,right,target);
        }
    }
    /*    
    vector<int> searchRange(int A[], int n, int target) {
    int i = 0, j = n - 1;
    vector<int> ret(2, -1);
    // Search for the left one
    while (i < j)
    {
        int mid = (i + j) /2;
        if (A[mid] < target) i = mid + 1;      <----key!!! we dont return when we find the target,
                                            we keep looping to the left most position!!!! The condition is really good!
        else j = mid;
    }
    if (A[i]!=target) return ret;
    else ret[0] = i;
    
    // Search for the right one
    j = n-1;  // We don't have to set i to 0 the second time.
    while (i < j)                              <----key!!! same here!!!!
                                                          
    {
        int mid = (i + j) /2 + 1;       // Make mid biased to the right
        if (A[mid] > target) j = mid - 1;  
        else i = mid;                           // So that this won't make the search range stuck.
    }
    ret[1] = j;
    return ret; 
}
     */
}
