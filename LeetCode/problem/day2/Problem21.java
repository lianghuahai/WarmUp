package problem.day2;

import helperClass.ListNode;

public class Problem21 {
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //merge sort 
        ListNode list = new ListNode(-1);
        ListNode root = list;
        while(l1!=null){
            if(l2!=null){
                if(l1.val<=l2.val){
                    list.next = new ListNode(l1.val);
                    l1 =l1.next;
                }else{
                    list.next = new ListNode(l2.val);
                    l2=l2.next;
                }
                list=list.next;
                
            }else{
                break;
            }
        }
         while(l1!=null){
             list.next = new ListNode(l1.val);
            l1 =l1.next;
             list=list.next;
        }
         while(l2!=null){
            list.next = new ListNode(l2.val);
           l2=l2.next;
             list=list.next;
        }
        return root.next;
    }
}
