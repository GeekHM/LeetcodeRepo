package whm.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-19 09:43
 **/

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class Code_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
//        if (head == null) return null;
//        ListNode p = head;
//        int length = 1;
//        while (p.next != null) {
//            p = p.next;
//            ++length;
//        }
//        length -= k;
//        p = head;
//        while (length > 0) {
//            p = p.next;
//            --length;
//        }
//        return p;
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        int length = 2, halfLength = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            length += 2;
            halfLength++;
        }
        if (fast == null) {//1 2 3 4 5
            length--;
        }
        int n = length - k;
        if (n + 1 == halfLength) return slow;
        if (n == 0) return head;
        if (n >= halfLength) {
            int temp = n - halfLength;
            while (temp != 0) {
                temp--;
                slow = slow.next;
            }
            return slow.next;
        } else {
            while (n > 1) {
                head = head.next;
                n--;
            }
            return head.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
