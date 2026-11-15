
import java.util.*;

public class ImplementStackUsingSingleQueue {

    /*
       Stack is LIFO.

       Example:
       Push: 5, 10, 15, 20

       Expected order:
       20 -> 15 -> 10 -> 5

       Approach:
       1. Add the new element to the queue.
       2. Rotate the remaining previous elements
          by removing them from the front and
          adding them to the rear.

       Only one queue is used.
    */

    static class MyStack {

        Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        public void push(int x) {

            // Step 1: Add new element
            q.offer(x);

            // Step 2: Rotate previous elements
            int size = q.size();

            for (int i = 0; i < size - 1; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {

            if (q.isEmpty()) {
                return -1;
            }

            return q.poll();
        }

        public int top() {

            if (q.isEmpty()) {
                return -1;
            }

            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println("Top element: " + stack.top());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Top element: " + stack.top());

        System.out.println("Is Stack Empty? " + stack.empty());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Is Stack Empty? " + stack.empty());
    }
}
