package whm.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-13 23:45
 **/

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Code_206 {
    //法一：头插法
//    public ListNode reverseList(ListNode head) {
//        if(head==null) return null;
//        ListNode tempHead = new ListNode(0,null),pre;
//        while (head!=null){
//            pre = head.next;
//            head.next = tempHead.next;
//            tempHead.next = head;
//            head = pre;
//        }
//        return tempHead.next;
//    }
    //法二：就地逆置
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p = null, q = head, r;
        while (q.next != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return q;
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
