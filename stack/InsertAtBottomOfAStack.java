import java.util.*;

public class InsertAtBottomOfAStack {

    public static Stack<Integer> insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return stack;
        }

        int topElement = stack.pop();
        insertAtBottom(stack, element);
        stack.push(topElement);

        return stack;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Original Stack: " + stack);
        insertAtBottom(stack, 4);
        System.out.println("Stack after inserting at bottom: " + stack);
    }
}
