package problem.day9;

import java.util.HashMap;

public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap <Character,Integer> dict = new HashMap<>();
        for(Character ch :s1.toCharArray()){
            dict.put(ch,dict.getOrDefault(ch,0)+1);
        }
        for(char ch :dict.keySet()){
            if(dict.get(ch)!=0)return false;
        }
        return true;
    }
}
