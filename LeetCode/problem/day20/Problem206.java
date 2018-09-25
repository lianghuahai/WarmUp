package problem.day20;

import helperClass.ListNode;

public class Problem206 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        //  1  ->  2  ->   3 ->4 ->5   iterative
//    pre  cur   next            pre  cur   next
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next =pre;
            pre=cur;
            cur=next;
        }
        return pre;
        // 1 2 3 4 <-5  recursion
        /*if(head==null||head.next==null)return head;
        ListNode root = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return root;*/
        
    }
}
