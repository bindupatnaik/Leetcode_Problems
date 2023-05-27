import java.util.Arrays;

//stacking of glass plates with other end closed
//stack is linear data structure where insertions and deletions happen only at one end called top of stack.
public class StackImplementationUsingArrays {
    int[] stack;
    int top;
    int capacity;
    public StackImplementationUsingArrays(int capacity){
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = 0;
    }

    public boolean isFull(){
        return (top == capacity);
    }

    public boolean isEmpty(){
        return (top==0);
    }
    //push at one end
    public void push(int data){
        if (isFull())
            return;
        stack[top] = data;
        top++;
        System.out.println("item "+data+" pushed successfully");
    }
    //pop from same end
    public int pop(){
        if (isEmpty())
            return -1;
        int data = stack[--top];
        System.out.println("item " + data + " popped successfully");
        return data;
    }

    public int top(){
        return stack[top - 1];
    }

    public static void main(String[] args) {
        StackImplementationUsingArrays stackObj = new StackImplementationUsingArrays(5);
        System.out.println(Arrays.toString(stackObj.stack));
        System.out.println(stackObj.isEmpty());
        stackObj.push(5);
        stackObj.push(10);
        stackObj.push(5);
        stackObj.push(10);
        stackObj.push(5);
        stackObj.push(10);//this item is not inserted as stack is full.
        System.out.println(Arrays.toString(stackObj.stack));
        stackObj.pop();
        stackObj.pop();
        stackObj.push(20);
        stackObj.push(30);
    }
}

