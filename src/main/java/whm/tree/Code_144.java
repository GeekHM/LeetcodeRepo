package whm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-18 12:50
 **/
public class Code_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preOrder(root,list);
        return list;
    }

    public void preOrder(TreeNode root,List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
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
