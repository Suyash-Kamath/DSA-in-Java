
public class ImplementCircularDequeUsingLinkedList {

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

    static class MyCircularDeque {

        Node front;
        Node rear;
        int size;

        // Constructor
        public MyCircularDeque() {
            front = null;
            rear = null;
            size = 0;
        }

        // Insert at front
        public boolean insertFront(int x) {

            Node newNode = new Node(x);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;

                front.next = front;
                front.prev = front;
            }
            else {
                newNode.next = front;
                newNode.prev = rear;

                front.prev = newNode;
                rear.next = newNode;

                front = newNode;
            }

            size++;

            System.out.println(x + " inserted at front");
            return true;
        }

        // Insert at rear
        public boolean insertRear(int x) {

            Node newNode = new Node(x);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;

                front.next = front;
                front.prev = front;
            }
            else {
                newNode.prev = rear;
                newNode.next = front;

                rear.next = newNode;
                front.prev = newNode;

                rear = newNode;
            }

            size++;

            System.out.println(x + " inserted at rear");
            return true;
        }

        // Delete from front
        public int deleteFront() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            int data = front.data;

            if (size == 1) {
                front = null;
                rear = null;
            }
            else {
                front = front.next;

                front.prev = rear;
                rear.next = front;
            }

            size--;

            System.out.println("Element removed from front");
            return data;
        }

        // Delete from rear
        public int deleteRear() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            int data = rear.data;

            if (size == 1) {
                front = null;
                rear = null;
            }
            else {
                rear = rear.prev;

                rear.next = front;
                front.prev = rear;
            }

            size--;

            System.out.println("Element removed from rear");
            return data;
        }

        // Get front
        public int getFront() {

            if (isEmpty()) {
                return -1;
            }

            return front.data;
        }

        // Get rear
        public int getRear() {

            if (isEmpty()) {
                return -1;
            }

            return rear.data;
        }

        // Get size
        public int getSize() {
            return size;
        }

        // Check empty
        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {

        MyCircularDeque deque = new MyCircularDeque();

        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertRear(30);

        deque.insertFront(5);

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());

        deque.deleteFront();
        deque.deleteRear();

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());
        System.out.println("Size: " + deque.getSize());
    }
}
