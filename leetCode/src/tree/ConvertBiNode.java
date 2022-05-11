package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBiNode {
    public TreeNode convertBiNode(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        addToQueue(queue, root);
        return null;

    }

    private void addToQueue(Queue<TreeNode> queue, TreeNode root) {
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            addToQueue(queue, root.left);

        }

    }
}
