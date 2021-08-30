import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Leetcode12 {
    static HashMap<Integer, String> StrNum = new HashMap<>();

    static {
        StrNum.put(1, "I");
        StrNum.put(2, "II");
        StrNum.put(3, "III");
        StrNum.put(4, "IV");
        StrNum.put(5, "V");
        StrNum.put(50, "L");
        StrNum.put(10, "X");
        StrNum.put(9, "IX");
        StrNum.put(40, "XL");
        StrNum.put(90, "XC");
        StrNum.put(100, "C");
        StrNum.put(400, "CD");
        StrNum.put(500, "D");
        StrNum.put(900, "CM");
        StrNum.put(1000, "M");
    }

    public String intToRoman(int num) {
        ArrayList<Integer> IntsList = new ArrayList<>();
        Integer[] arr = new Integer[StrNum.keySet().size()];
        arr = StrNum.keySet().toArray(arr);
        IntsList.addAll(Arrays.asList(arr));

        IntsList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((int) o1 > (int) o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        // 从Map中获取减去最大的那个值
        // 循环到最后，一直为0
        int x = num;
        StringBuffer str = new StringBuffer();
        while (x > 0) {
            for (int i = 0; i < IntsList.size(); i++) {
                if (IntsList.get(i) <= x) {
                    str.append(StrNum.get(IntsList.get(i)));
                    x -= IntsList.get(i);
                    break;
                }
            }
        }
        return str.toString();
    }
}
