package problem.day17;

import helperClass.ListNode;

public class Problem203 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode root = head;
        ListNode pre = new ListNode(0);
        pre.next= head;
        while(root!=null){
            if(root.val==val){
                pre.next=root.next;
            }
            pre=pre.next;
            root=root.next;
        }
        
        return head;
    }
}
