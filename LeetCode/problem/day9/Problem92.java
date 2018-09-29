package problem.day9;

import helperClass.ListNode;

public class Problem92 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //    cur  temp
        // p-> 1->  2  ->3->4
        // p->2  then 2-> 1 then  1-> 3
        
        //         cur  temp
        // p-> 2->  1  ->3->4 
        // p->3  then 3-> 2 then  1-> 4 
        
        //         cur  temp
        // p-> 3->  2  ->1->4  -> null
         // p->4  then 4-> 3 then  1-> null
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre=dummy;
        ListNode cur = head;
        for(int i =1;i<m;i++){
            pre=pre.next;
            cur=cur.next;
        }
        for(int i =0;i<n-m;i++){
            ListNode temp = cur.next;
            cur.next= temp.next;
            temp.next=pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
