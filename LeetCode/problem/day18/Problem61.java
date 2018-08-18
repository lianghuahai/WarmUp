package problem.day18;

import helperClass.ListNode;

public class Problem61 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*   1 -> 2 ->3 ->4 ->5  
     *    首先 进行首尾相连 5-> 1  并且算出长度 len  
     *    然后遍历 i =1  到 i <len - k % len,  因为k有可能太大是len的倍数 所以要k%len
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        ListNode index = head;
        int len=1;
        while(index.next!=null){
            index=index.next;
            len++;
        }
        index.next=head;
        for(int i =1;i<len-k%len;i++){
            head= head.next;
        }
        index=head.next;
        head.next=null;
        return index;
    }
}
