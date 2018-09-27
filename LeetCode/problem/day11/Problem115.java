package problem.day11;

public class Problem115 {
    public int numDistinct(String s, String t) {
        /*         s[j] t[i]
                r a b b
              0 1 2 3 4
            0 1 1 1 1 1      initial table: dp[0][0 -> j-1]  =1 , becasue t="" empty string, only 1 possible(delete all)
          r 1 0                             dp[0->i][0]  =0     , becasue t has character,but s="" is empty string, no possible
          a 2 0
          b 3 0
                    rule:  only two possible
                         s[j]!=t[i] : dp[i][j] =dp[i][j-1]  not equal, just delete it, the total number is the same as before,
                         s[j]==t[i] : dp[i][j] =dp[i][j-1] +dp[i-1][j-1], two choice, not taking it dp[i][j-1], same as above s[j]!=t[i]
                         taking it dp[i-1][j-1], eg:  s="abb"  t="ab"  is the same as , "ab" and "a"
        */
                if(t.length()>s.length())return 0;
                int [][]dp = new int[t.length()+1][s.length()+1];
                for(int j=0;j<s.length();j++)dp[0][j]=1;
                for(int j=1;j<t.length();j++)dp[j][0]=0;
                for(int i=1;i<=t.length();i++){
                    for(int j=1;j<=s.length();j++){
                        dp[i][j] =dp[i][j-1];
                        if(s.charAt(j-1)==t.charAt(i-1)){
                            dp[i][j] +=dp[i-1][j-1];
                        }
                    }
                }
                return dp[t.length()][s.length()];
            }
}
