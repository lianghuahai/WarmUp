package problem.day22;

import helperClass.ListNode;

public class Problem142 {       
    /*https://www.cnblogs.com/hiddenfox/p/3408931.html
     * 开始使用了复杂度O(n^2)的方法，使用两个指针a, b。a从表头开始一步一步往前走，遇到null则说明没有环，返回false；a每走一步，b从头开始走，如果遇到b==a.next，则说明有环true，如果遇到b==a，则说明暂时没有环，继续循环。
            后来找到了复杂度O(n)的方法，使用两个指针slow,fast。两个指针都从表头开始走，slow每次走一步，fast每次走两步，如果fast遇到null，则说明没有环，返回false；如果slow==fast，说明有环，并且此时fast超了slow一圈，返回true。
            为什么有环的情况下二者一定会相遇呢？因为fast先进入环，在slow进入之后，如果把slow看作在前面，fast在后面每次循环都向slow靠近1，所以一定会相遇，而不会出现fast直接跳过slow的情况。
            扩展问题
            在网上搜集了一下这个问题相关的一些问题，思路开阔了不少，总结如下：
            1. 环的长度是多少？
            2. 如何找到环中第一个节点（即Linked List Cycle II）？
            3. 如何将有环的链表变成单链表（解除环）？

            4. 如何判断两个单链表是否有交点？如何找到第一个相交的节点？
            首先我们看下面这张图：
            设：链表头是X，环的第一个节点是Y，slow和fast第一次的交点是Z。各段的长度分别是a,b,c，如图所示。环的长度是L。slow和fast的速度分别是qs,qf。
            下面我们来挨个问题分析。
            1. 方法一（网上都是这个答案）：
            第一次相遇后，让slow,fast继续走，记录到下次相遇时循环了几次。因为当fast第二次到达Z点时，fast走了一圈，slow走了半圈，而当fast第三次到达Z点时，fast走了两圈，slow走了一圈，正好还在Z点相遇。
            方法二：
            第一次相遇后，让fast停着不走了，slow继续走，记录到下次相遇时循环了几次。

            方法三（最简单）：

            第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。

            因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。

            我们发现L=b+c=a+b，也就是说，从一开始到二者第一次相遇，循环的次数就等于环的长度。

            2. 我们已经得到了结论a=c，那么让两个指针分别从X和Z开始走，每次走一步，那么正好会在Y相遇！也就是环的第一个节点。

            3. 在上一个问题的最后，将c段中Y点之前的那个节点与Y的链接切断即可。

            4. 如何判断两个单链表是否有交点？先判断两个链表是否有环，如果一个有环一个没环，肯定不相交；如果两个都没有环，判断两个列表的尾部是否相等；如果两个都有环，判断一个链表上的Z点是否在另一个链表上。

            如何找到第一个相交的节点？求出两个链表的长度L1,L2（如果有环，则将Y点当做尾节点来算），假设L1<L2，用两个指针分别从两个链表的头部开始走，长度为L2的链表先走(L2-L1)步，然后两个一起走，直到二者相遇。*/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;    //遇到null了，说明不存在环
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;    //第一次相遇在Z点
            }
        }

        slow = head;    //slow从头开始走，
        while (slow != fast) {    //二者相遇在Y点，则退出
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
