package problem.day24;

import java.util.Arrays;

public class Problem322 {
    public static void main(String[] args) {
        coinChange3(new int[]{1,2,5},11);
    }
  //n number of coins
    //m desired amount
    //dp[i][j] represents min number of coins needed to make up amout j with only [i to n-1]
    /*  dp[i][j] = min(dp[i+1][j-k*coins[i]]+k) 0<=k<=j/coins[i]
     * 
     * 
     */
    
  //O(n*m)  O(n)
    public static int coinChange1(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        
        for(int i=coins.length-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                if(j>=coins[i]){
                    int prev=dp[j-coins[i]];
                    if(prev<Integer.MAX_VALUE){
                        dp[j]=Math.min(dp[j],prev+1);
                    }
                }    
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
  //O(n*m)  O(n*m)
    /*  dp[i][j]=min( dp[i+1][j],           //0 coins
     *                dp[i+1][j-coins[i]]+1,  //1coins
     *                dp[i+1][j-2*coins[i]] +2, //2coins
     *                 .. )
     * (1)  found rule belows:              
     *  dp[i][j-coins[i]]= min(
     *                          dp[i+1][j-coins[i]],
     *                          dp[i+1][j-2*coins[i]]+1
     *                          ) 
     *    provement:                      
     * dp[i][j]=min( dp[i+1][j],           //0 coins
     *             min(           these part is the same as (1)
     *                dp[i+1][j-coins[i]],  //1coins  
     *                dp[i+1][j-2*coins[i]] +1, //2coins 
     *                 .. )  +1  
     *              )                                       
     */
    public static int coinChange2(int[] coins, int amount) {
        int [][] dp = new int [coins.length+1][amount+1];
        Arrays.fill(dp[coins.length],Integer.MAX_VALUE);
        dp[coins.length][0]=0;
        
        for(int i=coins.length-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                dp[i][j]=dp[i+1][j];
                if(j>=coins[i]){
                    int prev=dp[i][j-coins[i]];
                    if(prev<Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],prev+1);
                    }
                }
                
            }
        }
        return dp[0][amount]==Integer.MAX_VALUE?-1:dp[0][amount];
    }
    //O(n*m^2)  O(n*m)
    public static int coinChange3(int[] coins, int amount) {
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
