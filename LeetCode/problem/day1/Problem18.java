package problem.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {

    public static void main(String[] args) {
//        int[]num = new int[]{1,0,-1,0,-2,2};
        int[]num = new int[]{0,0,0,0,};
        List<List<Integer>> fourSum = fourSum(num,0);
        // TODO Auto-generated method stub
        System.out.println(fourSum);

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<=3){
            return null;
        }
        Arrays.sort(nums);
        
        //-2 -1 0 0 1 2
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0;i<nums.length-3;i++){
            for(int j=nums.length-1; j>i+2; j--){
//                for(int j=i+2;j<nums.length;j++){
                int twosum = nums[i]+nums[j];
                int left = i+1; 
                int right = j-1;
                while(left<right){
                    int x = nums[left]+nums[right];
                    x=twosum+x;
                    if(x==target){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        list.add(temp);
                        right--;
                        left++;
                        while( nums[left-1]== nums[left] && left<=right){left++;}
                        while(nums[right]== nums[right+1]&& left<=right){right--;}
                    }else if(x<target){
                        left++;
                    }else{
                        right--;
                    }
                }  
                while( nums[j-1]== nums[j] && j>1){j--;}
            } 
            while( nums[i+1]== nums[i] && i<nums.length-2){i++;}
        }
        return list;
        
        
    }
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
                return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
                return res;

        int i, z;
        for (i = 0; i < len; i++) {
                z = nums[i];
                if (i > 0 && z == nums[i - 1])// avoid duplicate
                        continue;
                if (z + 3 * max < target) // z is too small
                        continue;
                if (4 * z > target) // z is too large
                        break;
                if (4 * z == target) { // z is the boundary
                        if (i + 3 < len && nums[i + 3] == z)
                                res.add(Arrays.asList(z, z, z, z));
                        break;
                }

                threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
}

/*
 * Find all possible distinguished three numbers adding up to the target
 * in sorted array nums[] between indices low and high. If there are,
 * add all of them into the ArrayList fourSumList, using
 * fourSumList.add(Arrays.asList(z1, the three numbers))
 */
public static void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                int z1) {
        if (low + 1 >= high)
                return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
                return;

        int i, z;
        for (i = low; i < high - 1; i++) {
                z = nums[i];
                if (i > low && z == nums[i - 1]) // avoid duplicate
                        continue;
                if (z + 2 * max < target) // z is too small
                        continue;

                if (3 * z > target) // z is too large
                        break;

                if (3 * z == target) { // z is the boundary
                        if (i + 1 < high && nums[i + 2] == z)
                                fourSumList.add(Arrays.asList(z1, z, z, z));
                        break;
                }

                twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

}

/*
 * Find all possible distinguished two numbers adding up to the target
 * in sorted array nums[] between indices low and high. If there are,
 * add all of them into the ArrayList fourSumList, using
 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
 */
public static void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                int z1, int z2) {

        if (low >= high)
                return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
                return;

        int i = low, j = high, sum, x;
        while (i < j) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                        fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                        x = nums[i];
                        while (++i < j && x == nums[i]) // avoid duplicate
                                ;
                        x = nums[j];
                        while (i < --j && x == nums[j]) // avoid duplicate
                                ;
                }
                if (sum < target)
                        i++;
                if (sum > target)
                        j--;
        }
        return;
}
}
