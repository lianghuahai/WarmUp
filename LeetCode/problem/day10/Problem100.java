package problem.day10;

import helperClass.TreeNode;

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
