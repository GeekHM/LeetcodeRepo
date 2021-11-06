package whm.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-20 11:02
 **/

/**
 * 对链表进行插入排序。
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 */
public class Code_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode myhead = new ListNode(0), p, pre;
        myhead.next = head;
        pre = head.next;
        head.next = null;
        head = pre;
        while (head != null) {
            p = myhead;
            while (p.next != null && head.val > p.next.val) {
                p = p.next;
            }
            pre = head.next;
            head.next = p.next;
            p.next = head;
            head = pre;
        }
        return myhead.next;
    }

    public class ListNode {
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
