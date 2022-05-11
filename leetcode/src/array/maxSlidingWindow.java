package array;

public class maxSlidingWindow {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums.length == 0 || k == 0 ) return new int[0];
//        Deque<Integer>  deque = new LinkedList<>();
//        int[] res = new int[nums.length - k +1];
//
//        for(int j = 0,i = 1-k;j<nums.length;i++,j++) {
//
//            if(i > 0 && deque.peekFirst() == nums[i-1]) {
//                deque.removeFirst();//我队列中的第一个元素正好被滑过去了，讲这个元素去除
//            }
//            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
//                deque.removeLast();
//            }//我新来的比你队列中最后一个大，那你队列中的最后一个肯定不会是最大值，所以把它remove了
//            deque.addLast(nums[j]);
//            if(i >=0) res[i] = deque.peekFirst();
//        }
//        // for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
//        //     // 删除 deque 中对应的 nums[i-1]
//        //     if(i > 0 && deque.peekFirst() == nums[i - 1])
//        //         deque.removeFirst();
//        //     // 保持 deque 递减
//        //     while(!deque.isEmpty() && deque.peekLast() < nums[j])
//        //         deque.removeLast();
//        //     deque.addLast(nums[j]);
//        //     // 记录窗口最大值
//        //     if(i >= 0)
//        //         res[i] = deque.peekFirst();
//        // }
//
//        return res;
//    }
}
