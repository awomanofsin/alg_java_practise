import java.util.List;

public class Leetcode559 {
    public int maxDepth(Node root) {
        int cnt = 0;
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            for (Node each : root.children) {
                cnt = Math.max(cnt, 1 + maxDepth(each));
            }
        }
        return cnt;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}