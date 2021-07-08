import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        String experission = "8/2*5+8/4+7";
        char[] chars = experission.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> operStack = new Stack<>();
        for (int index = 0; index < chars.length; index++) {
            int cur = chars[index];
            // 数字直接入栈
            if (!isOper(cur)) {
                numStack.push(Character.digit(cur , 10));
            }
            // 符号
            if (isOper(cur)) {
                if (operStack.isEmpty()) {
                    operStack.push(cur);
                } else {
                    if (getPriority(cur) > getPriority(operStack.peek())) {
                        // 如果当前的操作符优先级>栈中的优先级，则压栈
                        operStack.push(cur);
                    } else {
                        // 如果当前的操作符优先级 <= 栈中的优先级，则从数字栈中取出两个数字，计算后在压栈
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int oper = operStack.pop();
                        int newNum = cal(num2, num1, oper);
                        numStack.push(newNum);
                        operStack.push(cur);
                    }
                }
            }
        }
        int num1 = numStack.pop();
        int num2 = 0;
        int res = 0;
        while (numStack.size()>=1) {
            num2 = numStack.pop();
            int oper = operStack.pop();
            res = cal(num2, num1, oper);
            num1 = res;
        }
        System.out.println(res);
    }

    // 判断是不是操作符
    public static boolean isOper(int oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    // 得到优先级
    public static int getPriority(int oper) {
        if (oper == '+' || oper == '-') {
            return 0;
        }
        if (oper == '*' || oper == '/') {
            return 1;
        }
        return -1;
    }

    // 计算
    public static int cal(int num1, int num2, int oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }


}
