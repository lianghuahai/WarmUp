package problem.day23;

import helperClass.ListNode;

public class Problem143 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(5);
        reorderList1(root);
    }
 // p->1->2->3->4->5
    // p->1->2->3->4
    public static void reorderList1(ListNode  head) {
        if(head==null||head.next==null) return;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pre = dummy;
        ListNode secondHead  = pre;
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            secondHead=secondHead.next;
            cur=cur.next.next;
        }
        // second.next  -> head of second half nodes
        //reverse the second half
        cur = secondHead.next;
        secondHead.next=null;
        ListNode temp =null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=temp;
            temp=cur;
            cur=next;
        }
        // temp is the head of reversed nodes,pre.next is the head of
        ListNode tail =temp;
        pre=pre.next;
        while(pre!=null){
            tail=temp;
            ListNode t1 =pre.next;
            ListNode t2 =temp.next;
            pre.next=temp;
            temp.next=t1;
            pre=t1;
            temp=t2;
            
        }
         tail.next=temp;
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        
        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }
        
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }
        
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}
