// Collection framework is a simple tool jiske dwara jo bhi DS hai unko replicate kar sakte ho via code .

/*

Collection which is a interface which List a sub interfaces extends and ArrayList implements the List interface. Collection framework is a unified architecture for representing and manipulating collections. It includes interfaces, implementations, and algorithms that provide a standard way to handle groups of objects.

*/

// import java.util.*;
import java.util.Stack;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        // List or Collection Framework in Java is a unified architecture for representing and manipulating collections. It includes interfaces, implementations, and algorithms that provide a standard way to handle groups of objects.
        // these are interfaces that define the behavior of different types of collections, such as List, Set, and Map. Implementations are concrete classes that provide specific implementations of these interfaces, such as ArrayList, HashSet, and HashMap. Algorithms are methods that perform operations on collections, such as sorting and searching.

        // ArrayList is a resizable array implementation of the List interface. It allows for dynamic resizing, meaning that it can grow or shrink in size as elements are added or removed. ArrayList provides fast random access to elements and is generally more efficient for storing and accessing data than other List implementations, such as LinkedList.
        // It is a concrete class that implements the List interface and provides methods for adding, removing, and accessing elements in the list. ArrayList is part of the Java Collections Framework and is widely used in Java programming.

        // ArrayList<Integer> arr = new ArrayList<>();
        // List<Integer> list = new ArrayList<>();
        // Collection<Integer> collection = new ArrayList<>();
        // Implmentation is of concrete class and reference is of interface type. This is a common practice in Java programming, as it allows for greater flexibility and abstraction in code design. By using interface types as references, we can easily switch between different implementations of the same interface without changing the code that uses them.
        
         ArrayList<Integer> list = new ArrayList<>();

         // add
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println(list);
            // list.add(1, 4); // add 4 at index 1
            list.add(4); // add 4 at the end of the list
            System.out.println(list);


            // remove
            list.remove(0); // remove element at index 0
            System.out.println(list);

            // addAll method is used to add all the elements of a specified collection to the end of the list. It takes a collection as an argument and adds all its elements to the list in the order they are returned by the collection's iterator.
            List<Integer> list2 = new ArrayList<>();
            list2.add(101);
            list2.add(102);
            list2.add(2);
            list.addAll(list2);
            System.out.println(list);

            // removeAll method is used to remove all the elements of a specified collection from the list. It takes a collection as an argument and removes all its elements from the list, if they are present.
            list.removeAll(list2);
            System.out.println(list);

            System.out.println(list.size());

            System.out.println("Printing List 2: " + list2);
            list2.clear(); // clear method is used to remove all the elements from the list. It removes all the elements from the list and sets its size to zero.
            System.out.println("Printing List 2 after clear: " + list2);

            // iterator is an interface that provides a way to iterate over a collection of elements. It allows us to traverse the elements of a collection one by one, without exposing the underlying implementation details of the collection. The Iterator interface provides methods for checking if there are more elements to iterate over, retrieving the next element, and removing elements from the collection.

            // I want to traverse the list using iterator
            // Aapko specific data structure ke elements ko traverse karna hai, to aap iterator ka use kar sakte ho. Iterator interface ke methods ka use karke aap elements ko traverse kar sakte ho. Iterator interface ke methods me hasNext() aur next() methods ka use karke aap elements ko traverse kar sakte ho.
            // Aapko specific class type ka iterator create karna padega , uss particular object keliye .
            Iterator<Integer> it = list.iterator();
            // hasNext returns bollean value ,  if there is element or not. If there is element it returns true otherwise false.
            while(it.hasNext()) {
                System.out.println(it.next()); // using next method we can get the element and move to next element.
            }
            // Above we seen methods of collection , now lets see for the list interface. List interface is a subinterface of collection interface. It provides additional methods for working with ordered collections of elements, such as getting and setting elements at specific indices, searching for elements, and sorting the list.
            List<Integer> list3 = new ArrayList<>();
            list3.add(11);
            list3.add(12);
            list3.add(14);
            System.out.println("Printing List 3: " + list3);
            System.out.println("Element at index 0: " + list3.get(0));

            list3.set(0, 100);
            System.out.println("Printing List 3 after set: " + list3);

            // toArray method is used to convert a list to an array. It returns an array containing all the elements of the list in the same order as they appear in the list. The toArray method can be called with or without an argument. If called without an argument, it returns an Object array. If called with an argument, it returns an array of the specified type.
            // jo bhi data structure / collection hai may it be arraylist, vector or linkedlist, we can convert it to array using toArray method. This is useful when we need to pass the collection to a method that expects an array as an argument.
            Object[] arr = list3.toArray();
            for(Object o : arr) {
                System.out.println(o);
            }

            // contains method is used to check if a list contains a specific element. It takes an object as an argument and returns true if the list contains the specified element, and false otherwise.
            System.out.println("Does List 3 contain 100? " + list3.contains(100));
            System.out.println("Does List 3 contain 11? " + list3.contains(11));


            // Methods of array list 

            // sort

            list.add(12);
            list.add(6);
            System.out.println("Printing List before sort: " + list);
            Collections.sort(list);
            System.out.println("Printing List after sort: " + list);

            // sort in descending order
            Collections.sort(list, Collections.reverseOrder());
            System.out.println("Printing List after sort in descending order: " + list);

            // clone method is used to create a shallow copy of the list.
            // shallow copy means that the elements themselves are not copied, only the references to the elements are copied. This means that if the elements are mutable objects, changes made to the elements in one list will be reflected in the other list.

            ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
            System.out.println("Printing newList: " + newList);

            // ensure Capacity method is used to ensure that the list has enough capacity to hold a specified number of elements. It takes an integer as an argument and increases the capacity of the list if necessary. This method is useful when we know in advance how many elements we will be adding to the list, as it can help to avoid unnecessary resizing of the list.
            ArrayList<Integer> marks = new ArrayList<>();
            marks.ensureCapacity(10);
            
            // isEmpty method is used to check if a list is empty. It returns true if the list contains no elements, and false otherwise.
            System.out.println("Is marks list empty? " + marks.isEmpty());

            // index of method is used to find the index of the first occurrence of a specified element in the list. It takes an object as an argument and returns the index of the first occurrence of the specified element, or -1 if the element is not found in the list.
            System.out.println("Index of 12 in list: " + list.indexOf(12));
            System.out.println("Index of 100 in list: " + list.indexOf(100));




            // LinkedList 
            // it has same methods as arraylist but it is implemented using doubly linked list. It is more efficient than arraylist when it comes to inserting and deleting elements in the middle of the list. It is also more efficient when it comes to iterating over the list, as it does not require shifting elements like arraylist does.

            // Note: Every method of list is same for linkedlist , alright ?

            List<Integer> linkedList = new java.util.LinkedList<>();
            // the above thing is the declaration
            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(3);
            System.out.println("Printing LinkedList: " + linkedList);
            linkedList.add(12);
            System.out.println("Printing LinkedList: " + linkedList);
            System.out.println("Index of 12 in LinkedList: " + linkedList.indexOf(12));
    
            // Note: Linkedlist me clone method is not available, so we cannot use it. But we can use the addAll method to copy the elements of one linkedlist to another linkedlist. Clone is not possible because linkedlist is not a cloneable class. It does not implement the cloneable interface. So we cannot use the clone method to create a copy of a linkedlist. But we can use the addAll method to copy the elements of one linkedlist to another linkedlist.

            List<Integer> newLinkedList = new java.util.LinkedList<>();
            newLinkedList.addAll(linkedList);
            System.out.println("Printing newLinkedList: " + newLinkedList);

            // creaste new new linkedlist , elements are 10 20 30 40 20 20 30 
            List<Integer> newLinkedList2 = new java.util.LinkedList<>();
            newLinkedList2.add(10);
            newLinkedList2.add(20);
            newLinkedList2.add(30);
            newLinkedList2.add(40);
            newLinkedList2.add(20);
            newLinkedList2.add(20);
            newLinkedList2.add(30);
            System.out.println("Printing newLinkedList2: " + newLinkedList2);
            // return first occurrence of 20 from newLinkedList2
            System.out.println("First occurrence of 20 in newLinkedList2: " + newLinkedList2.indexOf(20));
            // return last occurrence of 20 from newLinkedList2
            System.out.println("Last occurrence of 20 in newLinkedList2: " + newLinkedList2.lastIndexOf(20));


            // Linkedlist as Queue and Deque

            // addFirst and addLast methods are used to add elements to the front and back of the linked list, respectively. These methods are useful when we want to use the linked list as a queue or deque (double-ended queue). A queue is a data structure that follows the First-In-First-Out (FIFO) principle, while a deque allows us to add and remove elements from both ends of the list.
            newLinkedList2.addFirst(5);
            newLinkedList2.addLast(50);
            System.out.println("Printing newLinkedList2 after addFirst and addLast: " + newLinkedList2);
            newLinkedList2.removeFirst();
            newLinkedList2.removeLast();
            System.out.println("Printing newLinkedList2 after removeFirst and removeLast: " + newLinkedList2);
            newLinkedList2.remove(3); // remove element at index 3
            System.out.println("Printing newLinkedList2 after remove at index 3: " + newLinkedList2);


            LinkedList<Integer> linkedList3 = new java.util.LinkedList<>();
            linkedList3.add(1);
            System.out.println("Printing linkedList3: " + linkedList3);
            linkedList3.addFirst(2);
            System.out.println("Printing linkedList3 after addFirst: " + linkedList3);
            linkedList3.addLast(3);
            System.out.println("Printing linkedList3 after addLast: " + linkedList3);
            // linkedList3.removeFirst();
            // System.out.println("Printing linkedList3 after removeFirst: " + linkedList3);
            // linkedList3.removeLast();
            // System.out.println("Printing linkedList3 after removeLast: " + linkedList3);

            System.out.println("First element of linkedList3: " + linkedList3.getFirst());
            System.out.println("Last element of linkedList3: " + linkedList3.getLast());

            // peek poll and offer methods are used to retrieve and remove elements from the front of the linked list, respectively. The peek method returns the first element of the list without removing it, while the poll method removes and returns the first element of the list. The offer method adds an element to the end of the list.
            System.out.println("Peek element of linkedList3: " + linkedList3.peek());
            System.out.println("Poll element of linkedList3: " + linkedList3.poll());
            System.out.println("Printing linkedList3 after poll: " + linkedList3);
            linkedList3.offer(4);
            System.out.println("Printing linkedList3 after offer: " + linkedList3);

            // UNderstand Java Vector
            /*
            
            Vector vs ArrayList: Vector is a legacy class that was introduced in Java 1.0, while ArrayList was introduced in Java 1.2 as part of the Collections Framework. Vector is synchronized, meaning that it is thread-safe and can be used in multi-threaded environments, while ArrayList is not synchronized and is not thread-safe. Vector has a slightly slower performance than ArrayList due to its synchronization overhead. However, Vector provides some additional methods that are not available in ArrayList, such as the ability to insert elements at a specific index and the ability to remove elements by value rather than by index.
            use arraylist instead of vector because arraylist is faster than vector. Vector is synchronized and arraylist is not synchronized. So if you are working in a single-threaded environment, use arraylist. If you are working in a multi-threaded environment, use vector.
            what is synchronized? Synchronized is a keyword in Java that is used to control access to a shared resource by multiple threads. When a method or block of code is declared as synchronized, only one thread can access it at a time. This ensures that the shared resource is not modified by multiple threads simultaneously, which can lead to data corruption and other issues. Synchronized methods and blocks are typically used in multi-threaded environments where multiple threads may be accessing the same resource concurrently.
            // what is race condition . 
            Race condition is a situation that occurs in multi-threaded programming when two or more threads access a shared resource simultaneously, and the outcome of the program depends on the order in which the threads execute. This can lead to unexpected behavior and bugs in the program, as the threads may interfere with each other and produce inconsistent results. Race conditions can be difficult to detect and reproduce, as they may only occur under certain timing conditions or with specific inputs. To avoid race conditions, developers can use synchronization techniques such as locks, semaphores, and atomic operations to ensure that only one thread can access a shared resource at a time.

            vector every operation ko synchronized kar deta hai, isliye vector thread safe hai. But arraylist thread safe nahi hai. So agar aapko thread safe chahiye to vector use karo otherwise arraylist use karo. Vector is legacy class and arraylist is part of collection framework. So prefer to use arraylist over vector.
            vector uses lock , so time consuming operation. Arraylist is faster than vector because it is not synchronized. Vector is synchronized and arraylist is not synchronized. So if you are working in a single-threaded environment, use arraylist. If you are working in a multi-threaded environment, use vector.

            
            */

            Vector<Integer> vector = new Vector<>();
            List<Integer> vectorList = new Vector<>();
            // Collections<Integer> vectorCollection = new Vector<>();


            // Stack 
            // Stack  also implements the List interface and provides methods for adding, removing, and accessing elements in a last-in-first-out (LIFO) manner. Stack is part of the Java Collections Framework and is widely used in Java programming.
            // Stack is a legacy class that was introduced in Java 1.0, while ArrayList was introduced in Java 1.2 as part of the Collections Framework. Stack is synchronized, meaning that it is thread-safe and can be used in multi-threaded environments, while ArrayList is not synchronized and is not thread-safe. Stack has a slightly slower performance than ArrayList due to its synchronization overhead. However, Stack provides some additional methods that are not available in ArrayList, such as the ability to peek at the top element of the stack without removing it, and the ability to search for an element in the stack and return its position from the top of the stack.
            Stack<Integer> stack = new Stack<>();

            List<Integer> stackList = new Stack<>();

            // stack has push pop peek search empty
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Printing Stack: " + stack);
            System.out.println("Peek element of Stack: " + stack.peek());
            System.out.println("Pop element of Stack: " + stack.pop());         
            // noew search for 2 in stack
            System.out.println("Search for 2 in Stack: " + stack.search(2));
            System.out.println("Is Stack empty? " + stack.empty());

            // note  push doesnt work for List<Integer> stackList = new Stack<>(); because push is not a method of List interface. It is a method of Stack class. So we cannot use push method on stackList. We can use add method to add elements to stackList. But we cannot use pop, peek, search and empty methods on stackList because they are not methods of List interface. They are methods of Stack class. So we cannot use them on stackList.
            // search method is used to search for an element in the stack and return its position from the top of the stack. It takes an object as an argument and returns the 1-based position of the element from the top of the stack, or -1 if the element is not found in the stack. The search method is useful when we want to check if an element is present in the stack and its position from the top of the stack.
            
            Stack<Integer> stack2 = new Stack<>();
            stack2.push(1);
            stack2.push(2);
            stack2.push(3);
            System.out.println("Printing Stack2: " + stack2);
            System.out.println("Search for 2 in Stack2: " + stack2.search(2)); // it is 1-based index from top of stack. So 2 is at index 2 from top of stack. So it returns 2.
            System.out.println("Search for 4 in Stack2: " + stack2.search(4)); // it is 1-based index from top of stack. So 4 is at index 1 from top of stack. So it returns 1.
            // pop()
            System.out.println("Pop element of Stack2: " + stack2.pop());
            //peek
            System.out.println("Peek element of Stack2: " + stack2.peek());

            // Stack extends vector and vector implements list and list extends Collection interface


            /*
            
            Why use ArrayDeque instead of Stack in Java?
            ArrayDeque is a more modern and efficient implementation of a double-ended queue (deque) in Java, while Stack is a legacy class that was introduced in Java 1.0. ArrayDeque provides better performance and more flexibility than Stack, as it allows for adding and removing elements from both ends of the deque, while Stack only allows for adding and removing elements from the top of the stack.
            ArrayDeque is not synchronized, meaning that it is not thread-safe and should not be used in multi-threaded environments without proper synchronization. Stack, on the other hand, is synchronized and can be used in multi-threaded environments. However, this synchronization comes with a performance overhead, making Stack slower than ArrayDeque in single-threaded environments.
            */



    }
}
