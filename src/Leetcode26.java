import org.w3c.dom.ls.LSOutput;

import java.util.stream.Stream;

public class Leetcode26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
//        int temp = nums[0];
//        int tempIndex = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int cur = nums[i];
//            if (cur != temp) {
//                tempIndex++;
//                nums[tempIndex] = cur;
//                temp = cur;
//            }
//        }
//        for (int k = tempIndex + 1; k < nums.length; k++) {
//            nums[k] = 0;
//        }
//        for(int each : nums){
//            System.out.print(each+" ");
//        }
//        System.out.println("----");
//        System.out.println(tempIndex);
        int n = nums.length;
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        for (int each : nums) {
            System.out.print(each + " ");
        }
    }
}
