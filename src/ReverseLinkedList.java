import java.util.Stack;

public class ReverseLinkedList {
    static void reverseLinkedList(SingleLinkedList linkedList) {
        printSSL(linkedList);
        Stack<SingleLinkedList> stack = new Stack<>();
        while (linkedList != null) {
            stack.push(linkedList);
            linkedList = linkedList.next;
        }
        SingleLinkedList reLinkedList = stack.pop();
        SingleLinkedList headRe = reLinkedList;
        while (!stack.isEmpty()) {
            reLinkedList.next = stack.pop();
            reLinkedList = reLinkedList.next;
        }
        reLinkedList.next = null;
        printSSL(headRe);
    }

    static void printSSL(SingleLinkedList linkedList) {
        System.out.println();
        while (linkedList != null) {
            System.out.print(linkedList.no + " ");
            linkedList = linkedList.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList1 = new SingleLinkedList("1");
        SingleLinkedList linkedList2 = new SingleLinkedList("2");
        SingleLinkedList linkedList3 = new SingleLinkedList("3");
        SingleLinkedList linkedList4 = new SingleLinkedList("4");
        SingleLinkedList linkedList5 = new SingleLinkedList("5");
        SingleLinkedList linkedList6 = new SingleLinkedList("6");
        linkedList1.setNext(linkedList2);
        linkedList2.setNext(linkedList3);
        linkedList3.setNext(linkedList4);
        linkedList4.setNext(linkedList5);
        linkedList5.setNext(linkedList6);
        reverseLinkedList(linkedList1);
    }

}

class SingleLinkedList {
    public String no;
    public SingleLinkedList next;

    public SingleLinkedList(String no) {
        this.no = no;
    }

    public void setNext(SingleLinkedList next) {
        this.next = next;
    }
}
