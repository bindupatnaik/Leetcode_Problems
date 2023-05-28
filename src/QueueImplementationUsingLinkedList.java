public class QueueImplementationUsingLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode front;
    public ListNode rear;

    public QueueImplementationUsingLinkedList(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        if (front==null && rear == null)
            return true;
        return false;
    }

    public void enqueue(int data){
        ListNode node = new ListNode(data);
        if (front==null){
            front = node;
            rear = node;
        }else{
            rear.next = node;
            rear = rear.next;
        }
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int data = front.val;;
        front = front.next;
        if (front==null){
            rear = null;
        }
        return data;
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        return front.val;
    }

    public void display(){
        ListNode curr = front;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImplementationUsingLinkedList obj = new QueueImplementationUsingLinkedList();
        obj.enqueue(20);
        obj.enqueue(30);
        System.out.println("peek element is : "+obj.peek());
        System.out.println("dequeu element is :"+obj.dequeue());
        System.out.println("peek is :"+ obj.peek());
        obj.enqueue(40);
        obj.enqueue(50);
        obj.display();
        System.out.println("dequeu element is :"+obj.dequeue());
        System.out.println("dequeu element is :"+obj.dequeue());
        System.out.println("dequeu element is :"+obj.dequeue());
        System.out.println("peek element is :"+obj.peek());
        System.out.println("deque element is :"+obj.dequeue());

    }


}
