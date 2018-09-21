package problem.day13;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtracking(list, new ArrayList<String>(), s, 0);
        return list;
     }
    public static void backtracking(List<List<String>> list,List<String> tempList,String s ,int start){
          if(start == s.length())
          list.add(new ArrayList<String>(tempList));
          for(int i = start; i < s.length(); i++){
             if(isPalindrome(s, start, i)){
                tempList.add(s.substring(start, i + 1));
                backtracking(list, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
             }
          }
    }
    public static boolean isPalindrome(String s, int low, int high){
       while(low < high)
          if(s.charAt(low++) != s.charAt(high--)) return false;
       return true;
    } 
}
