package problem.day18;

public class Problem72 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public int minDistance(String word1, String word2) {
        //  dp[i][j] represents minDistance transform  word1 from 0 to i  into word2  from 0 to j
        /*    a b c d                a b c d
            0 1 2 3 4               0 1 2 3 4 
         a  1         =>         a  1 0 1 2 3       
         e  2                    e  2 1 1 2 3
         f  3                    f  3 2 2 2 3
        */
        // dp[i][j] = min(insert,delete,replace)
        //          insert dp[i][j] = dp[i][j-1] +1;      
        //   min    delete dp[i][j] = dp[i-1][j-1] +1; 
        //          replace dp[i][j] = dp[i-1][j] +1;  
        
        int l1=word1.length();
        int l2= word2.length();
        int[][]dp  = new int[l1+1][l2+1];
        for(int i =1;i<=l1;i++){
            dp[i][0]=i;
        }
        for(int i =1;i<=l2;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] ;  
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                }
            }
        }
        return dp[l1][l2];
    }
}
