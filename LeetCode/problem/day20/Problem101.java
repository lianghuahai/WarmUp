package problem.day20;

import helperClass.TreeNode;

public class Problem101 {
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
