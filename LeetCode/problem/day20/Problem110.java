package problem.day20;

import helperClass.TreeNode;

public class Problem110 {
    public boolean isBalanced(TreeNode root) {
        return help(root)!=-1;
    }
    public int help(TreeNode root){
        if(root==null)return 0;
        int left = help(root.left);
        if(left==-1)return -1;
        int right = help(root.right);
        if(right==-1)return -1;
        if(Math.abs(left-right)>1)return -1;
        return Math.max(left,right)+1;
    }
    
    
  //top down O(n^2)
    /*  class solution {
        public:
            int depth (TreeNode *root) {
                if (root == NULL) return 0;
                return max (depth(root -> left), depth (root -> right)) + 1;
            }

            bool isBalanced (TreeNode *root) {
                if (root == NULL) return true;
                
                int left=depth(root->left);
                int right=depth(root->right);
                
                return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
            }
        };)*/
    
        //bottom up O(n)
    /*class solution {
        public:
        int dfsHeight (TreeNode *root) {
                if (root == NULL) return 0;
                
                int leftHeight = dfsHeight (root -> left);
                if (leftHeight == -1) return -1;
                int rightHeight = dfsHeight (root -> right);
                if (rightHeight == -1) return -1;
                
                if (abs(leftHeight - rightHeight) > 1)  return -1;
                return max (leftHeight, rightHeight) + 1;
            }
            bool isBalanced(TreeNode *root) {
                return dfsHeight (root) != -1;
            }
        };*/
}
