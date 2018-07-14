package problem.day15;

public class Problem70 {

    public static void main(String[] args) {
        
        System.out.println(climbStairs(4));

    }
    public static int climbStairs(int n) {
        // 1. recursion Time Limit Exceeded
        // if(n==1 ){
        //     return 1;
        // }
        // if(n==2){
        //     return 2;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);
        
        //2.
        int []nums=new int[n+2];
        nums[1]=1;
        nums[2]=2;
        return recursive(n,nums);
        
    }
    public static int recursive(int n,int []nums) {
        if(nums[n]!=0){
            return nums[n];
        }
        if(n==1 ){
            return 1;
        }
        if(n==2){
            return 2;
        }
        nums[n]=recursive(n-1,nums) + recursive(n-2,nums);
        return nums[n];
    }
}
