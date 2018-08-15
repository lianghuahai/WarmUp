package problem.day17;

import java.util.PriorityQueue;
import java.util.Stack;

public class Problem20 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public boolean isValid(String s) {
        // method 1. stack
        if(s.equals(""))return true;
        if(s==null || s.length()==1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(Character ch : s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            }else if(ch=='{'){
                stack.push('}');
            }else if(ch=='['){
                stack.push(']');
            }else if(stack.isEmpty()|| stack.pop()!=ch){
                return false;
            }
        }
        return stack.isEmpty();
        
        
        
        
        /* dumb method 2.
        if(s==""){
            return true;
        }
        List<Character> list = new ArrayList<Character>();
        for(int i =0;i<s.length();i++){
            if(list.isEmpty()){
                list.add(s.charAt(i));
                continue;
            }
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                list.add(s.charAt(i));
                continue;
            }
            char top = (char)list.remove(list.size()-1);
            
            if(top=='('){
                if(s.charAt(i)==')'){
                    continue;
                }else{
                    return false;
                }
                
            }else if(top=='{'){
                if(s.charAt(i)=='}'){
                    continue;
                }else{
                    return false;
                }
            }else if(top=='['){
                if(s.charAt(i)==']'){
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        if(list.isEmpty()){
                return true;
        }
        return false;*/
    
    }
}
