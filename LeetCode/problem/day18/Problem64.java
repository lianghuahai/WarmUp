package problem.day18;

public class Problem64 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*
     *  grid[i][j] = min(grid[row-1][col],grid[row][col-1])   +grid[row][col];
     *  
     */
    public int minPathSum(int[][] grid) {
        for(int row = 0;row<grid.length;row++){
            for(int col = 0;col<grid[0].length;col++){
                 if(row==0 && col !=0)grid[row][col]=grid[row][col]+grid[row][col-1];
                 if(row!=0 && col ==0)grid[row][col]=grid[row][col]+grid[row-1][col];
                 if(row!=0 && col !=0)grid[row][col]=Math.min(grid[row-1][col],grid[row][col-1])+grid[row][col];
           } 
        }
      return grid[grid.length-1][grid[0].length-1];
  }
}
