import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode51 {

    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        List<List<String>> boxes = leetcode51.solveNQueens(3);
        for (List<String> box : boxes) {
            for (String line : box) {
                System.out.println(line);
            }
            System.out.println("====================");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> queenIdxs = new ArrayList<>();
        int[] array = new int[n];
        check(n, queenIdxs, 0, array);
        return print(queenIdxs, n);
    }

    private List<List<String>> print(List<List<Integer>> idxs, int n) {
        List<List<String>> boxes = new ArrayList<>();
        for (List<Integer> idx : idxs) {
            List<String> box = new ArrayList<>();
            for (Integer id : idx) {
                StringBuffer origin = new StringBuffer();
                for (int i = 0; i < n; i++) {
                    if (i == id) {
                        origin.append("Q ");
                    } else {
                        origin.append(". ");
                    }
                }
                String line = origin.toString().trim();
                box.add(line);
            }
            boxes.add(box);
        }
        return boxes;
    }

    private void check(int n, List<List<Integer>> queenIdxs, int nowIdx, int[] array) {
        if (nowIdx == n) {
            queenIdxs.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
            return;
        }
        for (int k = 0; k < n; k++) {
            array[nowIdx] = k;
            if (judge(array, nowIdx)) {
                check(n, queenIdxs, nowIdx + 1, array);
            }
        }
    }

    public boolean judge(int[] nowList, int nowIdx) {
        for (int i = 0; i < nowIdx; i++) {
            if (nowList[i] == nowList[nowIdx] || (Math.abs(nowIdx - i) == Math.abs(nowList[i] - nowList[nowIdx]))) {
                return false;
            }
        }
        return true;
    }


}
