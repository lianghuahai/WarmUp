package problem.day1;

public class Problem4 {

    public static void main(String[] args) {
        int[] a = new int[]{};
        int[] c = new int[]{2,3};  // 1 2 3 4 7 8 , (3+4)/2 = 3.5
//        double x = findMedianSortedArrays(a,c);
        double x = findMedianSortedArrays1(a,c);
        System.out.println(x);

    }
    // my idea
    /*   https://blog.csdn.net/chen_xinjia/article/details/69258706
    L1   R1
    nums1  :  1 3 | 5 6     
    imin=0       imax = 4 
    
    nums2  :  2 4 5| 6 7 8 
        L2     R2
    i point to the smaller length of array which is m
    j point to another
    the cutting point of i and j should make sure that  #(L1+L2) = #(R1 +R2) or difference between 1
    L1<=R2 --->  3<=6
    L2<=R1 --->   5<=5
    then output
    n= nums1.len=4, m= nums1.len=6(m < n)  total.len = 10;  mid = (m+n)/2=5
    the key point is corner case, it is done by elegant!!!!!!!! such as {}empty array and {1,2,4}
    
    
    */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(n<m ){
            int[] temp = nums1;
            nums1 = nums2;
            nums2= temp;
            int leng = m;
            m= n;
            n=leng;
        }
        
        int imin = 0, imax = m, mid = (m+n+1)/2;  //  +1?
        while(imin<=imax){
            int i = (imax+imin)/2;
            int j = mid - i;
            if(i<imax &&nums1[i]<nums2[j-1]){  //i is small, cutting point moves to right, i<imax ensures imin++ not over-boundary 
                imin++;
            }else if(i>imin && nums1[i-1]>nums2[j]){ //i is large ,cutting point moves to left ,i<imin ensures imax-- not over-boundary 
                imax--;
            }else{
                int leftmost = 0;
                if(i==0){leftmost= nums2[j-1];}
                else if(j==0){leftmost = nums1[i-1];}
                else{leftmost= Math.max(nums2[j-1],nums1[i-1]);}
                if((m+n)%2==1){
                    return leftmost;
                }
                
                int minright=0;
                if(i==m){minright=nums2[0];}
                else if(j==n){minright=nums1[0];}
                else{minright= Math.max(nums2[0],nums1[0]);}
                return (leftmost+minright)/2.0;
            }
          }  
        return 0.0;
       }
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;       
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
