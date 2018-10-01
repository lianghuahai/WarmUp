package problem.day12;

public class Problem123 {
/*    i   0 1 2 3 4 5 6 7   dp[i][j]means j transaction in  i-th day
          2 5 7 1 4 3 1 3   itinial table: dp[0][0->j]means any transaction in 0th-day  profit=0
     j  0 0 0 0 0 0 0 0 0                  dp[0->i][0]means not transaction in anyday profit=0
        1 0 3 5 5 5 5 5 5          dp[i][j] =max (  dp[i][j-1]  , price[j]-price[m] +dp[i-1][m] )    m=0 -> j-1
        2 0 3 5 5 8 8 8 8     Eg: j=3, i=2
        3 0 3 5 5 8 8 8 8            m=0 dp[1][0]-price[0]+price[3]   maxDiff=max(maxDiff,dp[1][0]-price[0])                      
                                     m=1 dp[1][1]-price[1]+price[3]   maxDiff=max(maxDiff,dp[1][1]-price[1])
                                     m=2 dp[1][2]-price[2]+price[3]   maxDiff=max(maxDiff,dp[1][2]-price[2])
                                  j=4, i=2                       
                                     m=0 dp[1][0]-price[0]+price[4]                        
                                     m=1 dp[1][1]-price[1]+price[4]
                                     m=2 dp[1][2]-price[2]+price[4]  //the same as j=3 ,i=2
                                  we only have to compare dp[1][3]-price[2] and maxDiff from previous
                                     m=3 dp[1][3]-price[2]+price[4]
                              Optimization:    dp[i][j] =max ( dp[i][j-1] ,price[j]+maxDiff)
                                                              maxDiff=(maxDiff,dp[i-1][j]-price[j])     
*/
    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(maxProfit(new int[]{1,2,3,5,10}));
//        System.out.println(maxProfit(new int[]{2,1,4}));
    }
    public static int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        //应该从hold 1开始往上看，hold1等于第一天买。reles1第一天卖
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
  //O(K N )
    public static int maxProfit1(int[] prices) {
        if(prices.length==0)return 0;
      int dp[][]=new int[3][prices.length];
           for(int i =1;i<3;i++){
               int maxDiff=0-prices[0];
               for(int j=1;j<prices.length;j++){
                    dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxDiff);
                    maxDiff = Math.max(maxDiff,dp[i-1][j]-prices[j]);//calculate maxDiff for next computation
               }
           }

           return dp[2][prices.length-1];
    }
    //O(K N ^2)
    public static int maxProfit2(int[] prices) {
        if(prices.length==0)return 0;
        int dp[][]=new int[3][prices.length];
        int maxDiff=0;
        for(int i =1;i<3;i++){
            for(int j=1;j<prices.length;j++){
                // dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxDiff);
                int max= 0;
                for(int k=0;k<j; k++){
                    max=Math.max(max,prices[j]-prices[k]+dp[i-1][k]);
                }
                dp[i][j]=Math.max(dp[i][j-1],max);
                
                //maxDiff = Math.max(maxDiff,dp[i-1][j-1]-prices[j-1]);
            }
        }
        
        return dp[2][prices.length-1];
    }

}
