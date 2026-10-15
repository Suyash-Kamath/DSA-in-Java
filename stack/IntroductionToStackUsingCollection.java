
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

/*



When you write:

```
Deque<Integer> st = new ArrayDeque<>();

st.push(null);
```

Java throws a `NullPointerException` at runtime.

### Why?

`ArrayDeque` does not allow `null` elements. This is intentional because methods like `peek()` return `null` when the deque is empty, so allowing `null` as a stored element would make it harder to distinguish an empty deque from one containing `null`.

Example:

```
import java.util.*;

class Main {
    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();

        st.push(10);
        st.push(null); // NullPointerException

        System.out.println(st);
    }
}
```

The program terminates at `st.push(null)` unless you catch the exception.

### What about other values?

| Operation       | Result                        |
| --------------- | ----------------------------- |
| `st.push(10)`   | Works                         |
| `st.push(0)`    | Works                         |
| `st.push(-1)`   | Works                         |
| `st.push(null)` | Throws `NullPointerException` |

Remember: `0` and `-1` are valid integers. `null` means there is no object reference.

For stack problems in Java, `Deque<Integer> st = new ArrayDeque<>();` is a good choice.

*/
