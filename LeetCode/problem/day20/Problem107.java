package problem.day20;

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();
       if(root==null)return lists;
       Queue<TreeNode> que =  new LinkedList();
       que.offer(root);
       while(que.size()>0){
           int size = que.size();
           List<Integer> list = new ArrayList<Integer>();
           for(int i=0;i<size;i++){
               TreeNode temp =que.poll();
               list.add(temp.val);
               if(temp.left!=null)que.offer(temp.left);
               if(temp.right!=null)que.offer(temp.right);
           }
           lists.addFirst(list);
       }
       return lists;
   }
}
