package problem.day23;

public class Problem138 {
    // time O(n)  space O(1)
    //idea is    1-> 2 -> 3    =>  1->'1'-> 2->'2' -> 3-> '3'
    //  and then assign the ramdon to its copy
    
   /* public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
                next = iter.next;

                RandomListNode copy = new RandomListNode(iter.label);
                iter.next = copy;
                copy.next = next;

                iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
                if (iter.random != null) {
                        iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
                next = iter.next.next;

                // extract the copy
                copy = iter.next;
                copyIter.next = copy;
                copyIter = copy;

                // restore the original list
                iter.next = next;

                iter = next;
        }

        return pseudoHead.next;
}*/
    
    
 // time O(n)  space O(n)  using hashmap
    /*public RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode,RandomListNode> map = new HashMap();
    RandomListNode cur = head;
    while(cur!=null){
        map.put(cur,new RandomListNode(cur.label));
        cur=cur.next;
    }
    cur=head;
    while(cur!=null){
        map.get(cur).next = map.get(cur.next);
        map.get(cur).random = map.get(cur.random);
        cur=cur.next;
    }
    return map.get(head);*/
//}
}
