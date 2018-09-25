package problem.day4;

public class Problem42 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /* we have to have leftmax  and rightmax to record the max value on the left and right
     * height[], and  scan from  left =0  to  right = height.length-1
     * while(left<right){
     *    if(  height[left]<height[right]){
     *          left++;
     *    }else{
     *          right--;
     *    }
     * }
     
     res+=leftmax-height[left] ;//how much water height[left] can contains
      look at below:
          *       *
          *   *   *
          *   *   *
   index= 0 1 2 3 4
      when leftmax = 3, rightmax= 2,  left = 1, right = 4, how much water can contain of value 0 to leftmax 3?  it is 3!
      and left = 2, it is 3-2 =1 ! and left =3,  it is 3-0=3!  so total = 3+1+3  =7!
     */
    public int trap(int[] height) {
        int left=0,right=height.length-1,leftmax=0,rightmax=0,res=0;
        while(left<right){
            if(height[left]<height[right]){ //we have to look on the left, because how much water depends on smaller height
                leftmax= Math.max(leftmax,height[left]);// update leftmax
                res+=leftmax-height[left] ;//how much water height[left] can contains
                left++;
            }else{
                rightmax= Math.max(rightmax,height[right]);
                res+=rightmax-height[right] ;
                right--;
            }
        }
        return res;
    }
}
