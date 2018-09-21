package problem.day3;

import java.util.ArrayList;
import java.util.List;

public class Problem39 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
//        // TODO Auto-generated method stub
        List<List<Integer>> subsets2 = combinationSum(nums,7);
        for (List<Integer> list : subsets2) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtracking(candidates,list,new ArrayList<Integer>(),0,target);
        return list;
    }
    
    public static void backtracking(int[] nums ,List<List<Integer>> list,List<Integer> temp,int start, int target){
        if(target==0){
            list.add(new ArrayList<Integer>(temp)); 
            return ;
        }
        if(target<0){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, list, temp, i,target-nums[i]);//not i++, we could use same element twice
            temp.remove(temp.size()-1);
        }
    }
    
}
