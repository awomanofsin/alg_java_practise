public class Leetcode9 {
    public static void main(String[] args) {
        int x = -101;
        boolean res = isPalindrome(x);
        System.out.println(res);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xs = String.valueOf(x);
        char[] xcs = xs.toCharArray();
        int i = 0;
        int j = xs.length() - 1;
        while (j >= i) {
            char left = xcs[i];
            char right = xcs[j];
            if(left!=right){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
