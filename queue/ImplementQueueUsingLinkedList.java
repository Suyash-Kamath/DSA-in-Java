
public class ImplementQueueUsingLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class MyQueue {

        Node front;
        Node rear;
        int size;

        // Constructor to initialize the queue
        public MyQueue() {
            front = null;
            rear = null;
            size = 0;
        }

        // Insert at rear end of queue
        public boolean enqueue(int x) {

            Node newNode = new Node(x);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            }
            else {
                rear.next = newNode;
                rear = newNode;
            }

            size++;

            System.out.println(x + " inserted into queue");
            return true;
        }

        // Remove from front end of queue
        public int dequeue() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int data = front.data;

            front = front.next;
            size--;

            // If queue becomes empty, rear should also become null
            if (front == null) {
                rear = null;
            }

            System.out.println("Element removed from queue");
            return data;
        }

        // Get front element of queue
        public int getFront() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return front.data;
        }

        // Get rear element of queue
        public int getRear() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return rear.data;
        }

        // Return size of queue
        public int getSize() {
            return this.size;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front element is: " + q.getFront());
        System.out.println("Rear element is: " + q.getRear());
        System.out.println("Size of queue is: " + q.getSize());

        q.dequeue();

        System.out.println("Front element is: " + q.getFront());
        System.out.println("Rear element is: " + q.getRear());
        System.out.println("Size of queue is: " + q.getSize());
    }
}
