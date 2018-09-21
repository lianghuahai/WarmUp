package problem.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2};
//      // TODO Auto-generated method stub
      List<List<Integer>> subsets2 = permute2(nums);
      System.out.println(subsets2.size());
      for (List<Integer> list : subsets2) {
          for (Integer integer : list) {
              System.out.print(integer);
          }
          System.out.println();
      }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtracking(nums,list);
        return list;
    }
    public static void backtracking(int[] nums,List<List<Integer>> list){
        
    }
    
    //subsets II
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);// array must be sorted!!!! otherwise {4,4,4,1,4}  last 4  cant be skipped
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        if(start<= nums.length){
            list.add(new ArrayList<>(tempList));
        }
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 

    // permute I
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
   // permute II
     public static List<List<Integer>> permute2(int[] nums) {
         Arrays.sort(nums);
         List<List<Integer>> list = new ArrayList<>();
         backtrack2(list, new ArrayList<Integer>(), nums,new boolean[nums.length]);
         return list;
      }
     private static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums,boolean[]used){
         if(nums.length==tempList.size()){
             list.add(new ArrayList<Integer>(tempList));
         }
         for (int i = 0; i < nums.length; i++) {
//          1.   if( used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
          //2.
           if(used[i]) continue;
           if( i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;//!used[i - 1] decide if it is going to each permutation, or on the top(first value)，意思就是这个如果是循环开始的第一个元素nums[i] == nums[i-1] 就不需要再重复做了，但是如果在别人的case里面（used[i-1]=true就证明前面在做，这时候就不能跳过了） 
            tempList.add(nums[i]);
            used[i]=true;
            backtrack2(list, tempList, nums,used);
            used[i]=false;
            tempList.remove(tempList.size()-1);
        }
     } 
     
     
     
}
