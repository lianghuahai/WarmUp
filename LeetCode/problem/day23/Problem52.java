package problem.day23;

public class Problem52 {
    int res =0;
    public int totalNQueens(int n) {
        if(n<=0)return res;
        dfs(new int[n],0);
        return res;
    }
    public  void dfs( int[]queens,int row){
        if(row==queens.length){
            res++;
            return;
        }
        for(int i=0;i<queens.length;i++){
            queens[row]=i;  //the reason we dont have to clear
            if(isValid(queens,row)){
                dfs(queens,row+1);
            }
          //the reason we dont have to clear queens[row]here is because we just check i to row, 
         //eg:  [1,3,4,5]  the row=2,  we dont have to bother index 3(value=5) because we avoid checking it by loop for(int i=0;i<queens.length;i++){
        }
    }
    public  boolean isValid(int[]queens,int row){
        for(int i=0;i<row;i++){     //
            if(queens[i]==queens[row]){// col  check, queens[i](every row) means to check every row before variable 'row'
                return false;
            }else if(Math.abs(queens[row]-queens[i])==Math.abs(i-row)){ //diagonal check
                //queens[row]-queens[i])  means  difference between col
                //Math.abs(i-row)means  difference between row                  they must be same!
                return false;
            }
        }
        return true;
    }
}
