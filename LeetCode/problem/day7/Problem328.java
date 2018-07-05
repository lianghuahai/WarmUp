package problem.day7;

import helperClass.ListNode;

public class Problem328 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next =  new ListNode(2);
        root.next.next =  new ListNode(3);
        root.next.next.next =  new ListNode(4);
        root.next.next.next.next =  new ListNode(5);
        oddEvenList(root);
        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode root = head;
        ListNode oddhead = head;
        ListNode evenhead = head.next;
       
        ListNode odd = head;
        ListNode even = head.next;
        while(odd!=null && even!=null){
            if(even.next==null){
                break;
            }
            odd.next=even.next;
            odd= even.next;
            
            even.next=odd.next;
            even= odd.next;
//            if(even.next==null){
//                break;
//            }else{
//                
//                if(odd.next==null){
//                    System.out.println("fdfad");
//                    break;
//                }else{
//                   
//                }
//            }
        }
        odd.next = evenhead;
        return root;
    }
}
