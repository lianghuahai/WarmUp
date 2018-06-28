package problem.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import llinkedList.LinkedList;

public class Problem15 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2,5,5,8,-7,-9,5,-1,-4,2,8,4,-6,-2,-2,9,-2,13,1,0,9,9,4,-13,13,3,-14,11,-5,-13,3,4,7,-15,-11,7,13,1,13,-14,11,-1,5,-10,12,11,14,-13,1,-8,3,-4,-14,14,-10,-15,-6,-9,3,-4,-7,-8,-15,8,-8,12,-8,13,-2,-9,14,-6,5,-3,-9,-6,-7,-10,-3,9,-2,7,-10,-9,-2,-5,13,7,-6,2,-12,-6,1,10,9,0,7,-13,-2,-9,-7,-2,-8,5,10,-1,6,-12,4,10,12,9,2,10,8,-15,12,6,-1,-9,-7,2};
        List<List<Integer>> threeSum = threeSum(nums);
        System.out.println(threeSum);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> dic = new HashSet<List<Integer>>();  
//        HashMap <Integer,Integer> dic = new HashMap<Integer, Integer>();
        List<List<Integer>> lists= new ArrayList <List<Integer>>();
        for(int i=0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(repeated(dic, nums[i], nums[j])){
//                    if(dic.contains(nums[i]) && dic.contains(nums[j])){
                    continue;
                }
                    int y = nums[i]+nums[j];
                    int x = 0-y;
                for(int k = j+1;k<nums.length;k++){
                    if(x==nums[k]){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(x);
                        //HashSet<Integer>
                        List<Integer> hs  = new ArrayList<Integer>();
                        hs.add(nums[i]);
                        hs.add(nums[j]);
                        hs.add(x);
                        dic.add(hs);
                        lists.add(list);
                         break;
                    }
                }
            }
        }
        
        return lists;
    }
    public static boolean repeated(HashSet<List<Integer>> dic,int x ,int y) {
        for (List<Integer> hashSet : dic) {
            boolean flagx= false;
            boolean flagy= false;
            for (Integer integer : hashSet) {
                if((integer == x) &&(!flagx)){
                    flagx= true;
                    continue;
                }else if((integer == y)&&(!flagy)){
                    flagy= true;
                    continue;
                }
//                if(flagx&&flagy){
//                    return true;
//                }
            }
            if(flagx&&flagy){
                return true;
            }

        }
        return false;
    }
}
