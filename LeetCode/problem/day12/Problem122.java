package problem.day12;

public class Problem122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 7, 2, 3, 6, 7, 6, 7}));
    }
    //  1 3 1 -2 1  = 1+3+1+1 = max profit 6
    // 1 2 5 6  4 5        eg:  1 2 5  :  (2-1 + 5-2)  =  (5-1) , 就像线段求和一样  |__|__| = |___|
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
