package problem.day23;

import helperClass.ListNode;

public class Problem160 {
    //Simple idea is, a.len- b.len  =2,  then move 2 more node of a, then travel together, they will meet the same node;
    // solution explanation is in the leetcode answer, reply page 2
    /* idea:  a-> headA, b-> headB and the distance of a travel and b travle is: headA.length+headB.length==headB.length+headA.length(why?) It is the key!!!!
   (1)          a
     *   headA  1 2 3  
     *                    7 8 9   initial case:
     *   headB  2 3 4 5 6 
     *          b
      a->1, b-2, travel at the same time, then when a ->null, a=headB, when b->null, b=headA;
        The case below: a->headB
    (2)          
     *   headA  1 2 3  
     *                    7 8 9   initial case:
     *   headB  2 3 4 5 6   b
     *          a 
     (3)
                b
     *   headA  1 2 3  
     *                    7 8 9   initial case:
     *   headB  2 3 4 5 6   
     *              a 
     *    Therefore, they start at the same length, and will travel the same node eventually
     
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;    
        //the reason why it wouldnt be infinity loop,the distance of a travel and b travle is:  headA.length+headB.length==headB.length+headA.length!!!!!!
        // it will end up with a=b=null if same node is not found
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
}
