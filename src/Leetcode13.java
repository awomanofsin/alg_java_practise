public class Leetcode13 {
    public static void main(String[] args) {
        String test = "MCMXCIV";
        char[] charArr = test.toCharArray();
        int value = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (i != charArr.length - 1) {
                if ((charArr[i] == 'I' && charArr[i + 1] == 'V')) {
                    value += 4;
                    i = i + 1;
                    continue;
                }
                if ((charArr[i] == 'I' && charArr[i + 1] == 'X')) {
                    value += 9;
                    i = i + 1;
                    continue;
                }
                if ((charArr[i] == 'X' && charArr[i + 1] == 'L')) {
                    value += 40;
                    i = i + 1;
                    continue;
                }
                if ((charArr[i] == 'X' && charArr[i + 1] == 'C')) {
                    value += 90;
                    i = i + 1;
                    continue;
                }
                if ((charArr[i] == 'C' && charArr[i + 1] == 'D')) {
                    value += 400;
                    i = i + 1;
                    continue;
                }
                if ((charArr[i] == 'C' && charArr[i + 1] == 'M')) {
                    value += 900;
                    i = i + 1;
                    continue;
                }
            }
            value += getValueByRoma(charArr[i]);
        }
        System.out.println(value);
    }

    public static int getValueByRoma(char roma) {
        switch (roma) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
