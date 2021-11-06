package whm.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-19 15:33
 **/

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Code_148 {//n 7 1 1 9 5 6 9

    //n 1 3 5 7 8
    //[-1,5,3,4,0]
    public ListNode sortList(ListNode head) {

        return null;
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
