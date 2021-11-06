package whm.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-23 15:05
 **/

import org.junit.Test;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 1 3 5 7 9
 */
public class Code_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**法一：第一次想到的
         * if (head.next == null) {
         *             return null;
         *         }
         *         ListNode fast = head.next, slow = head;
         *         int tempSlow = 1, tempFast = 2;
         *         while (fast != null && fast.next != null) {
         *             slow = slow.next;
         *             fast = fast.next.next;
         *             ++tempSlow;
         *             tempFast += 2;
         *         }
         *         if (fast == null) {
         *             --tempFast;
         *         }
         *         if (tempFast - n >= tempSlow) {  1 2 3 4 5
         *             int temp = tempFast - n - tempSlow;
         *             while (temp > 0) {
         *                 slow = slow.next;
         *                 --temp;
         *             }
         *             slow.next = slow.next.next;
         *         } else {
         *             int temp = tempFast - n;
         *             if(temp==0) return head.next;
         *             slow = head;
         *             while (temp > 1) {
         *                 slow = slow.next;
         *                 --temp;
         *             }
         *             slow.next = slow.next.next;
         *         }
         *         return head;
         */
        //法二：
        ListNode node = new ListNode(0, head), p = node;
        while (n > 1) {
            head = head.next;
            --n;
        }
        while (head.next != null) {
            head = head.next;
            p = p.next;
        }
        p.next = p.next.next;
        return node.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
