package problem.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem127 {
    public static void main(String[] args) {
//      System.out.println(isPalindrome("race a car"));
//      System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
      System.out.println(ladderLength("hit","cog",Arrays.asList("hot","dot","dog","lot","log")));
  }
    /*It is bfs, therefore, at beginning, we try 26 possible for each char of each word. eg: hit: []it or h[]t or hi[]
     * then, check whether every new word is in the dictionary. if so, add to the queue, if word==endword, return result
     * 
     * 
     * 
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet set = new HashSet(wordList);
        if(set.contains(beginWord))set.remove(beginWord);
        Queue <String>que = new LinkedList();
        int res=1;
        que.offer(beginWord);
        while(que.size()>0){
            int size= que.size();
            for(int i=0;i<size;i++){
                String str  = que.poll();
                for(int j=0;j<str.length();j++){
                    char [] chs= str.toCharArray();
                    for(char s ='a';s<='z';s++){
                        chs[j]=s;
                        String temp = new String(chs);
                        if(set.contains(temp)){
                            if(temp.equals(endWord)){
                                return res+1;
                            }
                            que.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
                
            }
            res++;
        }
        return 0;
    }
}
