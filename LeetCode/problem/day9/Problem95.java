package problem.day9;

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList();
        return genTrees(1,n);
    }
    public List<TreeNode> genTrees (int start, int end)
    {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start>end){
            list.add(null);
            return list;
        }
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left,right;
        for(int i=start;i<=end;i++){
            left = genTrees(start, i-1);
            right = genTrees(i+1,end);
            for(TreeNode lnode: left){
                for(TreeNode rnode: right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
