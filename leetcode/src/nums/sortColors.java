package nums;

public class sortColors {
    /*给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
    并按照红色、白色、蓝色顺序排列。

    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sort-colors
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    class Solution {
        public void sortColors(int[] nums) {
            int len = nums.length;
            if (len < 2) return;

            int zero = 0,two = len,i=0;
            while(i < two){
                if (nums[i] == 0){
                    swap(nums,i,zero);
                    zero++;
                    i++;
                }else if (nums[i] ==1) {
                    i++;
                }else {
                    two--;
                    swap(nums,i,two);
                }
            }
        }

        private void swap(int[] nums, int i, int zero) {
            int tmp = nums[i];
            nums[i] = nums[zero];
            nums[zero]  = tmp;
        }

        public void main(String[] args) {
            int[] test = new int[]{2,0,2,1,1,0};

        }


    }
}
