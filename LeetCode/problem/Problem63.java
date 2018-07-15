package problem;

public class Problem63 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        //initial  array with nums[i][0]=1; nums[1][0]=1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int [][]nums= new int [m][n]; 
        boolean flag= false;  
        for(int i =0;i<m;i++){
            if(obstacleGrid[i][0]==1||flag){  // as long as one of the gird is stuck, the rest of grids will be stuck
                nums[i][0]=0;
                flag=true;
            }else{nums[i][0]=1;}
        }
        flag= false;
        for(int i =0;i<n;i++){
            if(obstacleGrid[0][i]==1||flag){
                nums[0][i]=0;
                flag=true;
            }else{nums[0][i]=1;}
        }      
        //loop to the end
        for(int i = 1;i<m;i++){
            for(int j =1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    nums[i][j]=0;
                }else{
                     nums[i][j]=  nums[i-1][j]+ nums[i][j-1];
                }
            }
        }
        return nums[m-1][n-1];
    }
}
