package problem.day10;

import helperClass.ListNode;
import helperClass.TreeNode;

public class Problem109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        return helper(head,null);
    }
    public TreeNode helper(ListNode head,ListNode tail){
        ListNode fast =head;
        ListNode slow =head;
        if(head==tail)return null;
        while(fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode temp  = new TreeNode(slow.val);
        temp.left=helper(head,slow);
        temp.right=helper(slow.next,tail);
        return temp;
    }
}       
