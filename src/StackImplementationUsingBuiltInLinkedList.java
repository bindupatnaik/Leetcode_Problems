import java.util.LinkedList;

public class StackImplementationUsingBuiltInLinkedList {
    public static LinkedList<Integer> stack = new LinkedList();

    public void push(int data){
        stack.addFirst(data);
    }

    public int pop(){
        // pops element from front;
        return stack.pop();
    }

    public int top(){
        // since LL is acting as stack here peek will give top element
        return stack.peek();
    }

    public static void main(String[] args) {
        //add nodes at front to behave like stack
        StackImplementationUsingBuiltInLinkedList ll = new StackImplementationUsingBuiltInLinkedList();
        ll.push(10);
        ll.push(20);
        System.out.println("stack elements are "+stack);
        System.out.println("top element of stack is "+ll.top());
        System.out.println("the popped element is "+ll.pop());
    }
}
