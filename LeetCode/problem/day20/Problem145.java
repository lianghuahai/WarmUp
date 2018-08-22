package problem.day20;

import helperClass.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Binary Tree postorder Traversal
public class Problem145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.left.right.left= new TreeNode(10);
        root.left.left.left= new TreeNode(8);
        root.left.left.right= new TreeNode(9);
        List<Integer> res =postorderTraversal(root);
        for (Integer n : res) {
            System.out.print(n +" ");
        }
    }
  //method 1 , iteration  using stack
    public static List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.addFirst(p.val);  // Reverse the process of preorder
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
}
  //method 2 , easy recursion
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)return res;
        recursion(res,root);
        return res;
    }
    public void recursion(List<Integer> res, TreeNode root){
        if(root==null)return ;
        recursion(res,root.left);
        recursion(res,root.right);
        res.add(root.val);
    }*/
}
