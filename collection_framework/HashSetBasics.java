
import java.util.*;

public class HashSetBasics {

    public static void main(String[] args) {

        // HashSet does not guarantee insertion order.
        // It does not allow duplicate elements.
        // It allows one null element.
        // Internally backed by a HashMap.
        // Average O(1) for add, remove and contains,
        // assuming a good hash distribution.
        // Not thread-safe.

        Set<Integer> hashSet = new HashSet<>();

        // 1. add() - Adds an element if it is not already present.
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(10); // Duplicate, ignored

        System.out.println("HashSet: " + hashSet);

        // 2. addAll() - Adds all elements from another collection.
        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(40);
        anotherSet.add(50);
        anotherSet.add(20);

        hashSet.addAll(anotherSet);

        System.out.println("After addAll: " + hashSet);

        // 3. iterator() - Iterates through the elements.
        Iterator<Integer> iterator = hashSet.iterator();

        System.out.println("\nIterating HashSet:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 4. remove() - Removes the specified element.
        boolean removed = hashSet.remove(20);

        System.out.println("\nRemoved 20: " + removed);
        System.out.println("After remove: " + hashSet);

        // 5. removeAll() - Removes all elements
        // that are also present in another collection.
        Set<Integer> removeSet = new HashSet<>(
                Arrays.asList(10, 40)
        );

        hashSet.removeAll(removeSet);

        System.out.println("After removeAll: " + hashSet);

        // 6. retainAll() - Keeps only elements
        // that are present in another collection.
        Set<Integer> retainSet = new HashSet<>(
                Arrays.asList(30, 50, 60)
        );

        hashSet.retainAll(retainSet);

        System.out.println("After retainAll: " + hashSet);

        // 7. clear() - Removes all elements.
        hashSet.clear();

        System.out.println("\nAfter clear: " + hashSet);

        // Add elements again for remaining operations.
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);

        // 8. size() - Returns the number of elements.
        System.out.println("\nSize: " + hashSet.size());

        // 9. toArray() - Converts the Set into an Object array.
        Object[] array = hashSet.toArray();

        System.out.println("Array: " + Arrays.toString(array));

        // Type-safe array conversion.
        Integer[] integerArray = hashSet.toArray(new Integer[0]);

        System.out.println("Integer Array: " +
                Arrays.toString(integerArray));

        // 10. contains() - Checks whether an element exists.
        System.out.println("\nContains 20: " +
                hashSet.contains(20));

        // 11. containsAll() - Checks whether all elements
        // of another collection exist in this Set.
        Set<Integer> checkSet = new HashSet<>(
                Arrays.asList(10, 20)
        );

        System.out.println("Contains all: " +
                hashSet.containsAll(checkSet));

        // 12. hashCode() - Returns the hash code of the Set.
        System.out.println("HashCode: " + hashSet.hashCode());



        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        System.out.println("\nSet1: " + set1);
        set1.retainAll(set2);
        // the above is intersection of two sets
        System.out.println("Intersection of Set1 and Set2: " + set1);

        System.out.println(set1.containsAll(set2));
        System.out.println(set2.containsAll(set1));

        // 1. Default constructor
Set<Integer> set = new HashSet<>();

// 2. Specify initial capacity
Set<Integer> initialCapacity = new HashSet<>(16);

// 3. Specify initial capacity and load factor
Set<Integer> set3 = new HashSet<>(8, 0.75f);

// 4. Create HashSet from another collection
Set<Integer> set4 = new HashSet<>(
    Arrays.asList(10, 20, 30)
);


/*
 * HashSet is an implementation of the Set interface backed by a HashMap.
 * It is commonly used when we need fast insertion, deletion, and lookup (contains) operations.
 * HashSet uses hashCode() to determine the bucket in which an element should be stored and equals() to check whether two elements are logically equal.
 * Hash codes are not guaranteed to be unique, so collisions can occur.
 * HashSet does not allow duplicate elements (based on equals()) and allows only one null element.
 * It does not maintain insertion order or sorted order.
 * HashSet does not support index-based or random access like ArrayList.
 * Its basic operations (add, remove, contains) take O(1) average time, assuming a good hash distribution.
 * HashSet itself also has a hashCode() method, which returns the sum of the hash codes of its elements.
 * HashSet is not synchronized (not thread-safe).
 */


// if you want to maintain insertion order use LinkedHashSet
Set<Integer> linkedHashSet = new LinkedHashSet<>();
linkedHashSet.add(40);
linkedHashSet.add(10);
linkedHashSet.add(20);
linkedHashSet.add(30);
linkedHashSet.add(10); // Duplicate, ignored
System.out.println("LinkedHashSet: " + linkedHashSet);






// no need for enumSet as original enums se bhi kaam ho jaata hai 

// TreeSet -> ouput is in sorted array 

// HashedSet -> Values I am getting randomly, hashed function generates hashcode for each value and stores element in an array-like structure based on the hashcode. So, the order of elements is not guaranteed to be the same as the insertion order. and T.C is O(1)
// insertion and access T.C is O(1) , but if there are collisions then T.C can be O(n) in worst case

// LinkedHashSet-> underlying implementation is doubly linked list and hashset , so it maintains insertion order and T.C is O(1) for insertion and access
// addition is O(1) , but removal and access is O(n) as we have to traverse the linked list to find the element

// TreeSet -> underlying implementation is Binary Search Tree , so it maintains sorted order and T.C is O(log n) for insertion and access , seach 


/*

If I want to use HashSet on custom object then i have to override equals and hashCode



*/

HashSet<Student>custom = new HashSet<>();

Student s1 = new Student(1,"Suyash" );
Student s2 = new Student(1, "Suyash");
Student s3 = new Student(1,"Suyash");

custom.add(s1);
custom.add(s2);
custom.add(s3);

System.out.println(custom);

// three object has same values but wo alag alag treat kar raha hai 


// for set , custom type of data se deal kar raha hai 

// rule is roll number alag alag 


// when I have custom type of object , set criteria which to consider equal or not and override equals as well as hashCode

        
    }
}
