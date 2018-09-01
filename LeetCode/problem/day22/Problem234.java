package problem.day22;

import helperClass.ListNode;

public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode first =head;
        ListNode second =head;
        boolean flag=false;
        if(first.val==second.val)flag=true;
        while(second!=null && second.next!=null){
            first=first.next;
            second=second.next.next;
        }
        ListNode secondHead = reverse(first);
        // first.next=null;
        while(secondHead!=null&&head!=null&&head!=first){
            if(secondHead.val!=head.val)return false;
            secondHead=secondHead.next;
            head=head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
