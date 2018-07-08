package problem.day8;

import helperClass.ListNode;

public class Problem25 {

    public static void main(String[] args) {
        ListNode head  = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        ListNode root = reverse(head, 3);
        ListNode root = reverseKGroup(head, 2);
        while(root!=null){
            System.out.println(root.val);
            root= root.next;
        }
        
    }
    
    //mine
 // The idea is to recursively reverse every Kth Node.
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(head== null || k==1 || head.next==null){
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next=  head;
        int counter = 0;
        while(root.next!=null){
            counter++;
            root= root.next;
            if(counter>=k){
                break;
            }
        }
        if(counter<k){
            return head;
        }
        ListNode nextKthHead = root.next;// we have to record it, otherwise, we cant find it when after we call reverse();
        ListNode lastNode = reverse( head , k); 
        lastNode.next = reverseKGroup(nextKthHead,k);
        return root;
    }
    public static ListNode reverse(ListNode head , int len) {
        ListNode clearRoot = head;
        ListNode prev = head;  // 1 2 3 4 5 6 ....;  1 is prev, 2 is curr, 3 is next; next loop:  2 is prev, 3 is curr, 4 is next  etc....
        ListNode curr = head.next;
        ListNode next = head.next.next;
        for(int i=0;i<len-1;i++){
            next= curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        clearRoot.next= null;
        return clearRoot;
    }
    

}
