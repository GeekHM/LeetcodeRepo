package LeetCode.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-23 16:37
 **/

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class Code_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0, head), p = node, pre;
        head = p;
        int i = 1;
        while (i < left) {
            head = head.next;
            ++i;
        }
        p = head.next;
        while (i < right) {//就地转置   1 2 3 4
            pre = p.next;
            p.next = pre.next;
            pre.next = head.next;
            head.next = pre;
            ++i;
        }
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
