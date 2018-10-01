package problem.day12;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem128 {
    public static void main(String[] args) {
//      System.out.println(isPalindrome("race a car"));
//      System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
      List<List<String>> findLadders = findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log"));
      for (List<String> list : findLadders) {
        for (String string : list) {
            System.out.print(string+" ");
        }
        System.out.println();
    }
  }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res= new ArrayList<List<String>>();
        if(wordList.size()==0)return res;
        HashSet unvisited = new HashSet(wordList);
        HashSet visited = new HashSet();
        HashMap<String,List<String>> map = new HashMap<>();
        Queue <String>que = new LinkedList();
        boolean flag= false;
        que.offer(beginWord);
//        List<List<String>> findLadders = findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log"));
        while(que.size()>0){
            int size= que.size();
            for(int i=0;i<size;i++){
                String str  = que.poll();
                for(int j=0;j<str.length();j++){
                    StringBuilder sb = new StringBuilder(str);
                    for(char s ='a';s<='z';s++){
                        sb.setCharAt(i, s);
                        String newWord = sb.toString();
                        if(unvisited.contains(newWord)){
                            if(visited.add(newWord)){
                                que.offer(newWord);
                            }
                            if(map.containsKey(newWord)){
                                map.get(newWord).add(str);
                            }else{
                                map.put(newWord, Arrays.asList(str));
                            }
                            if(newWord.equals(endWord)){
                                flag=true;
                            }
                        }
                    }
                }
            }
            if(flag){
                flag=false;
                break;
            }
            
        }
        return res;
    }
}
