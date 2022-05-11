package pro05;

public class IsFull {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

//    public static boolean isFull(Node head){
//        Info info = process(head);
//        int size = info.size;
//        int height = info.height;
//        return size == (1 << height) - 1;
//    }
//
//    public static class Info{//存储一个类，记录节点的信息
//        public int size;
//        public int height;
//
//        public Info(int s ,int h){
//            size = s;
//            height = h;
//        }
//    }
//
//    public static  Info process(Node x){//上下节点递归推导
//        if (x == null){
//            return new Info(0,0);
//        }
//        Info leftInfo = process(x.left);
//        Info rightInfo = process(x.right);
//        int size = leftInfo.size + rightInfo.size + 1;
//        int heigth = Math.max(leftInfo.height,rightInfo.height) + 1;
//        return new Info(size,heigth);
//    }
//

//    public static class Info{
//        public boolean isBalanced;
//        public int height;
//        public Info(boolean is ,int h){
//            isBalanced = is;
//            height = h;
//        }
//    }
//
//    public static Info process(Node x){
//        if (x == null){
////            return new Info(true,0);
//            return null;
//        }
//        Info leftInfo = process(x.left);
//        Info rightInfo = process(x.right);
//
//
////        int height = 1;
//        int subTreeHeight = 0;
//        if (leftInfo != null){
//            subTreeHeight = leftInfo.height;
//        }
//        if (rightInfo != null){
//            subTreeHeight = Math.max(subTreeHeight,rightInfo.height);
//        }
//        int height = 1 +subTreeHeight;
//        boolean isBalanced = true;
//        if (leftInfo != null && !leftInfo.isBalanced){
//            isBalanced = false;
//        }
//        if (rightInfo != null && !rightInfo.isBalanced){
//            isBalanced = false;
//        }
//
//        int leftH = leftInfo != null ? leftInfo.height : 0;
//        int rightH = rightInfo != null ?rightInfo.height : 0;
//        if (Math.abs(leftH - rightH) > 1){
//            isBalanced =false;
//        }
//        return new Info(isBalanced,height);
//    }

//    //二叉树最大距离
//
//    public static int maxDistance(Node head){
//        Info info = process(head);
//        return info.maxDistance;
//    }
//
//    public static class Info {
//        public int maxDistance;
//        public int height;
//
//        public Info(int d, int h) {
//            maxDistance = d;
//            height = h;
//        }
//    }
//
//    public static Info process(Node x) {
//        if (x == null) {
//            return new Info(0, 0);
//        }
//        Info leftInfo = process(x.left);
//        Info rightInfo = process(x.right);
//        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
//
//        int maxDistance = Math.max(leftInfo.height + rightInfo.height + 1,Math.max(leftInfo.maxDistance,rightInfo.maxDistance));
//
//        return new Info(maxDistance,height);
//    }




    public static void main(String[] args) {

    }
}
