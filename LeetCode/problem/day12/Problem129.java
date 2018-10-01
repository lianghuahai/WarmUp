package problem.day12;

import helperClass.TreeNode;

public class Problem129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
    public static int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        return help(root,0);
    }
    public static int help(TreeNode root,int s){
        if (root == null) return 0;
        if (root.right == null && root.left == null) return s*10 + root.val;
          return help(root.left, s*10 + root.val) + help(root.right, s*10 + root.val);
       // return help(root.left,10*s+root.val)+help(root.right,10*s+root.val);
    }
}
