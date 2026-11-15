/*

Queue is a linear data structure that follows the First In First Out (FIFO) principle. It is an abstract data type that allows for the storage and retrieval of elements in a specific order. The first element added to the queue will be the first one to be removed.

Queue can be implemented using Array Deque, Linked List , Priority Queue, etc. It is widely used in various applications such as scheduling tasks, managing requests in web servers, and implementing breadth-first search algorithms.

Queue can also be implemented using this interface 

Queue<Integer> q = new ArrayDeque<>();

as

Collection<E> <------- Queue<E> <--------- Deque<E> <---------- ArrayDeque<E>
              extends.          extends              implements
*/

import java.util.*;


public class IntroductionToQueueUsingInterface {




    public static void main(String[] args) {
        // Create a Queue 

        Deque<Integer> queue = new ArrayDeque<>();

        // insertion

        queue.offer(10);

        // size

        System.out.println("Size of queue: " + queue.size());

        queue.offer(20);

        // front -> 10 and rear -> 20

         System.out.println("Front of queue: " + queue.peek());
        queue.offer(30);
         // front -> 10 and rear -> 30 and removal -> poll

          System.out.println("Removed from queue: " + queue.poll());

          System.out.println("Size "+queue.size());


          if(queue.isEmpty()) {
            System.out.println("Queue is empty");
          } else {
            System.out.println("Queue is not empty");
          }
    }
}
