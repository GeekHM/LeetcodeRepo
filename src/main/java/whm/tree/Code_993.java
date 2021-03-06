package whm.tree;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-18 12:30
 **/

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 */
public class Code_993 {
    int x, y;
    int lx = 0, ly = 0;
    TreeNode px, py;
    Boolean bx = false, by = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return lx == ly && px != py;
    }

    public void dfs(TreeNode root, int level, TreeNode parent) {
        if (root == null) return;
        if (bx && by) return;
        if (root.val == x) {
            lx = level;
            px = parent;
            bx = true;
        }
        if (root.val == y) {
            ly = level;
            py = parent;
            by = true;
        }
        dfs(root.left, level + 1, root);
        dfs(root.right, level + 1, root);
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
