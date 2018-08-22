package problem.day20;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem101 {
    public static void main(String[] args) {
        //1,2,2,3,4,4,3
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(2);
        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.right= new TreeNode(4);
        root.right.left= new TreeNode(5);
        System.out.println(isSymmetric3(root));
    }
    
  //method 1 iterator + stack
    public static boolean isSymmetric3(TreeNode root) {
        if(root==null) return true;
        // Deque<TreeNode> stack = new ArrayDeque();
        //deque not allow value of null, if null be pushed to the stack. NPE !
        Stack<TreeNode> stack = new Stack();
        stack.push(root.right);
        stack.push(root.left);
        while(stack.size()>1){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if(left==null && right ==null )continue;
            if(left==null || right ==null)return false;
            if(left.val!=right.val)return false;
            stack.push(right.right);
            stack.push(left.left);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;        
    }
    //method 1 iterator + Queue
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while(q.size() > 1){
            TreeNode left = q.poll(),
                     right = q.poll();
            if(left== null&& right == null) continue;
            if(left == null ^ right == null) return false;
            if(left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);            
        }
        return true;
    }
    
    
    //method 2, recursion 
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && helper(p.left,q.right) && helper(p.right,q.left);
    }
}
