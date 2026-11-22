import java.util.*;


public class StackBasics {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("Peek at the top of the stack: " + stack.peek());
        System.out.println("Pop the top of the stack: " + stack.pop());
        System.out.println("Stack after pop: " + stack);    

    }
}
