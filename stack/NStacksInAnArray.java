
import java.util.*;

/*
    Problem: N Stacks in an Array

    BRUTE FORCE APPROACH:

    Divide the array into N equal partitions.

    Example:
    S = 9, N = 3

    Stack 1 -> 3 spaces
    Stack 2 -> 3 spaces
    Stack 3 -> 3 spaces

    Problem:
    Suppose Stack 1 requires 5 spaces, but Stack 2 and Stack 3
    have unused spaces.

    We cannot use those unused spaces.

    This creates SPACE FRAGMENTATION.

    Also, an individual stack can overflow even when the
    overall array still has free space.

    OPTIMAL APPROACH:

    All N stacks share the same array dynamically.

    We maintain FOUR things:

    1. arr[S]
       Main array that stores the actual elements of all stacks.

    2. top[N]
       Stores the index of the top element of each stack.

       Initially:
       top = {-1, -1, -1, ...}

       -1 means that the corresponding stack is empty.

    3. next[S]
       This array has TWO responsibilities.

       CONDITION 1: If an index is OCCUPIED:
       next[index] stores the index of the previous element
       belonging to that particular stack.

       CONDITION 2: If an index is FREE:
       next[index] stores the index of the next free position.

       Therefore, next[] behaves like a linked list.

    4. freespot
       Stores the index of the first available free position.

       Initially:
       freespot = 0

       Because index 0 is the first available position.


    INITIALIZATION:

    Suppose N = 3 and S = 9.

    top[] = {-1, -1, -1}

    arr[] = {_, _, _, _, _, _, _, _, _}

    next[] = {1, 2, 3, 4, 5, 6, 7, 8, -1}

    freespot = 0

    Free list:

    0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> -1


    PUSH OPERATION:

    push(1, 10)

    1. Find the first free index.
       index = freespot

    2. Update freespot.
       freespot = next[index]

    3. Insert the value.
       arr[index] = value

    4. Connect the new element to the previous top.
       next[index] = top[stackIndex]

    5. Update the top of the selected stack.
       top[stackIndex] = index


    POP OPERATION:

    1. Find the current top index.
       index = top[stackIndex]

    2. Store the element before removing it.
       poppedElement = arr[index]

    3. Update the top to the previous element.
       top[stackIndex] = next[index]

    4. Return the removed index to the free list.
       next[index] = freespot

    5. Update freespot.
       freespot = index

    6. Return poppedElement.


    IMPORTANT:

    Push -> Overflow check
    Pop  -> Underflow check

    TIME COMPLEXITY:
    Push -> O(1)
    Pop  -> O(1)
    Top  -> O(1)

    SPACE COMPLEXITY:
    O(S + N)
*/

public class NStacksInAnArray {

    class NStacks {

        // Main array: stores actual values of all N stacks.
        private int[] arr;

        // top[i] stores the array index of the top element
        // of stack number i.
        private int[] top;

        /*
            next[] maintains the links.

            If index is occupied:
                next[index] = previous element's index
                              in the same stack.

            If index is free:
                next[index] = next available free index.
        */
        private int[] next;

        // Points to the first available free position.
        private int freespot;


        /*
            CONSTRUCTOR

            N = Number of stacks.
            S = Total size of the shared array.

            Initially:
            - Every stack is empty.
            - Every array position is free.
            - Free positions are connected sequentially.
        */

        public NStacks(int N, int S) {

            // Validate constructor arguments.
            if (N <= 0 || S < 0) {
                throw new IllegalArgumentException(
                    "N must be positive and S cannot be negative"
                );
            }

            // Main array to store elements.
            arr = new int[S];

            // Top array to maintain N individual stacks.
            top = new int[N];

            // Initialize every stack as empty.
            for (int i = 0; i < N; i++) {
                top[i] = -1;
            }

            // Auxiliary array to maintain free and occupied links.
            next = new int[S];

            /*
                Initially, all array positions are free.

                Connect them sequentially:

                0 -> 1 -> 2 -> 3 -> ... -> S-1 -> -1

                -1 indicates that no more free positions exist.
            */

            for (int i = 0; i < S - 1; i++) {
                next[i] = i + 1;
            }

            // Last index has no next free position.
            if (S > 0) {
                next[S - 1] = -1;
            }

            // Initially, index 0 is the first free position.
            // If S = 0, there is no available position.
            freespot = (S == 0) ? -1 : 0;
        }


        /*
            PUSH OPERATION

            Insert a value into the specified stack.

            stackNum is 1-based:
            Stack 1 -> top[0]
            Stack 2 -> top[1]
            Stack 3 -> top[2]

            We convert stackNum into a 0-based index.

            Example:

            push(1, 10)

            stackIndex = 1 - 1 = 0

            So we are inserting into Stack 1.
        */

        public boolean push(int stackNum, int value) {

            // Convert 1-based stack number into 0-based index.
            int stackIndex = stackNum - 1;

            // Validate the stack number.
            if (stackIndex < 0 || stackIndex >= top.length) {
                throw new IllegalArgumentException("Invalid stack number");
            }

            // OVERFLOW CONDITION:
            // freespot == -1 means no free cell is available.
            if (freespot == -1) {
                return false;
            }

            // Step 1:
            // Get the first available free array index.
            int index = freespot;

            // Step 2:
            // Move freespot to the next available free position.
            // next[index] currently stores the next free index.
            freespot = next[index];

            // Step 3:
            // Insert the actual value into the selected array position.
            arr[index] = value;

            // Step 4:
            // Connect this new element to the previous top
            // of the selected stack.
            //
            // Remember:
            // For an occupied index, next[] stores the previous
            // element's index in the same stack.
            next[index] = top[stackIndex];

            // Step 5:
            // Update the top of the selected stack.
            // The newly inserted element becomes the top.
            top[stackIndex] = index;

            // Successfully pushed the element.
            return true;
        }


        /*
            POP OPERATION

            Remove the top element from the specified stack.

            Example:

            Stack 1:

            TOP -> 30 (index 2)
                   20 (index 0)
                   10 (index 4)

            top[0] = 2
            next[2] = 0

            After POP:

            top[0] = 0

            Index 2 becomes available again.
        */

        public int pop(int stackNum) {

            // Convert 1-based stack number into 0-based index.
            int stackIndex = stackNum - 1;

            // Validate the stack number.
            if (stackIndex < 0 || stackIndex >= top.length) {
                throw new IllegalArgumentException("Invalid stack number");
            }

            // UNDERFLOW CONDITION:
            // If top is -1, the selected stack is empty.
            if (top[stackIndex] == -1) {
                return -1;
            }

            // Step 1:
            // Get the array index of the current top element.
            int index = top[stackIndex];

            // Step 2:
            // Store the element before removing it.
            int poppedElement = arr[index];

            // Step 3:
            // Update the stack top to the previous element.
            //
            // For occupied indexes, next[index] stores
            // the previous element's index.
            top[stackIndex] = next[index];

            // Step 4:
            // Return the removed index to the free list.
            //
            // The current freespot becomes the next free position
            // after this newly released index.
            next[index] = freespot;

            // Step 5:
            // The removed index becomes the new first free position.
            freespot = index;

            // Step 6:
            // Return the removed element.
            return poppedElement;
        }


        /*
            TOP OPERATION

            Return the top element without removing it.

            top[stackIndex] gives us the array index directly.

            Therefore, we can access the value in O(1).
        */

        public int top(int stackNum) {

            // Convert 1-based stack number into 0-based index.
            int stackIndex = stackNum - 1;

            // Validate the stack number.
            if (stackIndex < 0 || stackIndex >= top.length) {
                throw new IllegalArgumentException("Invalid stack number");
            }

            // If top is -1, the stack is empty.
            if (top[stackIndex] == -1) {
                return -1;
            }

            // Get the index of the top element.
            int index = top[stackIndex];

            // Return the actual value stored at that index.
            return arr[index];
        }


        /*
            ISEMPTY OPERATION

            A stack is empty when its top index is -1.

            We don't need to traverse the array.
            Simply check the top array.
        */

        public boolean isEmpty(int stackNum) {

            // Convert 1-based stack number into 0-based index.
            int stackIndex = stackNum - 1;

            // Validate the stack number.
            if (stackIndex < 0 || stackIndex >= top.length) {
                throw new IllegalArgumentException("Invalid stack number");
            }

            // Return true if no element exists in this stack.
            return top[stackIndex] == -1;
        }
    }


    public static void main(String[] args) {

        // Create 3 stacks using a shared array of size 9.
        NStacksInAnArray obj = new NStacksInAnArray();

        NStacks stacks = obj.new NStacks(3, 9);

        // PUSH operations.
        System.out.println(stacks.push(1, 10)); // true
        System.out.println(stacks.push(1, 20)); // true
        System.out.println(stacks.push(2, 30)); // true
        System.out.println(stacks.push(3, 40)); // true
        System.out.println(stacks.push(1, 50)); // true

        // TOP operations.
        System.out.println(stacks.top(1)); // 50
        System.out.println(stacks.top(2)); // 30
        System.out.println(stacks.top(3)); // 40

        // POP operation.
        System.out.println(stacks.pop(1)); // 50

        // The freed index can be reused by another stack.
        System.out.println(stacks.push(3, 60)); // true

        // Updated TOP operations.
        System.out.println(stacks.top(1)); // 20
        System.out.println(stacks.top(2)); // 30
        System.out.println(stacks.top(3)); // 60

        // Check whether Stack 2 is empty.
        System.out.println(stacks.isEmpty(2)); // false

        // Pop remaining elements.
        System.out.println(stacks.pop(1)); // 20
        System.out.println(stacks.pop(1)); // 10

        // Stack 1 is now empty.
        System.out.println(stacks.isEmpty(1)); // true

        // Underflow.
        System.out.println(stacks.pop(1)); // -1
    }
}
