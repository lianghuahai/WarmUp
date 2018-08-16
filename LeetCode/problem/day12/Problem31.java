package problem.day12;


public class Problem31 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        nextPermutation2(nums);
        for (int i : nums) {
            System.out.print(i+" ");
        }

    }
    //idea is to scan the nums from length  to 0, looking for nums[i]<nums[i+1]
    // if not found,  index = -1 means  the array is decreasing , such as  9 6 5  3 1 , cant find the result, just reverse it!
    //if found, index =i, scan array.length to index i+1  again, find the closest number higher than it: nums[i]>nums[index]. swap it
    // then reverse the index i+1 to array.length again.  it is the result.
    public static void nextPermutation2(int[] nums) {
        if(nums.length<=1)return;
        int position = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                position=i;
                break;
                
            }
        }
        if(position>=0){
            int larger= 0;
            for(int i =nums.length-1;i>=0;i--){
                if(nums[i]>nums[position]){
                    int temp=nums[i];
                    nums[i]=nums[position];
                    nums[position]=temp;
                }
            }
        }
        int left=position+1;
        int right = nums.length-1;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
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
