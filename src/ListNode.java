import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.addAll(Arrays.asList(9,9,9,9,9,9,9));
        int i = 0;
        ListNode head = null; // 分配一个堆内存
        ListNode last = null;
        while (i<test.size()){
            if(head == null){
                head = new ListNode(test.get(i));
                last = head;
            }else{
                ListNode cur = new ListNode(test.get(i));
                last.next = cur;
                last = cur;
            }
            i++;
        }
    }

    public static ListNode testcase1 (){
        ArrayList<Integer> test = new ArrayList<>();
        test.addAll(Arrays.asList(9,9,9,9,9,9,9));
        int i = 0;
        ListNode head = null; // 分配一个堆内存
        ListNode last = null;
        while (i<test.size()){
            if(head == null){
                head = new ListNode(test.get(i));
                last = head;
            }else{
                ListNode cur = new ListNode(test.get(i));
                last.next = cur;
                last = cur;
            }
            i++;
        }
        return head;
    }

    public static ListNode testcase2 (){
        ArrayList<Integer> test = new ArrayList<>();
        test.addAll(Arrays.asList(9,9,9,9));
        int i = 0;
        ListNode head = null; // 分配一个堆内存
        ListNode last = null;
        while (i<test.size()){
            if(head == null){
                head = new ListNode(test.get(i));
                last = head;
            }else{
                ListNode cur = new ListNode(test.get(i));
                last.next = cur;
                last = cur;
            }
            i++;
        }
        return head;
    }

}
