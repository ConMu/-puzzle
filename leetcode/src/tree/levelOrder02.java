package tree;

public class levelOrder02 {
//    class Solution {
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            Queue<TreeNode> queue = new LinkedList<>();
//            List<List<Integer>> res = new ArrayList<>();
//            if(root != null) queue.add(root);
//            while(!queue.isEmpty()){
//                List<Integer> tmp = new ArrayList<>();
//                for(int i = queue.size();i > 0; i--) {
//                    TreeNode node = queue.poll();
//                    // TreeNode node = queue.poll();
//                    tmp.add(node.val);
//                    if(node.left != null) queue.add(node.left);
//                    if(node.right != null) queue.add(node.right);
//                }
//                res.add(tmp);
//            }
//            return res;
//            // Queue<TreeNode> queue = new LinkedList<>();
//            // List<List<Integer>> res = new ArrayList<>();
//            // if(root != null) queue.add(root);
//            // while(!queue.isEmpty()) {
//            //     List<Integer> tmp = new ArrayList<>();
//            //     for(int i = queue.size(); i > 0; i--) {
//            //         TreeNode node = queue.poll();
//            //         tmp.add(node.val);
//            //         if(node.left != null) queue.add(node.left);
//            //         if(node.right != null) queue.add(node.right);
//            //     }
//            //     res.add(tmp);
//            // }
//            // return res;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//            // List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
//
//            // Queue<TreeNode> s1 = new LinkedList<TreeNode>();
//            // Queue<TreeNode> s2 = new LinkedList<TreeNode>();
//            // s1.add(root);
//            // while (!(s1.isEmpty() || s2.isEmpty())){
//            //     ArrayList<Integer> arr1 = new ArrayList<>();
//            //     ArrayList<Integer> arr2 = new ArrayList<>();
//            //     while(!s1.isEmpty()){
//            //         TreeNode node = s1.po11();
//            //         s2.add(node.left);
//            //         s2.add(node.right);
//
//            //         arr1.add(node.val);
//            //     }
//            //     while(!s2.isEmpty()){
//            //         TreeNode node = s2.po11();
//            //         s1.add(node.left);
//            //         s1.add(node.right);
//
//            //         arr2.add(node.val);
//            //     }
//
//            // }
//            // return res;
//
//        }
//    }
}
