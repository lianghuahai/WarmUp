package problem.day2;

import java.util.ArrayList;
import java.util.List;

public class Problem22 {
     public static int count =0;
    public static void main(String[] args) {
        List<String> list = generateParenthesis(2);
        System.out.println(count);
        for (String string : list) {
            System.out.println(string);
        }
        
        /*  Problem  58
        String s  = "a";
        s=s.trim();
        int len=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                len++;
            }else{
                break;
            }
        }
        System.out.println(len);
        */
    }
    
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtracking(list,"",n,n);
        return list;
    
    }
    public static void backtracking(List<String> list,String curr, int left,int right){
        // left is remaining '('  right is remaining of ')'
        if(left==0&&right ==0){
            list.add(curr);
            return;
        }
        if(left>0){
            count++;
            backtracking(list, curr+"(",  left-1, right);
        }
        //left>right  right>0
        if(right>0){
            backtracking(list, curr+")",  left, right-1);
        }
    }

}
