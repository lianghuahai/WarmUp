package problem.day23;

public class Problem200 {
    //key point!!!!
    //set all of '1' ='0' using dfs()!! for one island in dfs()
    
    //dfs
    public int numIslands(char[][] grid) {
        int res=0;
        int row=grid.length;
        if(row==0)return 0;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i,int j){
        if(i<0||j<0 ||i>=grid.length|| j>=grid[0].length ||grid[i][j]=='0')return;
         grid[i][j]='0';
         dfs(grid,i-1,j);
         dfs(grid,i+1,j);
         dfs(grid,i,j-1);
         dfs(grid,i,j+1);
    }
}
