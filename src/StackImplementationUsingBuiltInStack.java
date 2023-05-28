import java.util.Stack;

public class StackImplementationUsingBuiltInStack {
    Stack<Integer> stack;

    public StackImplementationUsingBuiltInStack(){
        stack = new Stack<>();
    }

    public void push(int data){
        stack.push(data);
    }

    public int pop(){
        if (stack.isEmpty())
            return -1;
        return stack.pop();
    }

    public int peek(){
        if (stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public int search(int data){
        Integer pos = stack.search(data);
        if (pos==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element is found in pos"+pos);
        }
        return pos;
    }

    public static void main(String[] args) {
        StackImplementationUsingBuiltInStack obj = new StackImplementationUsingBuiltInStack();
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        System.out.println(obj.stack);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.stack.peek());
    }
}
