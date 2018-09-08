package problem.day23;

import java.util.ArrayList;
import java.util.List;

public class Problem51 {
    public static void main(String[] args) {
        solveNQueens(4);
    }
    //backtracking     queens=[0,1,2,1]   index means row, and value means col; eg, index 3, value 2, means row3,col2 has Q
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n<=0)return res;
        dfs(res,new int[n],0);
        return res;
    }
    public static void dfs(List<List<String>> res, int[]queens,int row){
        if(row==queens.length){
            addSolution(res,queens);
            return;
        }
        for(int i=0;i<queens.length;i++){
            queens[row]=i;  //the reason we dont have to clear
            if(isValid(queens,row)){
                dfs(res,queens,row+1);
            }
          //the reason we dont have to clear queens[row]here is because we just check i to row, 
         //eg:  [1,3,4,5]  the row=2,  we dont have to bother index 3(value=5) because we dont check it as the loop for(int i=0;i<queens.length;i++){
        }
    }
    public static void addSolution(List<List<String>> res, int[]queens){
        List<String> list = new ArrayList<String>();
        for(int i =0;i<queens.length;i++){
            StringBuilder sb =new StringBuilder();
            for(int j=0;j<queens.length;j++){
                if(queens[i]==j){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
        
    }
  /*  queens=[0,0,0,0] row=0
   * 
      queens=[0,0,0,0] row=1
      queens=[0,1,0,0] row=1
      queens=[0,2,0,0] row=1
      
      queens=[0,2,0,0] row=2
      queens=[0,2,1,0] row=2
      queens=[0,2,2,0] row=2
      queens=[0,2,3,0] row=2  
      return 
      ----------------------------------------
      queens=[1,0,0,0] row=0
      queens=[1,0,0,0] row=1
      queens=[1,1,0,0] row=1
      queens=[1,2,0,0] row=1
      queens=[1,3,0,0] row=1
      
      queens=[1,3,0,0] row=2
      
      queens=[1,3,0,0] row=3
      queens=[1,3,0,1] row=3
      queens=[1,3,0,2] row=3 true addSolution
     */
    public static boolean isValid(int[]queens,int row){
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
