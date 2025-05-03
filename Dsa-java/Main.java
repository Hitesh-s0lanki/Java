public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(10);
        stack.push(11);
        stack.push(12);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack.top());

        // LinkedList linkedList = new LinkedList();

        // linkedList.addAtTail(10);
        // linkedList.addAtTail(11);
        // linkedList.addAtTail(12);
        // linkedList.addAtTail(13);

        // linkedList.addAtHead(9);

        // linkedList.deleteEnd();
        // linkedList.deleteEnd();
        // linkedList.deleteEnd();
        // linkedList.deleteEnd();
        // linkedList.deleteEnd();

        // linkedList.print();
    }
}
