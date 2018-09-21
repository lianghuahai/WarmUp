package problem.day8;

import helperClass.ListNode;

public class Problem83 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);
        ListNode x = deleteDuplicates(root);
        while(x!=null){
            System.out.println(x.val);
            x = x.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev = head;
        ListNode root = head.next;
        while(root!=null){
            if(root.val==prev.val){
                root = root.next;
                continue;
            }
            prev.next = root;
            prev = root;
            root = root.next;
        }
        prev.next = null;
        return head;
    }
}
