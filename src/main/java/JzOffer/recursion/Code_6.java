package JzOffer.recursion;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-09 08:47
 **/

import java.util.*;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Code_6 {
    //递归
    /*private int[] res;

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        print(head, 1);
        return res;
    }

    public void print(ListNode node, int i) {
        if (node != null) {
            print(node.next, i + 1);
            res[res.length - i] = node.val;
        } else {
            res = new int[i-1];
        }
    }*/

    //非递归
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        Deque<Integer> deque = new LinkedList();
        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }
        Collections.reverse((List<?>) deque);
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
