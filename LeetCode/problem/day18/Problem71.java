package problem.day18;

import java.util.Stack;

public class Problem71 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public String simplifyPath(String path) {
        Stack <String>stack  = new Stack<>();
        String []paths = path.split("/+");
        for(String s :paths){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.equals(".")&& !s.equals("")){
                stack.push(s);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res="/"+stack.pop()+res;
        }
        if(res.length()==0){
            return "/";
        }
        return res;
    }
}
