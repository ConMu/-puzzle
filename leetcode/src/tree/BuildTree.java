package tree;

import java.util.HashMap;

/*https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/*/
public class BuildTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map1.put(inorder[i], i);
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map2.put(preorder[i], i);
        }
        root = getTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,map1,map2);
        return root;

    }

    private static TreeNode getTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int value = preorder[preLeft];
        //System.out.println(value);
        TreeNode node = new TreeNode(value);
        int valueIndex = map1.get(value);
        node.left = getTree(preorder, preLeft + 1, preLeft+valueIndex-inLeft, inorder, inLeft, valueIndex-1,map1,map2);
        node.right = getTree(preorder, preLeft + valueIndex - inLeft + 1, preRight, inorder, valueIndex + 1, inRight, map1, map2);
        return node;
    }



    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        buildTree(pre, in);
    }
}
