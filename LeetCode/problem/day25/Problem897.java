package problem.day25;

import helperClass.TreeNode;

public class Problem897 {
    TreeNode head = null;
    TreeNode prev = null;
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return head;
    }
    public void helper(TreeNode root) {
        if(root==null)return;
        helper(root.left);
        if(head!=null){
            prev.right=root;
        }else{
            head=root;
        }
        prev=root; //keep track of the prev node
        root.left=null;
        helper(root.right);
    }
}
