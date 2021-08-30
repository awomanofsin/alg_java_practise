import java.util.HashSet;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> charSet = new HashSet<>();
        int begin = 0;
        int len = 0;
        int max = 0;
        while (begin < chars.length) {
            for (int i = begin; i < chars.length; i++) {
                boolean notRepeat = charSet.add(chars[i]);
                if (notRepeat) {
                    len++;
                    max = Math.max(len, max);
                    continue;
                } else {
                    charSet.clear();
                    begin++;
                    len = 0;
                    break;
                }
            }
        }
        return max;

    }
}
