package problem;

import helperClass.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static <E> void main(String[] args) {
        ListNode l1= new ListNode(9);
//        l1.next=new ListNode(9);
//        l1.next.next=new ListNode(3);
        ListNode l2= new ListNode(1);
        l2.next=new ListNode(9);
        l2.next.next=new ListNode(9);
        l2.next.next.next=new ListNode(9);
        l2.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next=new ListNode(9);
        ListNode list = addTwoNumbers(l1,l2);
        System.out.println();
        System.out.println("---------------");
        while(list!=null){
            System.out.print(list.val+" ");
            list = list.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // determine which linked-list's size is bigger
        int length1=0;
        int length2=0;
        ListNode point = l1;
        while(point!=null){
            length1++;
            point = point.next;
        }
        point = l2;
        while(point!=null){
            length2++;
            point = point.next;
        }
        // sum up two list into arraylist, in  each element per digit
        ListNode bigger = l1;
        ListNode smaller = l2;
        List<Integer> list = new ArrayList<Integer>();
        if(length1<=length2){
            bigger=l2;
            smaller = l1;
        }
        
        //sumup into list
        int carry = 0;
        while(bigger!=null){
            int val = bigger.val;
            if(smaller!=null){
                val=val+smaller.val;
                smaller = smaller.next;
            }
            //deal with carry
            val=val+carry;
            if(val>=10){
                val = val%10;
                carry = 1;
            }else{
                carry = 0;
            }
            list.add(val);
            bigger = bigger.next;
        }
        if(carry==1){
            list.add(1);
        }
        ListNode root = null;
        for(int x = 0;x<=list.size()-1;x++){
            if(x==0){
                point= new ListNode((int)list.get(x));
                root=point;
            }else{
                point.next= new ListNode((int)list.get(x));
                point=point.next;
            }
        }
       
        return root;
    }

    //solution 2
    // loop two list at the same time
    //whlile(l1!=null || l2!=null){ }

}
