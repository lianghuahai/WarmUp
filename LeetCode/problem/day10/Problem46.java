package problem.day10;

import java.util.ArrayList;
import java.util.List;

public class Problem46 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtracking(nums,list);
        return list;
    }
    public static void backtracking(int[] nums,List<List<Integer>> list){
        
    }
    
    
    //others
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
     }

     private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
           list.add(new ArrayList<>(tempList));
        } else{
           for(int i = 0; i < nums.length; i++){ 
              if(tempList.contains(nums[i])) continue; // element already exists, skip
              tempList.add(nums[i]);
              backtrack(list, tempList, nums);
              tempList.remove(tempList.size() - 1);
           }
        }
     } 
}
