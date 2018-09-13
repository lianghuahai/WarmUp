package problem.day24;

import java.util.Arrays;

public class Problem322 {
    public static void main(String[] args) {
        coinChange(new int[]{1,2,5},11);
    }
  //n number of coins
    //m desired amount
    //dp[i][j] represents min number of coins needed to make up amout j with only [i to n-1]
    
    //O(n*m^2)  O(n*m)
    public static int coinChange(int[] coins, int amount) {
        int [][] dp = new int [coins.length+1][amount+1];
        Arrays.fill(dp[coins.length],Integer.MAX_VALUE);
        dp[coins.length][0]=0;
        
        for(int i=coins.length-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                dp[i][j]=dp[i+1][j];
                int maxK=j/coins[i];
                for(int k=1;k<=maxK;k++){
                    int prev=dp[i+1][j-k*coins[i]];
                    if(prev<Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],prev+k);
                    }
                }
            }
        }
        return dp[0][amount]==Integer.MAX_VALUE?-1:dp[0][amount];
    }
    //O(n*m^2)  O(n*m)
}
