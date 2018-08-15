package problem.day17;

import helperClass.ListNode;

public class Problem19 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*  快慢指针=prehead, prehead.next= head //必须指向head  
        slow = 0, fast moving forwards n steps;and then moving these two pointers at the same time, when fast reach the end
        slow is pointing to Nth-1(left) Node from the end. remove it(slow.next= slow.next.next)
        return prehead
    
        */  //slow ->  1  2  3  4 5  n=2
        ListNode prehead= new ListNode(-1);
        ListNode slow = prehead;
        ListNode fast = prehead;
        prehead.next = head;
        for(int i=0;i<=n;i++){
            if(fast!=null)fast=fast.next;
        }    
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return prehead.next;
    }
}
