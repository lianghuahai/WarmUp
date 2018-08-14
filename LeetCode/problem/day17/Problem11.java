package problem.day17;

public class Problem11 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*  two pointers  i -> 0 , j-> array.length-1
     *    globalmax store the maxArea =  Math.max(global, Math.min(array[i],array[j]) * (j-i+1))
         if(array[i]>array[j])  j-- else i++
     */  
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea= 0;
        while(left < right){
            int lowheight = height[left]<height[right]? height[left]:height[right];
            maxArea = maxArea>lowheight * (right -left)?maxArea:lowheight * (right -left);
            if(height[left]>=height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}
