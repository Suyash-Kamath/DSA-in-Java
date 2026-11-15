
import java.util.*;

public class ImplementQueueUsingTwoStacks {

    static class MyQueue {

        Deque<Integer> s1;
        Deque<Integer> s2;

        public MyQueue() {
            s1 = new ArrayDeque<>();
            s2 = new ArrayDeque<>();
        }

        // Insert element into Queue
        public void push(int x) {

            // Step 1: Transfer S1 -> S2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Step 2: Insert new element into S1
            s1.push(x);

            // Step 3: Transfer S2 -> S1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove element from Queue
        public int pop() {

            if (s1.isEmpty()) {
                return -1;
            }

            return s1.pop();
        }

        // Get front element
        public int peek() {

            if (s1.isEmpty()) {
                return -1;
            }

            return s1.peek();
        }

        // Check if Queue is empty
        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(5);
        queue.push(10);
        queue.push(15);
        queue.push(20);

        System.out.println("Peek: " + queue.peek());

        System.out.println("Pop: " + queue.pop());

        System.out.println("Peek: " + queue.peek());

        System.out.println("Pop: " + queue.pop());

        System.out.println("Peek: " + queue.peek());

        System.out.println("Is Empty: " + queue.empty());
    }
}
