import java.util.*;

public class CheckRedundantBracket {

/*    public static boolean hasRedundantBrackets(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                boolean hasOperator = false;

                while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '[' && stack.peek() != '{') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Pop the opening bracket
                if (!stack.isEmpty()) {
                    stack.pop();
                }

                // If no operator was found between the brackets, they are redundant
                if (!hasOperator) {
                    return true;
                }
            }
        }

        return false;
    }

    */

public static boolean hasRedundantBrackets(String s) {

    // Stack banaya hai jo opening brackets aur operators store karega.
    // Hum operands (a, b, c, etc.) ko stack mein store nahi karenge.
    Deque<Character> stack = new ArrayDeque<>();

    // Expression ke har character ko left se right traverse karo.
    for (char ch : s.toCharArray()) {

        // Agar current character opening bracket hai:
        // '(', '{', '['
        //
        // YA koi arithmetic operator hai:
        // '+', '-', '*', '/'
        //
        // Toh usko stack mein push kar do.
        if (ch == '{' || ch == '(' || ch == '[' ||
            ch == '+' || ch == '-' || ch == '*' || ch == '/') {

            stack.push(ch);

        } else {

            // Agar current character closing bracket hai:
            // ')', '}', ']'
            //
            // Toh check karna hai ki corresponding opening
            // aur closing bracket ke beech koi operator hai ya nahi.
            if (ch == '}' || ch == ')' || ch == ']') {

                // Initially assume karo ki brackets ke andar
                // koi operator nahi mila hai.
                //
                // Agar operator nahi mila, brackets redundant hain.
                boolean hasOperator = false;

                // Stack ko tab tak process karo jab tak
                // corresponding opening bracket nahi mil jaata.
                while (!stack.isEmpty()) {

                    // Stack ka top character dekho.
                    // peek() element ko remove nahi karta.
                    char temp = stack.peek();

                    // Agar stack ke top par operator mila,
                    // toh iska matlab current brackets ke andar
                    // ek operator present hai.
                    //
                    // Isliye hasOperator ko true kar do.
                    if (temp == '+' || temp == '-' ||
                        temp == '*' || temp == '/') {

                        hasOperator = true;
                    }

                    // Agar current closing bracket '}' hai
                    // aur stack ka top corresponding '{' hai,
                    // toh matching opening bracket mil gaya.
                    //
                    // Opening bracket ko pop karo aur
                    // while loop se bahar aa jao.
                    if (ch == '}' && temp == '{') {
                        stack.pop();
                        break;
                    }

                    // Agar current closing bracket ']' hai
                    // aur stack ka top corresponding '[' hai,
                    // toh matching opening bracket mil gaya.
                    if (ch == ']' && temp == '[') {
                        stack.pop();
                        break;
                    }

                    // Agar current closing bracket ')' hai
                    // aur stack ka top corresponding '(' hai,
                    // toh matching opening bracket mil gaya.
                    if (ch == ')' && temp == '(') {
                        stack.pop();
                        break;
                    }

                    // Agar abhi matching opening bracket nahi mila,
                    // toh stack ke top element ko remove kar do.
                    //
                    // Example: (a+b)
                    //
                    // Closing ')' milne par:
                    // Stack top -> '+'
                    // '+' ko check karke pop karenge.
                    //
                    // Next top -> '('
                    // Matching opening bracket mil jayega.
                    stack.pop();
                }

                // Agar matching brackets ke andar
                // ek bhi operator nahi mila,
                // toh brackets redundant hain.
                //
                // Example:
                // ((a+b)) -> true
                // (a)     -> true
                //
                // Jaise hi redundant brackets milte hain,
                // immediately true return kar do.
                if (!hasOperator) {
                    return true;
                }
            }
        }
    }

    // Poora expression traverse ho gaya
    // aur koi redundant bracket nahi mila.
    //
    // Example: (a+b*(c-d))
    //
    // Isliye false return karo.
    return false;
}

       public static void main(String[] args) {
        String expression1 = "((a+b))";
        String expression2 = "(a+(b)/c)";
        String expression3 = "(a+b*(c-d))";

        System.out.println("Expression: " + expression1 + " has redundant brackets? " + hasRedundantBrackets(expression1));
        System.out.println("Expression: " + expression2 + " has redundant brackets? " + hasRedundantBrackets(expression2));
        System.out.println("Expression: " + expression3 + " has redundant brackets? " + hasRedundantBrackets(expression3));
    }
}
