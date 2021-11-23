package LeetCode.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-20 15:27
 **/

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Code_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode halfList = reverseLinkList(slow.next);
        slow.next = null;
        slow = head;
        while (slow != null && halfList != null) {
            if (slow.val != halfList.val) {
                return false;
            }
            slow = slow.next;
            halfList = halfList.next;
        }
        return true;
    }

    public ListNode reverseLinkList(ListNode head) {
        ListNode myHead = new ListNode(0, null), temp;
        while (head != null) {
            temp = head.next;
            head.next = myHead.next;
            myHead.next = head;
            head = temp;
        }
        return myHead.next;
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
