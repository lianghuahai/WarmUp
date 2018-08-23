package problem.day20;

import helperClass.TreeNode;

import java.util.List;
import java.util.Stack;

public class Problem105 {
    public static void main(String[] args) {
        buildTree2(new int[]{7,10,4,3,1,  2,8,11},new int[]{4,10,3,1, 7  ,11,8,2});
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    /*           _______7______
                /              \
             __10__          ___2
            /      \        /
            4       3      _8
                     \    /
                      1  11                         */
    //preorder = {7,10,4,3,1,  2,8,11}
    //inorder = {4,10,3,1, 7  ,11,8,2}
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]), cur = root;
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                s.push(cur);
                cur = cur.left;
            } else {
                j++;
                while (!s.empty() && s.peek().val == inorder[j]) {
                    cur = s.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
