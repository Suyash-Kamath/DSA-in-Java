
public class ImplementCircularQueueUsingLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class MyCircularQueue {

        Node front;
        Node rear;
        int size;

        // Constructor to initialize the circular queue
        public MyCircularQueue() {
            front = null;
            rear = null;
            size = 0;
        }

        // Insert an element into the circular queue
        public boolean enqueue(int x) {

            Node newNode = new Node(x);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;

                // Point the node to itself
                rear.next = front;
            }
            else {
                rear.next = newNode;
                rear = newNode;

                // Maintain circular connection
                rear.next = front;
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

            if (front == rear) {
                front = null;
                rear = null;
            }
            else {
                front = front.next;

                // Maintain circular connection
                rear.next = front;
            }

            size--;

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

        MyCircularQueue circularQueue = new MyCircularQueue();

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);

        System.out.println("Front of queue: " + circularQueue.getFront());
        System.out.println("Rear of queue: " + circularQueue.getRear());

        circularQueue.dequeue();

        System.out.println("Front of queue after dequeue: " + circularQueue.getFront());
        System.out.println("Size of queue: " + circularQueue.getSize());

        circularQueue.enqueue(40);
        circularQueue.enqueue(50);
        circularQueue.enqueue(60);

        System.out.println("Front of queue: " + circularQueue.getFront());
        System.out.println("Rear of queue: " + circularQueue.getRear());

    }
}
