package problem.day19;

import helperClass.ListNode;

public class Problem82 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next= new ListNode(1);
        root.next.next= new ListNode(1);
        root.next.next.next= new ListNode(2);
        root.next.next.next.next= new ListNode(2);
        root.next.next.next.next.next= new ListNode(3);
        deleteDuplicates(root);
        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }

    }
    /*
    pre  ->   1 -> 1 -> 1 -> 2 -> 3
    pre       cur  next
    
       p    temp
    pre  ->   1 -> 1 -> 1 -> 2 -> 3
    pre                     cur  
    
    
                   p    temp
    pre  ->   1  -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
     pre                          cur  
    */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next==null)return head;
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        pre.next=head;
        ListNode cur= head.next;
        ListNode temp= head;
        ListNode p = pre;
        boolean flag = false;
        p.next=temp;
        while(cur!=null){
            if(temp.val != cur.val){
                if(flag){
                    p.next=cur;
                }else{
                    temp.next=cur;
                    p=p.next;
                }
                temp =cur;
                cur= cur.next;
                flag=false;
            }else{
                p.next=cur.next;
                cur= cur.next;
                flag=true;
            }
            
        }
        return res.next;
    }
}
