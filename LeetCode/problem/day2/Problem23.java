package problem.day2;

import helperClass.ListNode;

public class Problem23 {

    public static void main(String[] args) {
        //test merge two ListNode
        ListNode root = new ListNode(1);
        root.next =  new ListNode(4);
        root.next.next =  new ListNode(5);
//        root.next.next.next =  new ListNode(4);
//        root.next.next.next.next =  new ListNode(9);
        ListNode root2 = new ListNode(1);
        root2.next =  new ListNode(3);
        root2.next.next =  new ListNode(4);
//        root2.next.next.next =  new ListNode(6);
//        root2.next.next.next.next =  new ListNode(7);
        ListNode[] lists = new ListNode[100];
        lists[0]=root;
        lists[1]=root2;
        ListNode head = mergeKLists1(lists);
        
//        ListNode head = mergeTwoLists(root,root2);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
        
    }
    //
     // method 1 : PriorityQueue O(NlogK)
     /*   if(lists.length==0 || lists==null)return null;
    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,(a,b)->a.val-b.val);
    
    ListNode prehead = new ListNode(0);
    ListNode cur = prehead;
     for(ListNode list : lists){
         if(list!=null)queue.add(list);
     }   
    
     while(!queue.isEmpty()){
         cur.next = queue.poll();
         cur=cur.next;
         if(cur.next!=null){
             queue.add(cur.next);
         }
     }
    return prehead.next;*/
    
    
    
    
    
    //method 2: divide and conquer mine Algorithm
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0 || lists==null){
            return null;
        }
        return merge(lists,0,lists.length-1);
    }
    public static ListNode merge(ListNode[] lists,int left, int right ) {
        if(left==right){
            return lists[left];
        }else if(left<right){
            int mid = (right - left)/2+left;
            merge(lists,left,mid);
            merge(lists,mid+1,right);
            return mergeTwoLists(lists[left],lists[right]);
        }
        return null;
    }
    //others
    public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0)
                    return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
    private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end) {
                    return lists[start];
            } else if (start < end){
                    int mid = (end - start) / 2 + start;
                    ListNode left = mergeKLists(lists, start, mid);
                    ListNode right = mergeKLists(lists, mid + 1, end);
                    return mergeTwoLists(left, right);
            } else {
                    return null;
            }
    }
    
    
    // merge  two sorted list
    private static ListNode mergeTwoLists(ListNode left, ListNode right) {
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        ListNode root = left;
        if(left.val<right.val){
            root=left;
            left = left.next;
        }else{
            root=right;
            right = right.next;
        }
        ListNode head = root;
        while(left!=null && right!=null){
            if(left.val<right.val){
                root.next=left;
                left = left.next;
                root= root.next;
            }else{
                root.next=right;
                right = right.next;
                root= root.next;
            }
        }
        while(left!=null){
            root.next=left;
            left = left.next;
        }
        while(right!=null){
            root.next=right;
            right = right.next;
            root= root.next;
        }
        
        
        return head;
    }
    
}
