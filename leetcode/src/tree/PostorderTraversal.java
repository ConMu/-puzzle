package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(root, list);

        return list;

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.right, list);
        dfs(root.left, list);
        list.add(root.value);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == pre) {
                list.add(root.value);
                stack.pop();
                pre = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return list;
    }



}
