package LeetCode.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-23 23:37
 **/

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Code_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head.next, slow = head, pa, pb;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = reverse(slow.next);
        slow.next = null;
        slow = head;
        while (slow != null && node != null) {
            pa = slow.next;
            pb = node.next;
            node.next = slow.next;
            slow.next = node;
            node = pb;
            slow = pa;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode node = new ListNode(0, null), pre;
        while (head != null) {
            pre = head.next;
            head.next = node.next;
            node.next = head;
            head = pre;
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
