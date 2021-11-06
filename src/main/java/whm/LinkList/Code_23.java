package whm.LinkList;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-24 12:50
 **/

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Code_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) //特判
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);//优先队列，按照值从小到大排序
        ListNode newHead = new ListNode(-1); //排序后的链表的头节点
        ListNode l1 = newHead;
        for (ListNode i : lists)    //将链表数组中每个链表加入队列中
            if (i != null)
                queue.add(i);
        while (!queue.isEmpty()) {
            l1.next = queue.poll(); //将链表数组中最小的值的那整个链表弹出
            l1 = l1.next;   //遍历下一个节点
            if (l1.next != null)    //如果该链表不为空
                queue.add(l1.next); //将该链表下一个值加入队列
        }
        return newHead.next;


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
