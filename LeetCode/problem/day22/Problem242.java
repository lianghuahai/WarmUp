package problem.day22;

import java.util.HashMap;
import java.util.Map;

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        if (s==null && t==null) return true;
        else if (s==null || t==null) return false;
        else if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(char str : s.toCharArray())map.put(str,map.getOrDefault(str,0)+1);
        for(char str : t.toCharArray()){
            int x= map.getOrDefault(str,0);
            if(x<=0){
                return false;
            }else{
                map.put(str,map.getOrDefault(str,0)-1);
            }
        }
        return true;
    }
}
