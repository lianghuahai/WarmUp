package problem.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * subsets    combination
 */
public class Problem78 {
    
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,2};
//        // TODO Auto-generated method stub
//        List<List<Integer>> subsets2 = subsets2(nums);
//        for (List<Integer> list : subsets2) {
//            System.out.println(list);
//        }
        
        
//        Map<Character,Integer> mapping = new HashMap<Character,Integer>();
//        List<Integer>[] bucket = new ArrayList[nums.length + 1];
//        String  s = "leetcode";
//        for(int i =0;i<s.length();i++){
//            if(mapping.get(s.charAt(i))!=null){
//                mapping.put(s.charAt(i),mapping.get(s.charAt(i))+1);
//            }else{
//                  mapping.put(s.charAt(i),1);
//            }
//        }
//        for(int i =0;i<s.length();i++){
//            if(mapping.get(s.charAt(i))== 1){
//                System.out.println(i);
//            }
//        }
        
    }
    // leetcode  90  Subsets II  [1,2,2]  passed 15/19
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(new ArrayList<Integer>());
        for(int i = 0;i< nums.length;i++){
            int preSize = lists.size();
            for(int j = 0 ;j<preSize;j++){
                 List<Integer> temp = new ArrayList<Integer>(lists.get(j));
                temp.add(nums[i]);
                if(lists.contains(temp)){
                    continue;
                }
                lists.add(temp);
            }
        }
        return lists;
    }
    // 1. basic loop Subsets I  [1,2,3]
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> list : result) {
            
        }
        result.add(new ArrayList<Integer>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<Integer>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
    
    // 2. backtracking
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
