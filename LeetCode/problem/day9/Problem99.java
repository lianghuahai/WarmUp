package problem.day9;

import helperClass.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem99 {
    
    
    //method 1, iterator with stack
    public void recoverTree(TreeNode root) {
        if(root==null)return;
        TreeNode cur =root;
        TreeNode first =null;
        TreeNode second =null;
        TreeNode prev =null;
        
        Deque<TreeNode> stack = new ArrayDeque();
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur = stack.pop();
                if(prev!=null && cur.val<=prev.val){
                    if(first==null){
                        first=prev;
                        second=cur;
                    }else{
                        second=cur; 
                    }
                }
                prev=cur;
                cur=cur.right;
            }
        }
        int t = first.val;
        first.val=second.val;
        second.val=t;
    }
}
