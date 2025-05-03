public class Stack extends Object {
    int[] arr;
    int top;

    Stack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int val) {
        top++;
        arr[top] = val;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }

        arr[top] = 0;
        top--;
    }

    public int top() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }
}
