package problem.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem30 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static List<Integer> findSubstring(String s, String[] words) {
        //corner case
        if(s==null || words==null ||words.length==0)return new ArrayList<Integer>();
        int wordsLength = words.length;
        int wordLength = words[0].length();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<wordsLength;i++){
            map.put(words[i],map.get(words[i])+1);
        }
        for(int i =0;i<=s.length()-wordsLength*wordLength;i++){
            HashMap<String,Integer> copy = new HashMap<String,Integer>(map);
            int numWords = wordsLength;
            int j=i;
            while(numWords>0){
                String str = s.substring(j,j+wordLength);
                if(!copy.containsKey(str) || copy.get(str)<=0){
                    break;
                }
                copy.put(str,copy.get(str)-1);
                j+=wordLength;
                numWords--;
            }
            if(numWords==0){
                //found answer
                res.add(i);
            }
        }
        return res;
    }
}
