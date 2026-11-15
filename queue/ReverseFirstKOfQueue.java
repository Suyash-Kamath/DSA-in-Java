// import java.util.*;


// public class ReverseFirstKQueue {
    
//     public static void reverseFirstK(Deque<Integer> queue, int k) {

//         // Base case
//         if (queue.isEmpty() || k <= 0 || k > queue.size()) {
//             return;
//         }

//         // Step 1: Remove the first k elements and store them in a stack
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 0; i < k; i++) {
//             stack.push(queue.poll());
//         }

//         // Step 2: Add the elements from the stack back to the queue
//         while (!stack.isEmpty()) {
//             queue.offer(stack.pop());
//         }

//         // Step 3: Move the remaining elements to the back of the queue
//         int size = queue.size();
//         for (int i = 0; i < size - k; i++) {
//             queue.offer(queue.poll());
//         }
//     }

//     public static void main(String[] args) {

//         Deque<Integer> queue = new ArrayDeque<>();

//         queue.offer(1);
//         queue.offer(2);
//         queue.offer(3);
//         queue.offer(4);
//         queue.offer(5);

//         System.out.println("Original Queue: " + queue);

//         int k = 3;
//         reverseFirstK(queue, k);

//         System.out.println("Queue after reversing first " + k + " elements: " + queue);
//     }
// }


import java.util.*;

public class ReverseFirstKOfQueue {

    public static void reverseFirstK(Queue<Integer> queue, int k) {

        if (queue.isEmpty() || k <= 0 || k > queue.size()) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        int n = queue.size();

        // Step 1: Push first K elements into Stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Pop Stack elements and add to Queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step 3: Move remaining n-k elements to rear
        for (int i = 0; i < n - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(5);
        queue.offer(10);
        queue.offer(12);
        queue.offer(14);
        queue.offer(16);
        queue.offer(20);

        int k = 2;

        System.out.println("Original Queue: " + queue);

        reverseFirstK(queue, k);

        System.out.println("Reversed Queue: " + queue);
    }
}
