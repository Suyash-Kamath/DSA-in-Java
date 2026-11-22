// priority queue , arraydeque and linkedlist implemenmts Queue interface

import java.util.*;
public class QueueInterface {
    public static void main(String[] args) {
        // add, offer, element(), peek(), remove(), poll() are the methods of Queue interface
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.offer(30);
        System.out.println("Queue: " + queue);
        System.out.println("Element at the head of the queue: " + queue.element()); 
        System.out.println("Peek at the head of the queue: " + queue.peek());
        System.out.println("Remove the head of the queue: " + queue.remove());
        System.out.println("Poll the head of the queue: " + queue.poll());

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        System.out.println("Priority Queue: " + priorityQueue);

        // use offer and poll as it is advanced and already handles the exceptions , and also use peek() 
        // insertion -> offer
        // removal -> poll
        // front -> peek


        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(100);
        deque.add(200);
        deque.offer(300);
        System.out.println("Deque: " + deque);
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());







    }
    
}
