package problem.day14;

// Binary Tree preorder Traversal
public class Problem144 {
  //method 1 , iteration  using stack
    /*public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.add(p.val);  // Add before going to children
            p = p.left;
        } else {
            TreeNode node = stack.pop();
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
        res.add(root.val);
        recursion(res,root.left);
        recursion(res,root.right);
    }*/
}
