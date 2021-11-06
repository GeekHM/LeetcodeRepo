package whm.tree;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-23 18:28
 **/

import org.junit.Test;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class Code_543 {
    public int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxLength(root);
        return maxLength    ;
    }

    public int getMaxLength(TreeNode root) {
        if (root == null) return 0;
        int left = getMaxLength(root.left);
        int right = getMaxLength(root.right);
        maxLength = left + right > maxLength ? left + right : maxLength;
        return left > right ? left + 1 : right + 1;
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
