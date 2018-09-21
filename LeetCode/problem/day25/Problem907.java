package problem.day25;

import java.util.Stack;

public class Problem907 {

    public static void main(String[] args) {
        String s ="";
        long a = Long.parseLong(s);
        sumSubarrayMins(new int[]{3,1,2,4});

    }
    public static int sumSubarrayMins(int[] A) {
        int res = 0, n = A.length, mod = (int)1e9 + 7;
        int[] left = new int[n], right = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
       /* For 
        *               [3,1,2,4] as example:
            left + 1  = [1,2,1,1]               
            right + 1 = [1,3,2,1]
                    f = [1,6,2,1]=left[i] * right[i]
              eg: A[i]=1;  left: 31,1  right: 1,12,124 => cartesian product 31(1,12,124) and 1(1,12,124)=> 31,312,3124 ,1,12,124
           res = 3 * 1 + 1 * 6 + 2 * 2 + 4 * 1 = 17
          
left[i], the length of strict bigger numbers on the left of A[i], left[i] + 1 equals to the number of subarray ending with A[i],
right[i], the length of bigger numbers on the right of A[i].right[i] + 1 equals to the number of subarray starting with A[i],
            */
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i])
                count += s1.pop()[1];
            s1.push(new int[] {A[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i])
                count += s2.pop()[1];
            s2.push(new int[] {A[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * left[i] * right[i]) % mod;
        return res;
    }
}
