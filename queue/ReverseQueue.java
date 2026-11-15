/*

import java.util.*;
// no brain is reverse it using one stack , put queue elements in stack and pop th elements
public class ReverseQueue {
    public static void reverseQueue(Deque<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Transfer elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Step 2: Transfer elements back from stack to queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        System.out.println("Reversed Queue: " + queue);
    }
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3); 

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

    }
}
*/

// Remember one thing , jo chiz aap stack se kar sakte ho aap recursion se bhi kar sakte and vice versa.


import java.util.*;

public class ReverseQueue {

    public static void reverseQueue(Deque<Integer> queue) {

        // Base case
        if (queue.isEmpty()) {
            return;
        }

        // Step 1: Remove the front element
        int front = queue.poll();

        // Step 2: Reverse the remaining queue
        reverseQueue(queue);

        // Step 3: Add the removed element at the rear
        queue.offer(front);
    }

    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
