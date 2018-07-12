package problem.day12;


public class Problem31 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        System.out.println(nums);

    }
    //mine
    public static void nextPermutation(int[] nums) {
        //eg:   1 2 4 8 7 5 1
        if(nums.length<=1){
            return ;
        }
        int i = nums.length-1; 
        while(i>0 && nums[i]<=nums[i-1]){
            i--;
        }
        i=i-1;
        if(i>=0){
            //eg:   1 2 [i=4] 8 7 5 1
            int exchangeIndex = i+1;
            int j = i+1;
            while(j<nums.length){
                if(nums[j]>nums[i] && nums[j]<=nums[exchangeIndex]){
                    exchangeIndex = j;
                }
                j++;
            }
            //eg:   1 2 [i=5] 8 7 4 1
            int temp = nums[i];
            nums[i]=nums[exchangeIndex];
            nums[exchangeIndex]=temp;
            }
        //reverse nums from i+1
        i = i+1;
        int j = nums.length-1;
        while(i<j){
            int t = nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
        
    }
    
    
    //others
    public static void nextPermutation1(int[] nums) {
        int len=nums.length,i=len-1,j,tmp;
        while(i>0 && nums[i]<=nums[i-1])i--;
        if(i>0){
            j=len-1;
            while(nums[j]<=nums[i-1])j--;
            tmp=nums[j];
            nums[j]=nums[i-1];
            nums[i-1]=tmp;
        }
        j=len-1;
        while(i<j){
            tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;j--;
        }
    }
}
