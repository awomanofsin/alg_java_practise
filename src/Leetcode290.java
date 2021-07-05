import java.util.ArrayList;

public class Leetcode290 {
    public boolean wordPattern(String pattern, String s) {
        char[] patterns = pattern.toCharArray();
        String[] ss = s.split(" ");
        if (patterns.length != ss.length) {
            return false;
        }
        boolean res = true;
        // abbbabca
        // a b b b a b c a
        ArrayList<Integer> hasFor = new ArrayList<>();
        for(int i = 0;i<=patterns.length-1;i++){
            if(hasFor.contains(i)){
                continue;
            }
            for(int k = 1;k<=patterns.length-1;k++){
                if(patterns[i] == patterns[k] && ss[i].equals(ss[k])){
                    hasFor.add(i);
                    hasFor.add(k);
                }else if(patterns[i] != patterns[k] && !ss[i].equals(ss[k])){
                }else {
                    res = false;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "cat dog dog cat";
        Leetcode290 leetcode290 = new Leetcode290();
        boolean test = leetcode290.wordPattern(pattern,s);
        System.out.println(test);
    }
}
