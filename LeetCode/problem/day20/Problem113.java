package problem.day20;

import helperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
         help(res,root,sum,new ArrayList<Integer>());
        return res;
    }
    public void help(List<List<Integer>> res, TreeNode root, int sum,List<Integer> list){
        if(root==null)return;
        list.add(root.val);
        if(root.left==null && root.right==null &&sum-root.val==0){
            res.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        help(res,root.left,sum-root.val,list);
        help(res,root.right,sum-root.val,list);
        list.remove(list.size()-1);
    }

}
