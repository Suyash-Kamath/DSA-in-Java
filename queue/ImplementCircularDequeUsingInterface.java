
import java.util.Deque;
import java.util.ArrayDeque;

public class ImplementCircularDequeUsingInterface {

    static class MyCircularDeque {

        Deque<Integer> deque;
        int capacity;

        // Constructor
        public MyCircularDeque(int k) {
            capacity = k;
            deque = new ArrayDeque<>(k);
        }

        // Insert at front
        public boolean insertFront(int x) {

            if (isFull()) {
                System.out.println("Deque is full");
                return false;
            }

            deque.offerFirst(x);
            return true;
        }

        // Insert at rear
        public boolean insertRear(int x) {

            if (isFull()) {
                System.out.println("Deque is full");
                return false;
            }

            deque.offerLast(x);
            return true;
        }

        // Delete from front
        public int deleteFront() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            return deque.pollFirst();
        }

        // Delete from rear
        public int deleteRear() {

            if (isEmpty()) {
                System.out.println("Deque is empty");
                return -1;
            }

            return deque.pollLast();
        }

        // Get front
        public int getFront() {

            if (isEmpty()) {
                return -1;
            }

            return deque.peekFirst();
        }

        // Get rear
        public int getRear() {

            if (isEmpty()) {
                return -1;
            }

            return deque.peekLast();
        }

        // Get size
        public int getSize() {
            return deque.size();
        }

        // Check empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        // Check full
        public boolean isFull() {
            return deque.size() == capacity;
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
