package problem.day25;

import java.util.Arrays;

public class Problem910 {
    public static void main(String[] args) {
        smallestRangeII(new int[]{1,3,6},3);
    }
    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, mx = A[n - 1], mn = A[0], res = mx - mn;
        for (int i = 0; i < n - 1; ++i) {
            mx = Math.max(mx, A[i] + 2 * K);
            mn = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }

}
