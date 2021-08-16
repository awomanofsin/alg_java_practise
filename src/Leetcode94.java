import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode94 {
    public static void main(String[] args) {
        Leetcode94 leetcode94 = new Leetcode94();
        TreeNode test1 = TreeNode.testCase1();
        TreeNode test2 = TreeNode.testCase2();
        leetcode94.inorderTraversal(test1);
//        leetcode94.inorderTraversal(test2);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode node = root;
        while (!stk.isEmpty() || node != null) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
            System.out.println("debug:==="+stk.peek().val);
            TreeNode y = stk.pop();
            res.add(y.val);
            System.out.println(y.val);
            if(y.right!=null){
                node = y.right;
            }
        }
        return res;
    }

}
