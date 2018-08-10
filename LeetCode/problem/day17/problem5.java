package problem.day17;

public class problem5 {

    public static void main(String[] args) {
        String longestPalindrome = longestPalindrome("ababd");
        System.out.println(longestPalindrome);

    }   
    public static String longestPalindrome(String s) {
        if(s==null||s.length()==0)return s;
        //1.   dp 
        boolean [][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int max = 0;
        for(int j = 0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ( j-i <=2 || dp[i+1][j-1]);
                if(dp[i][j]){
                    if(j-i+1>max){
                        max=j-i+1;
                        res=s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
}
 