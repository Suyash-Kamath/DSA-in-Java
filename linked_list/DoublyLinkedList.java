public class DoublyLinkedList {

    static class Node {
        Node previous;
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    // data members
    private Node head;
    private int size;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // insert at head
    public void insertAtHead(int data) {

        Node newNode = new Node(data);

        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    // insert at tail
    public void insertAtTail(int data) {

        Node newNode = new Node(data);

        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // insert at any position
    public void insertAtPosition(int data, int position) {

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (position == 1) {
            insertAtHead(data);
            return;
        }

        if (position == size + 1) {
            insertAtTail(data);
            return;
        }

        Node currNode = new Node(data);
        Node temp = head;

        /*
        Traverse to the node currently at position - 1.
        The new node will be inserted between temp and temp.next.

        Example:
        List: 10 <-> 20 <-> 30
        Insert 15 at position 2

        temp = 10
        nextNode = 20

        After insertion:
        10 <-> 15 <-> 20 <-> 30
        */

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        Node prevNode = temp;
        Node nextNode = prevNode.next;

        currNode.previous = prevNode;
        currNode.next = nextNode;

        prevNode.next = currNode;
        nextNode.previous = currNode;

        size++;
    }

    // search an element
    public boolean searchElement(int data) {

        Node current = head;

        while (current != null) {

            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // update element at a particular position
    public void updateAtPosition(int data, int position) {

        if (position < 1 || position > size) {
            System.out.println("Invalid Position");
            return;
        }

        Node current = head;

        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        current.data = data;
    }

    // update the first occurrence of a value
    public boolean updateByValue(int oldData, int newData) {

        Node current = head;

        while (current != null) {

            if (current.data == oldData) {
                current.data = newData;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // update the K-th occurrence of a value
    public boolean updateByKthOccurrence(int oldData, int newData, int k) {

        if (k < 1) {
            System.out.println("Invalid occurrence");
            return false;
        }

        Node current = head;
        int occurrence = 0;

        while (current != null) {

            if (current.data == oldData) {

                occurrence++;

                if (occurrence == k) {
                    current.data = newData;
                    return true;
                }
            }

            current = current.next;
        }

        return false;
    }

    // delete head
    public void deleteHead() {

        if (head == null) {
            System.out.println("The List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        size--;
    }

    // delete tail
    public void deleteTail() {

        if (tail == null) {
            System.out.println("The List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }

        size--;
    }

    // delete at any position
    public void deleteAtPosition(int position) {

        if (position < 1 || position > size) {
            System.out.println("Invalid Position");
            return;
        }

        if (position == 1) {
            deleteHead();
            return;
        }

        if (position == size) {
            deleteTail();
            return;
        }

        Node current = head;

        /*
        Traverse to the node that needs to be deleted.

        Example:
        List: 10 <-> 20 <-> 30 <-> 40
        Delete position 3

        current = 30

        Connect:
        20 <-> 40

        Then remove 30 from the list.
        */

        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        Node prevNode = current.previous;
        Node nextNode = current.next;

        prevNode.next = nextNode;
        nextNode.previous = prevNode;

        current.previous = null;
        current.next = null;

        size--;
    }

    // print from head to tail
    public void print() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + "-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // print from tail to head
    public void printBack() {

        Node temp = tail;

        while (temp != null) {
            System.out.print("<- " + temp.data);
            temp = temp.previous;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DoublyLinkedList myList = new DoublyLinkedList();

        myList.insertAtHead(10);
        myList.insertAtHead(20);
        myList.insertAtHead(30);

        myList.insertAtTail(20);
        myList.insertAtTail(40);
        myList.insertAtTail(20);

        myList.print();

        // Update the 3rd occurrence of 20
        myList.updateByKthOccurrence(20, 99, 3);

        myList.print();
        myList.printBack();
    }
}
