package nums;

import java.util.HashMap;
import java.util.Map;

/*根据一棵树的前序遍历与中序遍历构造二叉树。*/
public class buildTree {
    /*Definition for a binary tree node.*/
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /*public Map<Integer,Integer> map;//存储中序遍历的字典
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len = preorder.length;
            map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(inorder[i],i);
            }
            return myBuildTree(preorder,inorder,0,len-1,0,len-1);

        }

        private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_l, int preorder_r, int inorder_l, int inorder_r) {
            if (preorder_l > preorder_r){
                return null;
            }
            int preorder_root = preorder_l;
            int inorder_root = map.get(preorder[preorder_root]);
            TreeNode root = new TreeNode(inorder[inorder_root]);
            int left_size = inorder_root - inorder_l;
            root.left = myBuildTree(preorder,inorder,preorder_l+1,preorder_l + left_size,inorder_l,inorder_root-1);
            root.right = myBuildTree(preorder,inorder,preorder_l+left_size+1,preorder_r,inorder_root+1,inorder_r);
            return root;
        }*/
        Map<Integer,Integer> map;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len =inorder.length;
            map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(inorder[i],i);
            }
            return myBuildTree(preorder,0,len-1,inorder,0,len-1);
        }

        private TreeNode myBuildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
            if (preLeft > preRight) {
                return null;
            }
            int inRoot = map.get(preorder[preLeft]);
            int size = inRoot - inLeft;
            TreeNode root = new TreeNode(preorder[preLeft]);
            root.left = myBuildTree(preorder,preLeft + 1,preLeft + size ,inorder,inLeft,inRoot - 1);
            root.right = myBuildTree(preorder,preLeft +size +1,preRight,inorder,inRoot+1,inRight);
            return root;
        }
    }



}
