package problem.day8;

import helperClass.ListNode;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallhead= new ListNode(0);
         ListNode bighead= new ListNode(0);
        ListNode small = smallhead;
        ListNode big = bighead;
        while(head!=null){
            ListNode temp = new ListNode(head.val);
            if(head.val<x){
                small.next = temp;
                small = small.next;
            }else{
                big.next = temp;
                big = big.next;
                
            }
            head=head.next;
        }
        small.next=bighead.next;
        return smallhead.next;
    }
}
