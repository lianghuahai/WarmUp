package problem.day21;

public class Problem130 {
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0)return ;
        int row =board.length-1,col=board[0].length-1;
        
        for (int i = 0; i <=row; i++) {
            if (board[i][0] == 'O')
                check(board, i, 0);
            if (board[i][col] == 'O')
                        check(board, i, col);   
        }
        for (int j = 0; j <=col; j++) {
            if (board[0][j] == 'O')
                check(board, 0, j);
            if (board[row][j] == 'O')
                check(board, row, j);   
        }
        
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='#')board[i][j]='O';
            }
        }
        
    }
    public void check(char[][] board ,int i,int j){
        if(j<0 || j>=board[0].length||i<0 || i>=board.length)return;
        if (board[i][j] == 'O')
                board[i][j] = '#';
        if(i>1&& board[i-1][j] == 'O'){
            check(board,i-1,j);
        }
        if(j>1&& board[i][j-1] == 'O'){
            check(board,i,j-1);
        }
        if(i<board.length-1&& board[i+1][j] == 'O'){
            check(board,i+1,j);
        }
        if(j<board[0].length-1&& board[i][j+1] == 'O'){
            check(board,i,j+1);
        }
        
    }
}
