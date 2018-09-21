package problem.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
         List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtracking(candidates,list,new ArrayList<Integer>(),0,target);
        return list;
    }
     public static void backtracking(int[] nums ,List<List<Integer>> list,List<Integer> temp,int start, int target){
        if(target<0){return;}
        if(target==0){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = start;i<nums.length;i++){                                       //   i =1
            if(i>start && nums[i-1]==nums[i]){continue;}   //imust>start, not i>0,   eg:  2 226  we dont look back to i=0, it will pass the right answer(i=0),we have to filter value 2 from i+1  
            temp.add(nums[i]);
            backtracking(nums,list,temp,i+1,target-nums[i]);
            temp.remove(temp.size()-1);
        }
        
        
    }
}
