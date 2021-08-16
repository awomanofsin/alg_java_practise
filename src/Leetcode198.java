public class Leetcode198 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] fn = new int[nums.length];
        fn[0] = nums[0];
        fn[1] = nums[1];
        int max = Math.max(fn[0], fn[1]);
        if(nums.length == 3){
            max = Math.max(nums[0]+nums[2],nums[1]);
        }
        if (nums.length > 3) {
            fn[2] = nums[0] + nums[2];
            for (int i = 3; i < nums.length; i++) {
                fn[i] = Math.max(fn[i - 2], fn[i - 3]) + nums[i];
                max = Math.max(fn[i], fn[i - 1]);
            }
        }
        return max;
    }
}
