import java.util.List;

public class Leetcode2 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.testcase1();
        ListNode l2 = ListNode.testcase2();
        Leetcode2 leetcode2 = new Leetcode2();
        ListNode listNode = leetcode2.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newL1 = l1;
        ListNode newL2 = l2;

        int mod = 0;
        int remain = 0;

        ListNode newNode = null;
        ListNode lastNode = null;
        while (newL1 != null || newL2 != null) {
            int x1 = (newL1 == null) ? 0 : newL1.val;
            int x2 = (newL2 == null) ? 0 : newL2.val;

            mod = (x1 + x2) % 10;
            if (newNode == null) {
                newNode = new ListNode(mod + remain);
                lastNode = newNode;
            } else {
                int val = ((mod + remain) > 10)? (mod+remain)%10:0;
                if ((mod + remain) > 10) {
                    mod = (mod + remain) % 10;
                }
                ListNode cur = new ListNode(mod + remain);
                lastNode.next = cur;
                lastNode = cur;
            }

            remain = (mod + remain) / 10;
            newL1 = (newL1 == null) ? null : newL1.next;
            newL2 = (newL2 == null) ? null : newL2.next;
        }
        if (remain > 0) {
            ListNode tail = new ListNode(remain);
            lastNode.next = tail;
        }
        return newNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode nextNode = null;
        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

}
