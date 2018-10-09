package problem.day14;

import helperClass.ListNode;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null&&fast.next!=null){
            if(fast==slow)return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}
