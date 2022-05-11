package tree;
/*https://leetcode-cn.com/problems/validate-binary-search-tree/solution/*/
public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        int maxNodeVal = getMaxVal(root.left);
//        int minNodeVal = getMinVal(root.right);
//        return isValidBST(root.left)
//                && isValidBST(root.right)
//                && root.value > maxNodeVal
//                && root.value < minNodeVal;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.value <= minValue || root.value >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.value) && isValidBST(root.right, root.value, maxValue);
    }

//    private static int getMaxVal(TreeNode node) {
//        if (node == null) {
//            return Integer.MIN_VALUE;
//        } else if (node.left == null && node.right == null) {
//            return node.value;
//        } else {
//            if (node.left == null) {
//                return Math.max(node.value, getMaxVal(node.right));
//            } else if (node.right == null) {
//                return Math.max(node.value, getMaxVal(node.left));
//            } else {
//                return Math.max(node.value, Math.max(getMaxVal(node.left), getMaxVal(node.right)));
//            }
//        }
//
//    }
//
//    private static int getMinVal(TreeNode node) {
//        if (node == null) {
//            return Integer.MAX_VALUE;
//        } else if (node.left == null && node.right == null) {
//            return node.value;
//        } else {
//            if (node.left == null) {
//                return Math.min(node.value, getMinVal(node.right));
//            } else if (node.right == null) {
//                return Math.min(node.value, getMinVal(node.left));
//            } else {
//                return Math.min(node.value, Math.min(getMinVal(node.left), getMinVal(node.right)));
//            }
//        }
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
}
