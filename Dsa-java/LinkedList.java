class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList {

    ListNode head = null;
    ListNode tail = null;

    public void addAtTail(int val) {
        ListNode temp = new ListNode(val);

        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);

        if (tail == null) {
            tail = head;
        } else {
            temp.next = head;
        }
        head = temp;
    }

    public void print() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println();

    }

    public boolean searchValue(int val) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == val)
                return true;
            temp = temp.next;
        }

        return false;
    }

    public void deleteStart() {

        if (head != null) {
            System.out.println("List is empty!");
            return;
        }

        head = head.next;
    }

    public void deleteEnd() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = null;
            tail = null;
            return;
        }

        prev.next = current.next;
        tail = prev;
    }

}
