package problem.day9;

//94. Binary Tree Inorder Traversal
public class Problem94 {
  //method 1 , iteration
    /*public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            result.add(node.val);  // Add after all left children
            p = node.right;   
        }
    }
    return result;
}*/
    
    
    
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
        res.add(root.val);
        recursion(res,root.right);
    }*/
}
