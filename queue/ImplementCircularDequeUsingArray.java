
public class ImplementCircularDequeUsingArray {

    static class MyCircularDeque {

        int[] arr;
        int front, rear, size, capacity;

        // Constructor
        public MyCircularDeque(int k) {
            capacity = k;
            arr = new int[k];
            front = 0;
            rear = -1;
            size = 0;
        }

        // Insert at front
        public boolean insertFront(int x) {

            if (isFull()) {
                System.out.println("Deque is full");
                return false;
            }

            if (isEmpty()) {
                front = 0;
                rear = 0;
            }
            else {
                front = (front - 1 + capacity) % capacity;
            }

            arr[front] = x;
            size++;

            System.out.println(x + " inserted at front");
            return true;
        }

        // Insert at rear
        public boolean insertRear(int x) {

            if (isFull()) {
                System.out.println("Deque is full");
                return false;
            }

            if (isEmpty()) {
                front = 0;
                rear = 0;
            }
            else {
                rear = (rear + 1) % capacity;
            }

            arr[rear] = x;
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

            int data = arr[front];

            if (size == 1) {
                front = 0;
                rear = -1;
            }
            else {
                front = (front + 1) % capacity;
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

            int data = arr[rear];

            if (size == 1) {
                front = 0;
                rear = -1;
            }
            else {
                rear = (rear - 1 + capacity) % capacity;
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

            return arr[front];
        }

        // Get rear
        public int getRear() {

            if (isEmpty()) {
                return -1;
            }

            return arr[rear];
        }

        // Get size
        public int getSize() {
            return size;
        }

        // Check empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check full
        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {

        MyCircularDeque deque = new MyCircularDeque(5);

        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertRear(30);

        deque.insertFront(5);

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());

        deque.deleteFront();
        deque.deleteRear();

        deque.insertFront(40);

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());
        System.out.println("Size: " + deque.getSize());
        System.out.println("Is Full: " + deque.isFull());
    }
}
