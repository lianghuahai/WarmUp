package problem.day1;

public class Problem27 {
    public static <E> void main(String[] args) {
        int[] x = {2,3,4,3};
        System.out.println(x);
        int reverse = removeElement(x,3);
        System.out.println(reverse);
    }
    
    public static int removeElement(int[] nums, int val) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
             if(nums[i]==val){
                 continue;
             }else{
                 nums[j]=nums[i];
                 j++;
             }
        }
        return j;
    }
}
