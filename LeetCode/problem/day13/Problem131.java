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
    /*
     * 
     * 
     
    public List<List<String>> partition(String s) {
        List<List<String>> lists=new ArrayList<>();
        int len=s.length();
        if(len==0) return lists;
        backtrack(lists, new ArrayList<>(), s,0,len);
        return lists;
    }
    private void backtrack(List<List<String>> lists,List<String> list,String s, int l, int r) {
            if(l==r) {
                    lists.add(new ArrayList<>(list));
                    return;
            }
            for(int i=l+1;i<=r;i++) {
                    if(isPalindrome(s, l, i)) {
                            list.add(s.substring(l, i));
                            backtrack(lists, list, s,i,r);
                            list.remove(list.size()-1);
                    }
            }
    }
    private boolean isPalindrome2(String s, int l, int r){
        if(l==r-1) return true;
        while(l<r-1){
            if(s.charAt(l)!=s.charAt(r-1)) return false;
            l++;r--;
        }
        return true;
    }
    */
}
