import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode401 {

    public static void main(String[] args) {
        Leetcode401 l401 = new Leetcode401();
        l401.readBinaryWatch(5);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        int hCnt = 0;
        HashMap<String, Integer> hourMap = generateHourMap();
        HashMap<String, Integer> minuteMap = generateMinuteMap();
        ArrayList<String> res = new ArrayList<>();
        for (; hCnt <= turnedOn; hCnt++) {
            int mCnt = turnedOn - hCnt;
            for (int i = 0; i <= 11; i++) {
                if (hCnt == getOneCnt(i)) {
                    for (int k = 0; k <= 59; k++) {
                        if (mCnt == getOneCnt(k)) {
                            StringBuffer time = new StringBuffer();
                            time.append(String.valueOf(i));
                            time.append(":");
                            time.append(String.format("%02d",k));
                            res.add(time.toString());
                        }
                    }
                }
            }
//            for (String hour : hourMap.keySet()) {
//                if (hourMap.get(hour).equals(hCnt)) {
//                    StringBuffer time = new StringBuffer();
//                    for (String minute : minuteMap.keySet()) {
//                        if (minuteMap.get(minute).equals(mCnt)) {
//                            time.append(hour);
//                            time.append(":");
//                            time.append(minute);
//                            res.add(time.toString());
//                            time = new StringBuffer();
//                        }
//                    }
//                }
//            }
        }
        return res;
    }

    public static HashMap<String, Integer> generateHourMap() {
        HashMap<String, Integer> hourMap = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            hourMap.put(String.valueOf(i), getOneCnt(i));
        }
        return hourMap;
    }

    public static HashMap<String, Integer> generateMinuteMap() {
        HashMap<String, Integer> minuteMap = new HashMap<>();
        for (int i = 0; i < 59; i++) {
            minuteMap.put(String.format("%02d", i), getOneCnt(i));
        }
        return minuteMap;
    }

    public static int getOneCnt(int k) {
        String bits = Integer.toBinaryString(k);
        char[] charArr = bits.toCharArray();
        int cnt = 0;
        for (char each : charArr) {
            if (each == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
