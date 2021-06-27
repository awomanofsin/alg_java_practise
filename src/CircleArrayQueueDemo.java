public class CircleArrayQueueDemo {
}

class CircleArray {
    private int maxSize; // 表示数组的最大容量
    // front 指向队列的第一个元素，也就是说arr[front]
    // front的初始值 = 0
    private int front;
    // rear 指向队列的最后一个元素的后一个位置
    // rear 的初始值 = 0
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
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
        rear = (rear+1)%maxSize;
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