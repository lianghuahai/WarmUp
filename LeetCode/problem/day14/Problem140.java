package problem.day14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem140 {

    public static void main(String[] args) {
        wordBreak("catsanddog",Arrays.asList("cat","cats","and","sand","dog"));

    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s,new HashMap<String,LinkedList<String>>(),wordDict);
    }
    public static List<String> dfs( String s,Map<String,LinkedList<String>> map, List<String> wordDict){
        if(map.containsKey(s)){
            return map.get(s);
        }
        LinkedList<String>res = new LinkedList();
        if(s.length()==0){
            res.add("");
            return res;
        }//s = "cat sand dog"
                //wordDict = ["cat","cats","and","sand","dog"]
        for(String str : wordDict){
            if(s.startsWith(str)){
                List<String>sublist =dfs(s.substring(str.length()),map,wordDict);
                for(String sub:sublist){
                    res.add(str+(sublist.isEmpty()?"":" ")+sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
