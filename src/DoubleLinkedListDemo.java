import java.util.Scanner;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedNode head = new DoubleLinkedNode(1, "宋江");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(head);
        DoubleLinkedNode node2 = new DoubleLinkedNode(2, "卢俊义");
        DoubleLinkedNode node4 = new DoubleLinkedNode(4, "likui");
        DoubleLinkedNode node3 = new DoubleLinkedNode(3, "林冲");
        DoubleLinkedNode node5 = new DoubleLinkedNode(5, "鲁智深");

        doubleLinkedList.add(node2);
        doubleLinkedList.add(node5);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node3);
        doubleLinkedList.printDoubleLinkedList();
    }
}

class DoubleLinkedList {
    private DoubleLinkedNode head;

    DoubleLinkedList(DoubleLinkedNode head) {
        this.head = head;
    }

    public void printDoubleLinkedList() {
        DoubleLinkedNode node = head;
        while (node != null) {
            System.out.printf(" %d, %s", node.no, node.name);
            node = node.next;
        }
        System.out.println();
    }

    public void add(DoubleLinkedNode node) {
        DoubleLinkedNode curNode = head;
        if (head.no > node.no) {
            node.next = head;
            head.pre = node;
            head = node;
            return;
        }
        DoubleLinkedNode tail = head;
        Boolean flag = false;
        while (curNode != null) {
            if (curNode.no > node.no) {
                flag = true;
                break;
            }
            if (curNode.next == null) {
                tail = curNode;
            }
            curNode = curNode.next;
        }
        // 如果有比新增节点序号大的节点
        if (flag) {
            node.pre = curNode.pre;
            curNode.pre.next = node;
            curNode.pre = node;
            node.next = curNode;
        } else {
            // 如果没有，就放在队尾
            tail.next = node;
            node.pre = tail;
        }
    }

    public void del(DoubleLinkedNode node) {
        DoubleLinkedNode curNode = head;
        Boolean flag = false;
        while (curNode != null) {
            if (curNode.no == node.no) {
                flag = true;
                break;
            }
            curNode = curNode.next;
        }
        if (flag) {
            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
            System.out.printf("删除成功 %d, %s \n", node.no, node.name);
        } else {
            System.out.printf("双向链表中没有该数据，请检查～ %d %s \n", node.no, node.name);
        }
    }

    public void modify(DoubleLinkedNode node) {
        DoubleLinkedNode curNode = head;
        Boolean flag = false;
        while (curNode != null) {
            if (curNode.no == node.no) {
                flag = true;
                break;
            }
            curNode = curNode.next;
        }
        if (flag) {
            node.next = curNode.next;
            node.pre = curNode.pre;
            curNode.pre.next = node;
            curNode.next.pre = node;
            System.out.printf("修改成功 %d, %s \n", node.no, node.name);
        } else {
            System.out.printf("双向链表中没有该节点，请检查～ %d %s \n", node.no, node.name);
        }
    }

    public void search(DoubleLinkedNode node) {
        DoubleLinkedNode curNode = head;
        Boolean flag = false;
        while (curNode != null) {
            if (curNode.no == node.no) {
                flag = true;
                break;
            }
            curNode = curNode.next;
        }
        if (flag) {
            node.next = curNode.next;
            node.pre = curNode.pre;
            curNode.pre.next = node;
            curNode.next.pre = node;
            System.out.printf("修改成功 %d, %s \n", node.no, node.name);
        } else {
            System.out.printf("双向链表中没有该节点，请检查～ %d %s \n", node.no, node.name);
        }
    }
}

class DoubleLinkedNode {
    public Integer no;
    public String name;
    public DoubleLinkedNode pre;
    public DoubleLinkedNode next;

    public DoubleLinkedNode(Integer no, String name) {
        this.no = no;
        this.name = name;
    }
}