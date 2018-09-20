package problem.day8;

import java.util.Arrays;

public class Problem85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)return 0;
        int n = matrix[0].length;
        int []left= new int[n];
        int []right= new int[n];
        int []height= new int[n];
        Arrays.fill(right, n);
        int res=0;
        for(int i=0;i<matrix.length;i++){
            int leftp=0,rightp=n;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1')height[j]++;
                else height[j]=0;
            }
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1'){
                    left[j]=Math.max(left[j], leftp);
                }else{
                    left[j]=0;
                    leftp=j+1;
                }
            }
            for (int j = n-1; j >=0; j--) {
                if(matrix[i][j]=='1'){
                    right[j]=Math.min(right[j], rightp);
                }else{
                    right[j]=n;
                    rightp=j;
                }
            }
            for (int j = 0; j < n; j++) {
                res= Math.max(res, (right[j]-left[j])*height[j]);
            }
        }
        return res;
    }
}
