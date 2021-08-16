import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EightQueen {

    int max = 8;
    int[] array = new int[max];
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.check(0);
        System.out.println("=====");
        System.out.println(eq.res.size());
    }

    private void check(int n) {
        if (n == max) {
            print();
            res.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }

    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int each : array) {
            System.out.print(each + " ");
        }
        System.out.println();
    }

}

