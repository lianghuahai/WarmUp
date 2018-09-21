package problem.day10;

import helperClass.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class Problem106 {
    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        buildTreePostIn(inorder,postorder);
        System.out.println("1");
    }
    //iteration
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;
        
        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }
        
        return root;
    }
    //recursion
    public static TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn2(inorder, 0, inorder.length-1, postorder, 0, 
                              postorder.length-1,hm);
    }

    public static TreeNode buildTreePostIn2(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn2(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn2(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
