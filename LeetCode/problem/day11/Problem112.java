package problem.day11;

import helperClass.TreeNode;

public class Problem112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return help(root,sum);
    }
    public boolean help(TreeNode root,int sum){
        if(root==null)return false;
        if(root.left==null&&root.right==null&&sum-root.val==0)return true;
        return help(root.left,sum-root.val)||help(root.right,sum-root.val);
    }
}
