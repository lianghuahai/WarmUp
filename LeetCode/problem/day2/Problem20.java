package problem.day2;

import java.util.ArrayList;
import java.util.List;

public class Problem20 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public boolean isValid(String s) {
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
        return false;
    }
}
