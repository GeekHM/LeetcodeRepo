package whm.LinkList;
/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-19 09:15
 **/

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Code_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode();
        ListNode pre = p;
        int temp = 0, ov = 0;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + ov;
            ov = temp / 10;
            l1.val = temp % 10;
            pre.next = l1;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            temp = l1.val + ov;
            ov = temp / 10;
            l1.val = temp % 10;
            pre.next = l1;
            pre = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp = l2.val + ov;
            ov = temp / 10;
            l2.val = temp % 10;
            pre.next = l2;
            pre = l2;
            l2 = l2.next;
        }
        if(ov>0){
            ListNode listNode = new ListNode(ov);
            pre.next = listNode;
        }
        return p.next;
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
