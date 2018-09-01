package problem.day22;

import helperClass.ListNode;

public class Problem237 {
    /*
    1 2 3 4  (remove 3)
    1 2 2 4  
    1 2 (2) 4
   */
   public void deleteNode(ListNode node) {
       node.val=node.next.val;
       node.next=node.next.next;
   }
}
