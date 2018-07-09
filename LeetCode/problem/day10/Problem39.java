package problem.day10;

import java.util.ArrayList;
import java.util.List;

public class Problem39 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
//        // TODO Auto-generated method stub
        List<List<Integer>> subsets2 = subsets(nums);
        for (List<Integer> list : subsets2) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtracking(nums,list,new ArrayList<Integer>(),0);
        return list;
    }
    
    public static void backtracking(int[] nums ,List<List<Integer>> list,List<Integer> temp,int start){
        list.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, list, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
}
