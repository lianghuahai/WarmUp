package problem.day20;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root==null)return 0;
        Queue<TreeNode> stack = new LinkedList();
        stack.offer(root);
        while(stack.size()>0){
            int size = stack.size();
            for(int i =0;i<size;i++){
                TreeNode temp =stack.poll();
                if(temp.left!=null)stack.offer(temp.left);
                if(temp.right!=null)stack.offer(temp.right);
            }
            res++;
        }
        return res;
    }
}
