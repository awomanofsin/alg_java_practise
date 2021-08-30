public class Leetcode8 {

    public static void main(String[] args) {
        Leetcode8 leetcode8 = new Leetcode8();
        int res = leetcode8.myAtoi("-+12");
        System.out.println(res);
    }

    public int myAtoi(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        if(chars.length==0){
            return 0;
        }
        int i = 0;
        StringBuffer num = new StringBuffer();
        while (i < chars.length) {

            if (i == 0 && !isZhengfu(chars[i]) && !isDigit(chars[i])) {
                // 开头是其他字符
                return 0;
            }
            if (!isDigit(chars[i]) && i > 0) {
                return parseInt(num.toString());
            }
            if (isZhengfu(chars[i]) || isDigit(chars[i])) {
                num.append(chars[i]);
            }
            i++;
        }
        return parseInt(num.toString());
    }

    public Integer parseInt(String str) {
        try {
            if (str.length() == 1 && isZhengfu(str.toCharArray()[0])) {
                return 0;
            }
            Integer temp = Integer.parseInt(str.toString());
            return temp;
        } catch (
                Exception e) {
            if (str.toString().startsWith("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public boolean isZhengfu(char charx) {
        return (charx == '-' || charx == '+');
    }

    public boolean isDigit(char charx) {
        return (charx <= '9' && charx >= '0');
    }
}
