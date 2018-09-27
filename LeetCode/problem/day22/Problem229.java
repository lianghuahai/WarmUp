package problem.day22;

import java.util.ArrayList;
import java.util.List;

public class Problem229 {
    /*
     * first loop to find two numbers of majority
     * second loop is to check whether these two numbers are qualify  > (n/3) times
     * 
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList();
        if(nums.length==0)return res;
        int n1=nums[0],n2=nums[0],c1=0,c2=0;
         for(int i=0;i<nums.length;i++){
            if(nums[i]==n1){
                c1++;
            }else if(nums[i]==n2){
                c2++;
            }else if(c1==0){
                n1=nums[i];
                c1=1;
            }else if(c2==0){
                n2=nums[i];
                c2=1;
            }else{
                c2--;
                c1--;
            }
         }
        c1=0;
        c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==n1){
                c1++;
            }else if(nums[i]==n2){
                c2++;
            }
        }
        if(c1>nums.length/3)res.add(n1);
        if(c2>nums.length/3)res.add(n2);
        return res;
    }
}
