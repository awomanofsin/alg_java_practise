import java.util.Scanner;

public class ArrayQueueDemo {

}

class ArrayQueue{
    private int maxSize; //表示数组的最大容量
    private int front;  //指向队列头部的前一个位置
    private int rear;   //指向队列尾的最后一个数据
    private int[] arr;  // 该数据用于存放数据，模拟队列

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 显示队列头部");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d \n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.printf("队列头部数据是 %d\n",head);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能加入数据～");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
     }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空的，没有数据～～");
            return;
        }
        for(int i=0;i < arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空的，没有数据～");
        }
        return arr[front+1];
    }

}