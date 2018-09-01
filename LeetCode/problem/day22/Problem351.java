package problem.day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem351 {

    public static void main(String[] args) {
        intersect(new int[]{1,2,2},new int[]{2,1,1,1,2});

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        int c=0;
        Map<Integer,Integer> map= new HashMap();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            int num = map.getOrDefault(nums2[i],0);
            if(num>0 ){
                list.add(nums2[i]);
                map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);
            }
        }
        int []res = new int[list.size()];
        for (int i=0;i<res.length;i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
