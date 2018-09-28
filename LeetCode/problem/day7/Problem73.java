package problem.day7;

public class Problem73 {
    /*
    1 1 0 1         1 0 0 1
    1 1 1 1    =>   1 1 1 1
    1 0 1 1         0 0 1 1
    we are using  first row and col to record the status of 0;
    first loop matrix  and record the status
    second loop from [1][1] to set up 0, if(matrix[i][0]||matrix[0][j] )  
    last, set up first row  and col  using boolean flag.
    */
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean row = false;
        boolean col = false;
        //record the status
        for (int i =0;i<rows;i++){
            for (int j =0;j<cols;j++){
                if(matrix[i][j]==0){  // [1][2]
                    matrix[i][0]=0;   // [1][0]=0
                    matrix[0][j]=0;   // [0][2]=0
                    if(i==0) row=true;
                    if(j==0) col=true;
                }
           }
        }
        //set up 0
        for(int i =1;i < rows;i++){
            for (int j =1;j<cols;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(row){
            for (int i =0;i<cols;i++){
                    matrix[0][i]=0;
            }
        }
        if(col){
            for (int i =0;i<rows;i++){
                    matrix[i][0]=0;
            }
        }
        
    }

}
