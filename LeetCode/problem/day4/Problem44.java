package problem.day4;

public class Problem44 {

    public static void main(String[] args) {
        boolean comparison = isMatch("aa","*");
        System.out.println(comparison);

    }
    //idea is using two pointers, si -> s,  pi-> p,  and match records the position of s[si] that p[pi] is equals to *
    //and stari always point to the last index of * 
    // once we meet the condition s[si]!=p[pi], we go back to the starti +1 of p,  and  match+1 of  s  
    public static boolean isMatch(String s, String p) {
        int si=0,pi=0,matchi=0,stari=-1;
        while(si<s.length()){
            //s[si]==p[pi]
            if(pi<p.length() && (s.charAt(si)==p.charAt(pi)|| p.charAt(pi)=='?') ){
                pi++;
                si++;
            }
            //p[pi]= *
            else if(pi<p.length() && p.charAt(pi)=='*'){
                stari=pi;
                pi++;
                matchi=si;
            }
            //s[si]!=p[pi]  but we had * , so backtrack there again
            else if(stari!=-1){
                pi=stari+1;
                si=++matchi;
            }
            else  return false;
        }
        //edge case, p remaining *
        while(pi<p.length() && p.charAt(pi)=='*')pi++;
        
        return pi==p.length();
    }
    
}
