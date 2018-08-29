package problem.day22;

import helperClass.ListNode;

public class Problem147 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode res = new ListNode(4);
        res.next=new ListNode(2);
        res.next.next=new ListNode(1);
        res.next.next.next=new ListNode(3);
        insertionSortList(res);
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode res = new ListNode(-1);
        res.next=head;
        ListNode cur = head;
        ListNode temp=null,pre=null;
        while(cur!=null&&cur.next!=null){
            if(cur.val<=cur.next.val){
                cur=cur.next;
            }else{
                temp=cur.next;
                cur.next=temp.next;
                pre=res;
                while(pre!=null&&pre.next!=null &&pre.next.val<=temp.val){
                    pre=pre.next;
                }
                temp.next=pre.next;
                pre.next=temp;
            }
        }
        return res.next;
    }
  
}
