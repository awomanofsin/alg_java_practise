import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode144 {

    public static void main(String[] args) {
        Leetcode144 leetcode144 = new Leetcode144();
        TreeNode test1 = TreeNode.testCase1();
        TreeNode test2 = TreeNode.testCase2();
        leetcode144.preorderTraversal(test2);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode node = root;
        stk.push(node);
        while (!stk.isEmpty() ) {
            TreeNode cur = stk.pop();
            System.out.println(cur.val);
            res.add(cur.val);
            if (cur.right != null) {
                stk.push(cur.right);
            }
            if (cur.left != null) {
                stk.push(cur.left);
            }
        }
        return res;
    }
}
