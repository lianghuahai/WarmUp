package problem.day21;

public class Problem117 {
    /*
    1 -> NULL   pre->1.left->1.right->1.next.left->1.next.right->....->null
  /  \
 2 -> 3 -> NULL   root=pre.next=2;   pre->2.left4->2.right5->2.next3.leftnull->2.next3.right7->....->null
/ \    \
4-> 5 -> 7 -> NULL
*/
public void connect(TreeLinkNode root) {
   TreeLinkNode dummy = new TreeLinkNode(0);
   TreeLinkNode head = dummy;
   while(root!=null){
       if(root.left!=null){
           head.next=root.left;
           head=root.left;
       }
       if(root.right!=null){
           head.next=root.right;
           head=root.right;
       }
       root=root.next;
       if(root==null){
           head=dummy;
           root=dummy.next;
           dummy.next=null;
       }
   }
   
}
}
