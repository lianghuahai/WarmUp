package problem.day6;

public class Problem66 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
  //method 1.
    public int[] plusOne1(int[] digits) {
        for(int i =digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }else{
                digits[i]=0;
            }
        }
        int []res = new int[digits.length+1];
        res[0]=1;
        return res;
   }
    //method 2. foolish!
    public int[] plusOne(int[] digits) {
        if(digits[0]==0){
            digits[0]=1;
            return digits;
        }
        for(int i =digits.length-1;i>=0;i--){
            if(digits[i]+1>=10){
                digits[i]=0;
            }else{
                digits[i]=digits[i]+1;
                break;
            }
        }
        int[] nums = new int[digits.length+1];
        if(digits[0]==0){
            nums[0]=1;
            for(int i =1;i<nums.length;i++){
                nums[i]=0;
            }
            return nums;
        }
        
        return digits;
        
    }
}
