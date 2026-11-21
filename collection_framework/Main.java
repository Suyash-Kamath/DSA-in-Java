// Collection framework is a simple tool jiske dwara jo bhi DS hai unko replicate kar sakte ho via code .

/*

Collection which is a interface which List a sub interfaces extends and ArrayList implements the List interface. Collection framework is a unified architecture for representing and manipulating collections. It includes interfaces, implementations, and algorithms that provide a standard way to handle groups of objects.

*/

// import java.util.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

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
    
    }
}
