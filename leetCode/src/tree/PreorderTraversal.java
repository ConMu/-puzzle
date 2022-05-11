package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        return list;

    }

    private void dfs(TreeNode root,  List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        dfs(root.left, list);
        dfs(root.right, list);

    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
