
import java.util.Deque;
import java.util.ArrayDeque;

public class ImplementDequeUsingInterface {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        // Insert at rear
        deque.offerLast(10);
        deque.offerLast(20);
        deque.offerLast(30);

        // Insert at front
        deque.offerFirst(5);

        System.out.println("Deque: " + deque);

        // Get front and rear
        System.out.println("Front: " + deque.peekFirst());
        System.out.println("Rear: " + deque.peekLast());

        // Remove from front
        System.out.println("Removed from front: " + deque.pollFirst());

        // Remove from rear
        System.out.println("Removed from rear: " + deque.pollLast());

        System.out.println("Deque after deletion: " + deque);

        System.out.println("Size: " + deque.size());
        System.out.println("Is Empty: " + deque.isEmpty());
    }
}
