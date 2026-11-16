// import java.util.*;

// public class InterleaveQueueHalves {

//     public void rearrangeQueue(Queue<Integer> queue) {
//         if (queue.isEmpty() || queue.size() % 2 != 0) {
//             throw new IllegalArgumentException("Queue must have an even number of elements.");
//         }

//         int halfSize = queue.size() / 2;
//         Stack<Integer> stack = new Stack<>();

//         // Step 1: Push the first half of the queue onto the stack
//         for (int i = 0; i < halfSize; i++) {
//             stack.push(queue.poll());
//         }

//         // Step 2: Enqueue the elements from the stack back to the queue
//         while (!stack.isEmpty()) {
//             queue.offer(stack.pop());
//         }

//         // Step 3: Move the first half of the queue to the back
//         for (int i = 0; i < halfSize; i++) {
//             queue.offer(queue.poll());
//         }

//         // Step 4: Interleave the elements from the two halves
//         for (int i = 0; i < halfSize; i++) {
//             queue.offer(queue.poll()); // Move one element from the first half
//             queue.offer(queue.poll()); // Move one element from the second half
//         }
//     }
//     public static void main(String[] args) {
        
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(1);
//         queue.offer(2);
//         queue.offer(3);
//         queue.offer(4);
//         queue.offer(5);
//         queue.offer(6);

//         System.out.println("Original Queue: " + queue);

//         InterleaveQueueHalves interleaver = new InterleaveQueueHalves();
//         interleaver.rearrangeQueue(queue);

//         System.out.println("Queue after interleaving halves: " + queue);
//     }
// }



import java.util.*;

public class InterleaveQueueHalves {

    public static void rearrangeQueue(Queue<Integer> q) {

        int fullLength = q.size();

        if (fullLength == 0 || fullLength % 2 != 0) {
            throw new IllegalArgumentException(
                "Queue must have a non-zero even number of elements."
            );
        }

        Queue<Integer> q2 = new LinkedList<>();

        int halfLength = fullLength / 2;

        // Step 1: Separate the first half
        for (int i = 0; i < halfLength; i++) {
            q2.offer(q.poll());
        }

        // Step 2: Interleave both halves
        for (int i = 0; i < halfLength; i++) {
            q.offer(q2.poll());
            q.offer(q.poll());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);

        System.out.println("Original Queue: " + queue);

        rearrangeQueue(queue);

        System.out.println("Queue after interleaving: " + queue);
    }
}
