package tree;

public class levelOrder03 {
//    class Solution {
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            Queue<TreeNode> queue = new LinkedList<TreeNode>();
//            List<List<Integer>> res = new ArrayList<>();
//            if(root != null)queue.add(root);
//            while(!queue.isEmpty()){
//                LinkedList<Integer> tmp = new LinkedList<>();
//                for(int i = queue.size();i > 0; i--){
//                    TreeNode node = queue.poll();
//                    if((res.size()&1)==0)tmp.addLast(node.val);
//                    else tmp.addFirst(node.val);
//                    if(node.left !=null)queue.add(node.left);
//                    if(node.right !=null)queue.add(node.right);
//                }
//                res.add(tmp);
//            }
//            return res;
//        }
//    }
}
