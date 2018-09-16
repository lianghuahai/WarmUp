package problem.day24;

public class Problem334 {
    public static void main(String[] args) {
        increasingTriplet(new int[]{4,6,1,5});
    }
/*    in this problem we just need to determine whether the subsequence exists.
    so after assigning the value to min and secondMin,
    even though there might be a smaller value afterward and the variable min gets updated, 
    it does not affect the increasing subsequence overall 
    as long as there is an integer that is larger than 'secondMin'
*/
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<=2)return false;
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for(int n : nums){
            if(n<=min1){
                min1=n;
            }else if(n<=min2){
                min2=n;
            }else{
                return true;
            }
        }
        return false;
    }
}
