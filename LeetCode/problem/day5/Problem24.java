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
    //method 1  better
    public static ListNode swapPairs(ListNode head) {
        //  first ->  1 -> 2 -> 3 -> 4
        //           second
        //            2 -> 1 -> 3 -> 4
        //               first second
        if(head==null||head.next==null)return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode first  = prehead;
        ListNode second = first.next;
        while(second!=null && second.next!=null){
            ListNode nextfirst = second.next.next;
            first.next=second.next;
            second.next.next=second;
            second.next=nextfirst;
            first=second;
            second=second.next;
            
        }
        return prehead.next;
    }
    
    //method 2  
    public static ListNode swapPairs1(ListNode head) {
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
