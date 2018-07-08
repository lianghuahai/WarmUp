package problem.day8;

import java.util.PriorityQueue;
import java.util.Random;

public class Problem215 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int []nums = new int[]{1,2,3,4,5,6,7,8,9};
        int x = findKthLargest2(nums,2);
        System.out.println(x);
//        for(int ind = 0; ind < nums.length; ind++) {
//            System.out.print(nums[ind]);
//        }
//        System.out.println();
//        ramdon(nums);
//        for(int ind = 0; ind < nums.length; ind++) {
//            System.out.print(nums[ind]);
//        }
    }
    
    //using  PriorityQueue
    public static int findKthLargest2(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    
    
    //shuffle the array
    public static void ramdon(int[]a){
         Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
             int r = random.nextInt(ind );
            int t=a[ind];
            a[ind]=a[r];
            a[r]=t;
        }
}
    //mine
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        k = nums.length- k;
        while(left<right){
            int index = partition(nums,left,right);
            if(index <k){
                left++;
            }else if(index >k){
                right--;
            }else{
                return nums[index];
            }
        }
        return -1;
    }
    
    
    public static int partition(int[] nums, int left ,int right) {
        int pivot = nums[right];
        int i = left;
        int j = right;
        while(i<j){  //3,2,3,1,2,4,5,5,6
            while(i<j && nums[i]<=pivot){i++;}
            while(i<j && nums[j]>=pivot){j--;}
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        int temp = nums[i];
        nums[i]=nums[right];
        nums[right]=temp;
        return i;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //others
    public static int findKthLargest1(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition1(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition1(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }
}
