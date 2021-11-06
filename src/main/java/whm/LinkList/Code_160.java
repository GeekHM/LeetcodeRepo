package whm.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-14 12:48
 **/

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Code_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while(pa!=pb){
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }
        return pa;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
