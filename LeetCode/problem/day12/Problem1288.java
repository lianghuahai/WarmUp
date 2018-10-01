package problem.day12;

import java.util.HashMap;

public class Problem1288 {
    public static void main(String[] args) {
      System.out.println(longestConsecutive(new int[]{12,3,4,5,6}));
  }
    public static int longestConsecutive(int[] num) {
        /* idea:利用left和right计数，有多少个相邻
         * 
         * 
         */
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);
                
                // keep track of the max length 
                res = Math.max(res, sum);
                
                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

}
