import java.util.ArrayDeque;
import java.util.Deque;
public class ArrayDequeBasics {
    public static void main(String[] args) {
        // ArrayDeque is a resizable array implementation of the Deque interface. It provides a double-ended queue that allows elements to be added or removed from both ends efficiently.
        // ArrayDeque is not thread-safe, so if multiple threads access an ArrayDeque concurrently, and at least one of the threads modifies the deque structurally, it must be synchronized externally.
        // ArrayDeque does not allow null elements. Attempting to add a null element will result in a NullPointerException.
        // ArrayDeque is faster than LinkedList when used as a queue or stack because it has less overhead and better cache locality.
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println("ArrayDeque: " + deque);
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());
        System.out.println("Remove first element: " + deque.removeFirst());
        System.out.println("Remove last element: " + deque.removeLast());
        System.out.println("ArrayDeque after removals: " + deque);

        // use poll ,offer , peek methods
        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.offer(4);
        deque2.offer(5);
        deque2.offer(6);
        System.out.println("ArrayDeque2: " + deque2);
        System.out.println("Poll first element: " + deque2.poll());
        System.out.println("Poll last element: " + deque2.pollLast());
        System.out.println("ArrayDeque2 after polling: " + deque2);

        // poll first poll last, offer first , offer last 
        Deque<Integer> deque3 = new ArrayDeque<>();
        deque3.offerFirst(7);
        deque3.offerLast(8);
        deque3.offerFirst(9);
        deque3.offerLast(10);
        System.out.println("ArrayDeque3: " + deque3);
        System.out.println("Poll first element: " + deque3.pollFirst());
        System.out.println("Poll last element: " + deque3.pollLast());
        System.out.println("ArrayDeque3 after polling: " + deque3);

        // quueue clear method
        Deque<Integer> deque4 = new ArrayDeque<>();
        deque4.offer(11);
        deque4.offer(12);
        System.out.println("ArrayDeque4: " + deque4);
        deque4.clear();
        System.out.println("ArrayDeque4 after clear: " + deque4);

        // peek first, peek last
        Deque<Integer> deque5 = new ArrayDeque<>();
        deque5.offer(13);
        deque5.offer(14);
        System.out.println("ArrayDeque5: " + deque5);
        System.out.println("Peek first element: " + deque5.peekFirst());
        System.out.println("Peek last element: " + deque5.peekLast());
    }
}
