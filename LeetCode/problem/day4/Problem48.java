package problem.day4;

public class Problem48 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static void rotate(int[][] matrix) {
        //1.   先以左顶角斜线对折，再以中间竖线对折  就可以rotate了
        
        
        
        //2. idea 
     //    1 - - 4         7 - - 1      
//         - - - -    =>   - - - -      
//         - - - -    =>   - - - -   
//         7 - - 5         5 - - 4            
    //
        int len = matrix.length;
        for(int i=0;i<len/2;i++){
            for(int j = i;j<len-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[len-j-1][i];
                matrix[len-j-1][i]=matrix[len-i-1][len-j-1];
                matrix[len-i-1][len-j-1]=matrix[j][len-i-1];
                matrix[j][len-i-1]=temp;
            }
        }
    }
}
