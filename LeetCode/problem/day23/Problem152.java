package problem.day23;

public class Problem152 {
    public static void main(String[] args) {
        maxProduct(new int[]{2,3,-2,4});
    }
  //dp method 1, time O(n) space O(n)
//    f[i] means maximum product that can be achieved ending with i
//    g[i] means minimum product that can be achieved ending with i
    public int maxProduct2(int[] A) {
          if (A == null || A.length == 0) {
              return 0;
          }
          int[] f = new int[A.length];
          int[] g = new int[A.length];
          f[0] = A[0];
          g[0] = A[0];
          int res = A[0];
          for (int i = 1; i < A.length; i++) {
              f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
              g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
              res = Math.max(res, f[i]);
          }
          return res;
        }
    //dp method 2, time O(n) space O(1)
    public static int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
