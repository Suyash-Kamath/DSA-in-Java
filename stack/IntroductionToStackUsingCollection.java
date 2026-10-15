
import java.util.*;

class IntroductionToStackUsingCollection {
    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();

        // Push elements onto the stack
        st.push(10);
        st.push(20);
        st.push(30);

        // Display top element and size
        System.out.println("Stack Top Element: " + st.peek());
        System.out.println("Stack Size: " + st.size());

        // Remove the top element
        st.pop();

        // Display updated top element and size
        System.out.println("Stack Top Element: " + st.peek());
        System.out.println("Stack Size: " + st.size());

        // Check whether the stack is empty
        System.out.println("Stack Empty ?: " + st.isEmpty());

        // Remove and print all remaining elements
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
