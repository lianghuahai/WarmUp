package problem.day9;

import helperClass.TreeNode;

public class Problem98 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
//   time O(n)space o(n)
    /*idea is , define a min, and max, recursive call it, current Node.val must >min and < max otherwise, return false
     * 
     */
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        return recursion(root,null,null);
    }
    public boolean recursion(TreeNode node ,Integer min, Integer max){
        if(node==null)return true;
        if(min!=null && node.val<min)return false;
        if(max!=null && node.val>max)return false;
        return recursion(node.left,min,node.val)&&recursion(node.right,node.val,max);
    }
}
