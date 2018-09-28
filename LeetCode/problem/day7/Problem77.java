package problem.day7;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        backtracking(lists,new ArrayList<Integer>(),n,k,1);
        return lists;
    }
    public void backtracking(List<List<Integer>> lists,List<Integer> temp,int n,int k,int index){
        if(k==0){
            lists.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i =index ;i<=n;i++){
            temp.add(i); 
            backtracking(lists,temp,n,k-1,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
