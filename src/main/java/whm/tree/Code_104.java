package whm.tree;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-17 21:16
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Code_104 {
    //法一 层次遍历求高度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node = root;
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (levelSize > 0) ++depth;
            while (levelSize > 0) {
                node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                --levelSize;
            }
        }
        return depth;
    }

    //递归求高度
    public int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        int ld = getMaxDepth(node.left);
        int rd = getMaxDepth(node.right);
        return ld > rd ? ld + 1 : rd + 1;
    }

    public class TreeNode {
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
