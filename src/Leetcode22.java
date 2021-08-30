import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        leetcode22.generateParenthesis(2);
    }

    public List<String> generateParenthesis(int n) {
        res.clear();
        dfs(n, 0, 0, "");
        System.out.println(res.size());
        return res;
    }

    public void dfs(int n, int lc, int rc, String str) {
        if (lc == n && rc == n) {
            res.add(str);
        }

        if (lc < n) {
            System.out.println("debug一: "+lc+": "+rc+":"+str);
            dfs(n, lc + 1, rc, str + "(");
            System.out.println("一：递归返回后");
        }
        System.out.println("debug二: "+lc+": "+rc+":"+str);
        if (lc > rc && rc < n) {
            dfs(n, lc, rc + 1, str + ")");
            System.out.println("debug三: "+lc+": "+rc+":"+str);
        }

    }
}
