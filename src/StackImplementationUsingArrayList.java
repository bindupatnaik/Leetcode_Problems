import java.util.ArrayList;
import java.util.List;

public class StackImplementationUsingArrayList {
    List<Integer> arr;
    int top;
    int capacity; //you can use arr.size()


    public StackImplementationUsingArrayList(){
        arr = new ArrayList();
        top = 0;
        capacity = 0;
    }

    public void push(int data){
        if ( top == capacity){
            arr.add(data);
            capacity++;
            top++;
        }else{
            arr.set(top, data);
            top++;
        }

    }

    public int top(){
        return arr.get(top-1);
    }

    public boolean isEmpty(){
        return (top==0);
    }

    public int pop(){
        if (isEmpty())
            return -1;
        int data =  arr.get(--top);
//        top--;
        return data;
    }

    public static void main(String[] args) {
        StackImplementationUsingArrayList obj = new StackImplementationUsingArrayList();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);

        System.out.println(obj.arr);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        obj.push(60);
        System.out.println(obj.arr);
        System.out.println(obj.top());


    }




}
