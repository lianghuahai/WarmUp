package problem.day23;

import java.util.PriorityQueue;

public class Problem378 {

    public static void main(String[] args) {
        int [][]a=new int[][]{{ 1,  5,  9},{10, 11, 13},{12, 13, 15}};
        kthSmallest2(a,5);
    }
    public static int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0 ||matrix[0].length==0)return 0;
         int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> a-b);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < matrix[0].length; j++){
                 pq.offer(matrix[i][j]);
            }
        }
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.poll();
    }
}
