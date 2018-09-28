package problem.day8;

public class Problem80 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(removeDuplicates(new int[]{5,5,5,5,5,6,6,7}));
    }
    public static int removeDuplicates(int[] nums) {
        // i point to the position which is waiting to be inserted
        // 5 5 5 5 5 6 6 7
        //     i            
        // n from index 0 to  4, and n =6
// nextloop:     5 5 6 5 5 6 6 7
        //             i            
        //                   n
        
// nextloop:     5 5 6 6 5 6 6 7
        //               i            
        //                     n
        
// nextloop:     5 5 6 6 7 6 6 7
        //                 i            
        //                       n
        //return i =5
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])//because it is sorted, if n > nums[i-2] is false means n== nums[i-2], if n== nums[i-2] ,nums[i-1]is the same, we dont move i 
                nums[i++] = n;
        return i;
    }
    public int removeDuplicates2(int[] nums) {
        
        if(nums.length<=2)return nums.length;
        int counter=2;
        for(int i = 2;i<nums.length;i++){
            if(nums[i]!=nums[counter-2]){
                nums[counter++]=nums[i];
            }
        }
        return counter;
    }
}
