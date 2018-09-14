package problem.day24;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem227 {
    public static void main(String[] args) {
        calculate("1-2");
    }
    public static int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
    
        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
        }
}
