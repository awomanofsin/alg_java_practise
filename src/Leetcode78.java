import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();
        int[] nums = new int[]{1,2,3};
        leetcode78.subsets(nums);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<>();
        dfs(res,0,nums.length,nums,curList);
        return res;
    }

    void dfs(List<List<Integer>> ans, int begin, int len, int[] nums, ArrayList<Integer> curList) {


        for (int i = begin; i < len; i++) {
            curList.add(nums[i]);
            dfs(ans, i, len, nums, curList);
            curList.remove(curList.size() - 1);
        }
        if (curList.size() > 0) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        dfs(ans, begin + 1, len, nums, curList);
    }

}
