package problem.day13;

import java.util.List;

public class Problem139 {
    /*   possible[i] = true      if  S[0,i]在dictionary里面
                     = true      if   possible[k] == true 并且 S[k+1,i]在dictionary里面， 0<k<i
                     = false      if    no such k exist.
        idea:  abcdef
               i=0->len, j=0->i
           iteration:  1) i=0j=0;  a
                       2) i=1;j=0,1; a,ab
                       3) i=2;j=0,1,2;abc,a/bc,ab/c
                       4) i=3;j=0,1,2,3;abcd,a/bc,ab/c,abc/c    dp[j - 1]=a,ab,abc
    */                 
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j <= i; j++) {
            String sub = s.substring(j, i + 1);
            if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
              dp[i] = true;
              break;
            }
          }
        }
        
        return dp[n - 1];
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[][] table=new boolean[s.length()][s.length()];
//        table[][]=true;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                String str = s.substring(i,j+1);
                if(check(wordDict,str)){
                    table[i][j]=true;
                }else{
                    for(int k=0;k<j;k++){
                        if(table[i][k]&&table[k+1][j]){
                            table[i][j]=true;
                        }
                    }
                }
            }
        }
        return table[s.length()-1][s.length()-1];
    }
    public boolean check(List<String> wordDict,String s){
        for(String str:wordDict){
            if(str.equals(s))return true;
        }
        return false;
    }
}
