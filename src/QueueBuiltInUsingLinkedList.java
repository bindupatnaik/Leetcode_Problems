import java.util.LinkedList;
import java.util.Queue;
//basic functions of Queue
//1. insert at tail
//2. delete at front
//3. peek at front
public class QueueBuiltInUsingLinkedList {


//    Summary of Queue methods
//            Throws exception	Returns special value
//    Insert	    add(e)	        offer(e)
//    Remove	    remove()	    poll()
//    Examine	    element()	    peek()


    public static void main(String[] args) {
        //here Linked List acting as Queue as we are using Queue interface,  runtime polymorphism.
        //it is dynamic in nature
        Queue<String> queue = new LinkedList<>();
        //LinkedList ll = new LinkedList();
        queue.add("Bindu");//insert at tail
        queue.add("Siri");
        queue.add("Praveen");
        System.out.println(queue);
        System.out.println("peek element "+queue.peek());
        //delete at front - remove() or poll(). there is nothing like remove at particular index.
        //its always from front.
        String front = queue.remove();
        System.out.println("removed element "+front);
        //add element from end
        queue.offer("Yahaan");
        System.out.println(queue);
        //remove from front
        front = queue.poll();
        System.out.println("polled element "+front);
        System.out.println("front element without deleting "+ queue.element());
        //remove from front
        front = queue.remove();
        System.out.println("removed element " +front);
        //remove from front
        front = queue.poll();
        System.out.println("removed element " +front);
    }
}
