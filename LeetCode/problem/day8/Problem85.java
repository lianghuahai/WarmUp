package problem.day8;

import java.util.Arrays;
import java.util.Stack;

public class Problem85 {
    public static void main(String[] args) {
        maximalRectangle1(new char[][]{{'1' ,'0', '1', '0', '0'},{'1' ,'0', '1', '1' ,'1'},{'1', '1' ,'1' ,'1' ,'1'},{'1' ,'0', '0' ,'1' ,'0'}});
    }
    
    // 84 using stack
    /*  1 1 0 1 0 1     =>    1 1 0 1 0 1
        0 1 0 0 1 1     =>    0 2 0 0 1 2    遇到0就重置为0，遇到1就 dp[j]++
        1 1 1 1 0 1     =>    1 3 1 1 0 3
        1 1 1 1 0 1     =>    0 4 2 2 0 4
          循环每一层row by row，然后 用一个数组记录，遇到0就重置为0，遇到1就 dp[j]++, 然后就可以调用84题的method得到最大值
          
    
    */
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[] height = new int[matrix[0].length];
        int result = -1;
        for(int i = 0; i < matrix.length; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        
        return result;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }    

    public int largestInLine(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
    
    
    
    /*
    1 0 1 0 0
    1 0 1 1 1 
    1 1 1 1 1 
    1 0 0 1 0
    
    left: initial 0 0 0 0 0 
 -> 0 0 2 0 0
    0 0 2 2 2
    0 0 2 2 2
    0 0 0 3 0
    right: initial 5 5 5 5 5 rightp=5,
    1 5 3 5 5 <-
    1 5 3 5 5
    1 5 3 5 5
    1 5 5 4 5
    
    height:
->  1 0 1 0 0
    2 0 2 1 1
    3 1 3 2 2
    4 0 0 3 0
   */
    //dp
    public static int maximalRectangle1(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)return 0;
        int n = matrix[0].length;
        int []left= new int[n];
        int []right= new int[n];
        int []height= new int[n];
        Arrays.fill(right, n);
        int res=0;
        for(int i=0;i<matrix.length;i++){
            int leftp=0,rightp=n;
            //height
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1')height[j]++;
                else height[j]=0;
            }
            //left
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1'){
                    left[j]=Math.max(left[j], leftp);
                }else{
                    left[j]=0;
                    leftp=j+1;
                }
            }
          //right 1 0 1 0 0
            for (int j = n-1; j >=0; j--) {
                if(matrix[i][j]=='1'){
                    right[j]=Math.min(right[j], rightp);
                }else{
                    right[j]=n;
                    rightp=j;
                }
            }
            //循环整个数组 找出 最大值
            for (int j = 0; j < n; j++) {
                res= Math.max(res, (right[j]-left[j])*height[j]);
            }
        }
        return res;
    }
}
