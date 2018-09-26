package problem.day10;

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)return res;
        
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        boolean level=false;
        while(que.size()>0){
            int size = que.size();
            LinkedList<Integer> list = new LinkedList();
            for(int i = 0 ;i<size;i++){
                TreeNode temp = que.poll();
                if(level){
                    list.addFirst(temp.val);
                }else{
                    list.add(temp.val);
                }
                if(temp.left!=null)que.offer(temp.left);
                if(temp.right!=null)que.offer(temp.right);
            }
            level=!level;
            res.add(list);
        }
        return res;
    }
}
