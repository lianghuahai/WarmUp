package problem.day2;

import helperClass.TreeNode;

public class Problem124 {
    int res = 0;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        res=Integer.MIN_VALUE;
        recursion(root);
        return res;
    }
    public int recursion(TreeNode root){
        if(root==null)return 0;
        int left= Math.max(0,recursion(root.left));
        int right= Math.max(0,recursion(root.right));
        res = Math.max(res,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
