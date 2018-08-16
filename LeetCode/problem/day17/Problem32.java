package problem.day17;

import java.util.Stack;

public class Problem32 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static int longestValidParentheses(String s) {
        /* Stack  if ( push to stack
         *        if )  two condition, if stack is empty, doesnt have ( to match this ). so valid start = i
         *                             else stack.pop()  then 
         *                                      if stack is empty means stack only has one (     res = Math.max(res,i-start);
        *                                       else  stack has more than one ( such as (((      res = Math.max(res,i-stack.peek());
        */                                      
        if(s==null || s.length()<=1){return 0;}
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int start = -1;
        for(int i =0 ;i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else{
              if(stack.isEmpty()){
                  start=i;
              }else{
                  stack.pop();
                  if(stack.isEmpty()){
                      res = Math.max(res,i-start);
                  }else{
                      res = Math.max(res,i-stack.peek());
                  }
              }   
            }
        }
        return res;
    }
}
