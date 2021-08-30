import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode17 {
    public static HashMap<Character, ArrayList<String>> numberMap = new HashMap<>();

    static {
        numberMap.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        numberMap.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        numberMap.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        numberMap.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        numberMap.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        numberMap.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        numberMap.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        numberMap.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }

    public List<String> letterCombinations(String digits) {
        char[] digitsChars = digits.toCharArray();
        if (digitsChars.length == 0) {
            return new ArrayList<>();
        }
        List<String> temp = numberMap.get(digitsChars[0]);
        List<String> res = genStr(temp, 1, digitsChars);
        return res;
    }

    List<String> genStr(List<String> temp, int n, char[] nums) {
        if (n == nums.length) {
            return temp;
        }
        char curNumber = nums[n];
        List<String> nextList = new ArrayList<>();
        ArrayList<String> chars = numberMap.get(curNumber);
        for (String charstr : chars) {
            for (String x : temp) {
                x += x + charstr;
                nextList.add(x);
            }
        }
        return genStr(nextList, n + 1, nums);
    }

}
