package problem.day23;

public class Problem198 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    } //          0      1      2      3      4
      /*  nums:   3      1      5      2      0      7      4
        dp    :   3      3      ?
         求dp[2]：由于dp[1]=dp[0] ，说明在求dp[1]时没有用到nums[1]，所以，不论nums[2]多大，直接加上dp[1]或dp[0] ，dp[2]  =  dp[1] + nums[2]。
         //        0      1      2      3      4
          nums :   3      1      5      2      0      7      4
        dp     :   3      3      8      ?
           求dp[3]：由于dp[2]>dp[1] ，说明在求dp[2]时用到了nums[2]，因为nums[3]不能和nums[2]同时出现，
            所以要判断dp[1]+nums[3]和dp[2]的大小。dp[3] = max(dp[1]+nums[3],dp[2])
*/
    //dp time O(n)space  O(n)
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0)return 0;
        if(len==1)return nums[0];
        int []dp=new int[len];
        dp[0]=nums[0];
        dp[1]=nums[0]>nums[1]?nums[0]:nums[1];
        for(int i=2;i<len;i++){
            if(dp[i-1]==dp[i-2]){
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
        }
        return dp[nums.length-1];
    }    
    //dp time O(n)   improvement  space  O(n)->   space  O(1)
    public int rob2(int[] nums) {
        //        [1,2,3,1]
        //first    1   4   
        //second   2   
        //res      2   4
        int len = nums.length;
        if(len==0)return 0;
        if(len==1)return nums[0];
        int []dp=new int[len];
        int first=nums[0];
        int second =nums[0]>nums[1]?nums[0]:nums[1];
        int res = Math.max(first,second);
        for(int i=2;i<len;i++){
            if(first==second){
                res=first+nums[i];
                second=res;
            }else{
                res=Math.max(first+nums[i],second);
                first =second;
                second=res;
            }
        }
        return res;
    }    


}
