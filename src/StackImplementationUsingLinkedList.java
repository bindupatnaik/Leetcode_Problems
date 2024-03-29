//here we use add at front technique for O(1) time complexity. otherwise if we add at end of list
//then for pop it becomes O(n)
public class StackImplementationUsingLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    ListNode top;
    public StackImplementationUsingLinkedList(){
        this.top = null;
    }
    //add at front
    // Time - O(1)
    public void push(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top  = newNode;
    }
    // Time - O(1)
    public int pop(){
        if (isEmpty())
            return -1;
        int data = top.val;
        top = top.next;
        return data;
    }

    public boolean isEmpty(){
        return (top==null);
    }

    public void printLL(){
        ListNode curr = top;
        while(curr!=null){
            System.out.print(curr.val +" ");
            curr = curr.next;
        }
    }

    public int top(){
        if (isEmpty())
            return -1;
        return top.val;
    }

    public static void main(String[] args) {
        StackImplementationUsingLinkedList ll = new StackImplementationUsingLinkedList();
        ll.push(20);
        ll.push(30);
        ll.push(40);
        ll.printLL();
        System.out.println();
        System.out.println("Popped element is : "+ll.pop());
        System.out.println("Popped element is : "+ll.pop());
//        System.out.println("Popped element is : "+ll.pop());
//        System.out.println("Popped element is : "+ll.pop());
        System.out.println("Top element is "+ll.top());
    }
}
