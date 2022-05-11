package nums.oneLevelNum;

public class ReversePairs {
    public static int reversePairs(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        int c = reverse(copy, 0, nums.length - 1);
        return c;



    }
    public static int reverse(int[] nums,int l, int r){
        if(l == r) {
            return 0;
        }
        int mid = l + (r-l)/2;
        int leftNum = reverse(nums, l, mid);
        int rightNum = reverse(nums, mid+1, r);

        if(nums[mid] <= nums[mid+1]){
            return leftNum + rightNum;
        }
        int mergeNum = merge(nums,l,mid,r);
        return leftNum + rightNum + mergeNum;
    }

    public static int merge(int[] nums , int l, int mid ,int r){
        int[] tmp = new int[r-l+1];
        int i = l;
        int j = mid+1;
        int cnt = 0;

//        for (int k = 0; k < tmp.length; k++) {
//            if (i == mid + 1) {
//                tmp[k] = nums[j];
//                j++;
//            }else if (j == r + 1) {
//                tmp[k] = nums[i];
//                i++;
//            } else if (nums[i] <= nums[j]) {
//                tmp[k] = nums[i];
//                i++;
//            } else {
//                cnt += mid - i + 1;
//                tmp[k] = nums[j];
//                j++;
//            }
//        }
        int index = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[index] = nums[i];
                index++;
                i++;
            } else {
                cnt += mid - i + 1;
                tmp[index] = nums[j];
                index++;
                j++;
            }
        }
        while (i <= mid) {
            tmp[index] = nums[i];
            index++;
            i++;
        }
        while (j <= r) {
            tmp[index] = nums[j];
            index++;
            j++;
        }




        for (int k = 0; k < tmp.length; k++) {
            nums[l+k] = tmp[k];
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] res = new int[]{1,3,2,3,1};
        System.out.println(reversePairs(res));

    }
}
