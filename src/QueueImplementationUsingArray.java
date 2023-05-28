import java.util.Arrays;
//Queue is
public class QueueImplementationUsingArray {
    int[] queue ;
    int capacity;
    int front;
    int rear;

    public QueueImplementationUsingArray(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        if (front==-1 && rear==-1)
            return true;
        return false;
    }

    public boolean isFull(){
        if (rear == capacity-1)
            return true;
        return false;
    }
    //Time - O(1)
    public void enqueue(int data){
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }else if (front == -1 && rear == -1){
            front++;
            rear++;
            queue[rear] = data;
        }else{
            rear++;
            queue[rear] = data;
        }
    }
    //Time - O(1)
    public int dequeu(){
        int data  = -1;
        if (isEmpty()){
            System.out.println("Queue is empty");
            return data;
        }else if(front == rear){
            data = queue[front];
            front = -1;
            rear = -1;
        }else{
            data = queue[front];
            front++;
        }
        return data;
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }
        for(int i=front;i<rear+1;i++){
            System.out.print(queue[i]+" ");
        }
    }
    //Time - O(1)
    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return queue[front];
    }

    public static void main(String[] args) {
        QueueImplementationUsingArray obj = new QueueImplementationUsingArray(5);
        obj.enqueue(5);
        obj.enqueue(10);
        obj.enqueue(15);
        obj.enqueue(20);
        obj.enqueue(25);
        obj.enqueue(30);
        System.out.println(obj.peek());
        obj.display();
        System.out.println(obj.dequeu());
        System.out.println(obj.dequeu());
        System.out.println(obj.dequeu());
        System.out.println(obj.dequeu());
        System.out.println(obj.dequeu());
        System.out.println(obj.dequeu());
        obj.enqueue(30);
        System.out.println(obj.peek());



    }

}
