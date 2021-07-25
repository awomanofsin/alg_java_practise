public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = sum;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int k = 0; k < nums.length; k++) {
            if (sum < 0) {
                sum = nums[k];
            }else{
                sum += nums[k];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
