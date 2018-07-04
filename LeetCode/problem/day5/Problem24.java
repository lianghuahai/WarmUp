package problem.day5;

import helperClass.ListNode;

public class Problem24 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        swapPairs(root);
        while (root!=null){
            System.out.println(root.val);
            root=root.next;
        }

    }
    public static ListNode swapPairs(ListNode head) {
        ListNode first = head;
        if(first==null || first.next ==null){
                return head;
        }
        ListNode next = first.next;
        head = next;
        
        do{
           first.next= next.next;
           next.next = first;
           first= first.next;
//            if(first==null){System.out.println("first");}
//            if(next==null){System.out.println("next");}
            next = first.next;
            System.out.println(first.val);
            System.out.println(next.val);
            
        }while(first!=null && next!=null);
        return head;   
    }
}
