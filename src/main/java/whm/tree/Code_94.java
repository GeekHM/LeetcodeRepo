package whm.tree;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-17 21:50
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class Code_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * 法一 递归
         * List<Integer> rs = new ArrayList<Integer>();
         *         inorder(root, rs);
         *         return rs;
         */

        //法二： 迭代  用栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> rs = new ArrayList<Integer>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            rs.add(root.val);
            root = root.right;
        }
        return rs;
    }

    public void inorder(TreeNode root, List<Integer> rs) {
        if (root == null) return;
        inorder(root.left, rs);
        rs.add(root.val);
        inorder(root.right, rs);
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
