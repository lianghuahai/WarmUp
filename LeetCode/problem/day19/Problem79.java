package problem.day19;

public class Problem79 {
    /*
    dfs 
    */
    public boolean exist(char[][] board, String word) {
      if(word==null || word.equals("")|| board ==null || board.length==0 || board[0].length==0){
          return false;
      } 
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
             if(dfs(board,word,i,j,0)) return true;
          }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i ,int j, int position){
        if(position == word.length())return true;
        else if(i<0 || i>=board.length || j<0 || j>=board[0].length)return false;// out of boundary
        if(board[i][j]==word.charAt(position++)){
            char ch = board[i][j];
            board[i][j]='$';
            boolean res =  dfs(board,word,i,j-1,position)
                        || dfs(board,word,i,j+1,position)
                        || dfs(board,word,i-1,j,position)
                        || dfs(board,word,i+1,j,position);
            board[i][j]=ch;
            return res;
        }
        
        return false;
    }
}
