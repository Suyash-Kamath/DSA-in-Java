public class CircularDoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;   // single node points to itself
            head.prev = head;   // in BOTH directions
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

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
        } else {
            Node newNode = new Node(data);

            Node prevNode = head;
            for (int i = 1; i < position - 1; i++) {
                prevNode = prevNode.next;
            }
            Node nextNode = prevNode.next;

            // four pointers to rewire, order matters less here because
            // we captured nextNode before touching anything
            newNode.prev = prevNode;
            newNode.next = nextNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;

            size++;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("Back to head");
    }

    // this is the payoff of a doubly linked list: traversal is bidirectional
    public void printListReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = tail;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("Back to tail");
    }

    public boolean search(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        }
        Node temp = head;
        int position = 1;
        do {
            if (temp.data == data) {
                System.out.println("Element found at position: " + position);
                return true;
            }
            temp = temp.next;
            position++;
        } while (temp != head);
        System.out.println("Element not found");
        return false;
    }

    public void deleteAtHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        } else {
            Node temp = head;
            head = head.next;
            head.prev = tail;
            tail.next = head;

            temp.next = null;
            temp.prev = null;
        }
        size--;
    }

    // O(1) now instead of O(n) -- no traversal needed to find the second-last node
    public void deleteAtTail() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        } else {
            Node temp = tail;
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;

            temp.next = null;
            temp.prev = null;
        }
        size--;
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            deleteAtHead();
            return;
        }
        if (position == size) {
            deleteAtTail();
            return;
        } else {
            // walk directly to the target node; prev pointer gives us the predecessor for free
            Node currNode = head;
            for (int i = 1; i < position-1; i++) {
                currNode = currNode.next;
            }
            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            currNode.next = null;
            currNode.prev = null;
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getHead() {
        if (head == null) {
            throw new IllegalStateException(
                "CircularDoublyLinkedList is empty. No head element exists."
            );
        }
        return head.data;
    }

    public int getTail() {
        if (tail == null) {
            throw new IllegalStateException(
                "CircularDoublyLinkedList is empty. No tail element exists."
            );
        }
        return tail.data;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insertAtHead(20);
        list.insertAtHead(10);
        list.insertAtTail(40);
        list.insertAtPosition(30, 3);

        list.printList();
        list.printListReverse();

        System.out.println("Search 30: " + list.search(30));
        System.out.println("Search 50: " + list.search(50));

        list.deleteAtHead();
        list.printList();
        list.deleteAtTail();
        list.printList();

        list.deleteAtPosition(2);
        list.printList();

        System.out.println("Size of linked list = " + list.getSize());
        System.out.println("Head of linked list = " + list.getHead());
        System.out.println("Tail of linked list = " + list.getTail());
        System.out.println("Is linked list empty? = " + list.isEmpty());

        list.insertAtHead(100);
        list.printList();
        list.printListReverse();
    }
}