package whm.tree;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-20 17:28
 **/

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Code_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**法一：基本队列
         * List<List<Integer>> res = new ArrayList<List<Integer>>();
         *         if (root == null) return res;
         *         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         *         queue.add(root);
         *         int level = 1, size;
         *         TreeNode node;
         *         while (!queue.isEmpty()) {
         *             size = queue.size();
         *             List<Integer> list = new ArrayList<Integer>();
         *             while (size > 0) {
         *                 node = queue.poll();
         *                 list.add(node.val);
         *                 if (node.left != null) queue.add(node.left);
         *                 if (node.right != null) queue.add(node.right);
         *                 --size;
         *             }
         *             if (level % 2 == 0) {
         *                 Collections.reverse(list);
         *             }
         *             ++level;
         *             res.add(list);
         *         }
         *         return res;
         */

        //法二：双端队列
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 1, size;
        TreeNode node;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size > 0) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                --size;
            }
            if (level % 2 == 0) {
                Collections.reverse(list);
            }
            ++level;
            res.add(list);
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
