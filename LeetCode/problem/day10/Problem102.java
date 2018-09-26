package problem.day10;

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)return res;
        
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);
        while(que.size()>0){
            int size = que.size();
            List<Integer> list = new ArrayList();
            for(int i = 0 ;i<size;i++){
                TreeNode temp = que.poll();
                list.add(temp.val);
                if(temp.left!=null)que.offer(temp.left);
                if(temp.right!=null)que.offer(temp.right);
            }
            res.add(list);
        }
        return res;
    }
}
