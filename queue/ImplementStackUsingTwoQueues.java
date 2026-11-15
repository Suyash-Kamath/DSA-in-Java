
import java.util.*;

public class ImplementStackUsingTwoQueues {

    /*
       Stack is LIFO.

       Example:
       Push: 5, 10, 15, 20

       top() should return 20, not 5.

       Approach:
       1. Add the new element to Q2.
       2. Copy all elements from Q1 to Q2.
       3. Swap Q1 and Q2.

       Q1 = Main Queue
       Q2 = Helper Queue
    */

    static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {

            // Step 1: Add element in Q2
            q2.offer(x);

            // Step 2: Add all elements of Q1 in Q2
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            // Step 3: Swap Q1 and Q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {

            if (q1.isEmpty()) {
                return -1;
            }

            return q1.poll();
        }

        public int top() {

            if (q1.isEmpty()) {
                return -1;
            }

            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
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
