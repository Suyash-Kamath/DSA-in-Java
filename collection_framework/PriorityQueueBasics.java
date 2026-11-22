import java.util.*;

public class PriorityQueueBasics {
public static void main(String[] args) {
        // PriorityQueue is a queue that orders its elements according to their natural ordering or by a specified comparator. It is implemented as a binary heap.
        // PriorityQueue does not allow null elements. Attempting to add a null element will result in a NullPointerException.
        // PriorityQueue is not thread-safe, so if multiple threads access a PriorityQueue concurrently, and at least one of the threads modifies the queue structurally, it must be synchronized externally.
        // The head of the queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements — ties are broken arbitrarily.
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        // default behaviour of this is -> less value -> higher priority
        priorityQueue.offer(40);
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        System.out.println("Priority Queue: " + priorityQueue);
        System.out.println("Peek at the head of the queue: " + priorityQueue.peek());
        System.out.println("Poll the head of the queue: " + priorityQueue.poll());
        System.out.println("Priority Queue after poll: " + priorityQueue);

        // there is one D.S , minHeap and maxHeap , minHeap is default behaviour of priority queue
        // to implement high value high priority we can use comparator

        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a); // maxHeap
        pq.offer(40);
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.println("Max Heap Priority Queue: " + pq);   
        System.out.println("Peek at the head of the max heap queue: " + pq.poll());


        // pq ->strings -> kisko max ya min  ya custom object hai -> khudke comparator bana ke use karna padega . comaprable interface implement karna padega ya comparator bana ke use karna padega
        

    }    
}
