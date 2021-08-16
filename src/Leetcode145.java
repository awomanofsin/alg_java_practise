import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode145 {
    // 后序遍历二叉树
    public static void main(String[] args) {
        Leetcode145 leetcode145 = new Leetcode145();
        TreeNode test1 = TreeNode.testCase1();
        TreeNode test2 = TreeNode.testCase2();
//        leetcode145.postorderTraversal(test1);
        leetcode145.postorderTraversal(test2);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode addstk = root;
        TreeNode saw = null;
        TreeNode prev = null;
        while (!stk.isEmpty() || addstk != null) {
            while (addstk != null) {
                stk.push(addstk);
                addstk = addstk.left;
            }

            if(stk.size() == 1){
                TreeNode node = stk.peek();
                prev = node;
            }else {
                TreeNode node = stk.pop();
                prev = stk.peek();
                res.add(node.val);
                System.out.println(node.val);
            }
            if (prev != null && prev != saw && prev.right != null) {
                addstk = prev.right;
                saw = prev;
            }
        }
        return res;
    }
}
