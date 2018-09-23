package problem.day25;

public class Problem908 {
    public static void main(String[] args) {
        smallestRangeI(new int[]{1},0);
    }
    public static int smallestRangeI(int[] A, int K) {
        int diff = 0, result = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        //find min and max in A
        for(int i=0; i<A.length; i++) {
            if(min > A[i]) min = A[i];
            if(max < A[i]) max = A[i];
        }
        
        diff = max - min;
        result = diff - (K*2);
        return (result <= 0) ? 0 : result;
    }
}
