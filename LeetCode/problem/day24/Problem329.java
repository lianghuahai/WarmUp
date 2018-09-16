package problem.day24;

public class Problem329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int [][] cache= new int[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len=dfs(matrix,cache,i,j,m,n,Integer.MIN_VALUE);
                res= Math.max(res,len);
            }
        }
        return res;
    }
    public int dfs(int[][] matrix,int [][] cache,int i,int j,int m,int n,int value){
        if(i<0||j<0 || i>=m||j>=n || value>=matrix[i][j])return 0;
        if(cache[i][j]!=0)return cache[i][j];
        value = matrix[i][j];
        int left =dfs(matrix,cache,i,j-1,m,n,value)+1;
        int right =dfs(matrix,cache,i,j+1,m,n,value)+1;
        int up =dfs(matrix,cache,i-1,j,m,n,value)+1;
        int down =dfs(matrix,cache,i+1,j,m,n,value)+1;
        int max=Math.max(Math.max(left,right),Math.max(up,down));
        cache[i][j]=max;
        return max;
    }
}
