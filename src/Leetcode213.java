public class Leetcode213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] fn = new int[nums.length];
        fn[0] = nums[0];
        fn[1] = nums[1];
        int max = Math.max(fn[0], fn[1]);
        if (nums.length == 3) {
            max = Math.max(nums[0], nums[1]);
            max = Math.max(nums[2], max);
        }
        if (nums.length > 3) {
            int top = 0;
            fn[2] = nums[0] + nums[2];
            for (int i = 3; i < nums.length; i++) {
                if (fn[1] > fn[0]) {
                    top = 1;
                }
                fn[i] = Math.max(fn[i - 2], fn[i - 3]) + nums[i];
                if (i == nums.length - 1 && top == 0) {
                    max = fn[i - 1];
                } else {
                    max = Math.max(fn[i], fn[i - 1]);
                }
            }
        }
        return max;
    }
}
