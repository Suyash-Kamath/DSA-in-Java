import java.util.*;
public class ValidParentheses {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // if i is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // if ch is a closing bracket, check if the stack is empty or if the top of the stack is not the corresponding opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // char top = stack.pop();
                // if ((c == ')' && top != '(') ||
                //     (c == '}' && top != '{') ||
                //     (c == ']' && top != '[')) {
                //     return false;

                // or can be used as this 

                else if ((c == ')' && stack.peek() != '(') ||
                    (c == '}' && stack.peek() != '{') ||
                    (c == ']' && stack.peek() != '[')) {
                    return false;

                }
                else {
                    // match canceled out, pop the opening bracket from the stack
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println(isValid(s1)); // true
        System.out.println(isValid(s2)); // true
        System.out.println(isValid(s3)); // false
        System.out.println(isValid(s4)); // false
        System.out.println(isValid(s5)); // true
    }
}
