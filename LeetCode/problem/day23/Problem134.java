package problem.day23;


public class Problem134 {
    /* idea is , 
     * 1.  if starting from i to i+1, i+2 ... j ,remain<0  we dont have to go back, just start from j+1 
     *    位置i肯定是正积累，那么，如果从位置i+1开始走更加没法走完全程了(remain反而小了)，因为没有位置i的正积累了。同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。
     * 2. 为什么只需要走一遍，因为如果remain<0 我们只需要记录一个debt 到底欠了多少， 到最后只需要remain+debt就知道 结果了
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0,debt=0,remain=0;
        
        for(int i=0;i<gas.length;i++){
            remain+=gas[i]-cost[i];
            if(remain<0){
                debt+=remain;
                start=i+1;
                remain=0;
            }
        }
        return remain + debt >= 0?start:-1;
    }
}
