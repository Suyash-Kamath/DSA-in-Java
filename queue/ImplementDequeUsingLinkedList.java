
public class ImplementDequeUsingLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class MyDeque {

        Node front;
        Node rear;
        int size;

        // Constructor to initialize deque
        public MyDeque() {
            front = null;
            rear = null;
            size = 0;
        }

        // Insert element at front
        public boolean insertFront(int x) {

            Node newNode = new Node(x);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            }
            else {
                newNode.next = front;
                front.prev = newNode;
                front = newNode;
            }

            size++;

            System.out.println(x + " inserted at front");
            return true;
        }

        // Insert element at rear
        public boolean insertRear(int x) {

            Node newNode = new Node(x);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            }
            else {
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }

            size++;

            System.out.println(x + " inserted at rear");
            return true;
        }

        // Remove element from front
        public int deleteFront() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            int data = front.data;

            if (front == rear) {
                front = null;
                rear = null;
            }
            else {
                front = front.next;
                front.prev = null;
            }

            size--;

            System.out.println("Element removed from front");
            return data;
        }

        // Remove element from rear
        public int deleteRear() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            int data = rear.data;

            if (front == rear) {
                front = null;
                rear = null;
            }
            else {
                rear = rear.prev;
                rear.next = null;
            }

            size--;

            System.out.println("Element removed from rear");
            return data;
        }

        // Get front element
        public int getFront() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            return front.data;
        }

        // Get rear element
        public int getRear() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            return rear.data;
        }

        // Get size
        public int getSize() {
            return size;
        }

        // Check if empty
        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {

        MyDeque deque = new MyDeque();

        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertRear(30);

        deque.insertFront(5);

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());
        System.out.println("Size: " + deque.getSize());

        deque.deleteFront();
        deque.deleteRear();

        System.out.println("Front after deletion: " + deque.getFront());
        System.out.println("Rear after deletion: " + deque.getRear());
        System.out.println("Size: " + deque.getSize());
    }
}
