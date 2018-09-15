package problem.day24;

import java.util.Stack;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        String ops = "+-*/";
        Stack<Integer> stk = new Stack<>();
         for (String t : tokens) {
            if (1 == t.length() && -1 != ops.indexOf(t.charAt(0))) {   // op
                int num2 = stk.pop();
                int num1 = stk.pop();
                switch (t.charAt(0)) {
                    case '+' : stk.push(num1 + num2); break;
                    case '-' : stk.push(num1 - num2); break;
                    case '*' : stk.push(num1 * num2); break;
                    case '/' : stk.push(num1 / num2); break;
                    default: break;
                }
            }
            else stk.push(Integer.valueOf(t));    
            
        }
        
        return stk.peek();
    }
}
