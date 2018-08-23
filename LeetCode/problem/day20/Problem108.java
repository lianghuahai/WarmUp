package problem.day20;

import helperClass.TreeNode;

public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int start,int end) {
        if(start>end)return null;
        int mid = (end-start)/2+start;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left=helper(nums,start,mid-1);
        cur.right=helper(nums,mid+1,end);
        return cur;
    }
}
