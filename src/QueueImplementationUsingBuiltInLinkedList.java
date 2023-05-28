import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementationUsingBuiltInLinkedList {
    Queue<Integer> queue;
    public QueueImplementationUsingBuiltInLinkedList(){
        queue = new LinkedList<>();
    }

    public void enqueue(int data){
        queue.add(data);
    }

    public int dequeue(){
        if (queue.isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        return queue.poll();
    }

    public int peek(){
        if(queue.isEmpty()){
            System.out.println("queue is empty peek");
            return -1;
        }
        return queue.peek();
    }

    public void display(){
        System.out.println(queue);
    }

    public static void main(String[] args) {
        QueueImplementationUsingBuiltInLinkedList obj = new QueueImplementationUsingBuiltInLinkedList();
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        System.out.println(obj.peek());
        System.out.println(obj.dequeue());
        System.out.println(obj.peek());

        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
    }


}
