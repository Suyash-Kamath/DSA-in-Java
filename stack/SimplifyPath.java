
import java.util.*;

public class SimplifyPath {

    public static String simplifyPath(String path) {

        /*
         * APPROACH:
         *
         * We use a STACK to simplify the Unix-style absolute path.
         *
         * Rules:
         *
         * 1. ""   -> Ignore empty parts caused by multiple "/" characters.
         * 2. "."  -> Ignore it because it means the current directory.
         * 3. ".." -> Move one directory backward, if possible.
         * 4. name -> Add a valid directory name to the stack.
         *
         * Example:
         *
         * Input  : "/home//user/../docs/./file"
         * Output : "/home/docs/file"
         *
         * WHY A STACK?
         *
         * When we encounter "..", we need to remove the most recently
         * added directory. This is exactly what a stack supports:
         *
         * push() -> Add an element.
         * pop()  -> Remove the top element.
         *
         * We use ArrayDeque because it provides efficient stack operations.
         */

        Deque<String> st = new ArrayDeque<>();

        /*
         * STEP 1: SPLIT THE PATH
         *
         * "/" is the separator between directory names.
         *
         * Example:
         *
         * "/home//user/../docs"
         *
         * becomes approximately:
         *
         * ["", "home", "", "user", "..", "docs"]
         *
         * Empty strings appear because the path may begin with "/"
         * or contain consecutive slashes like "//".
         *
         * We will ignore those empty strings in the loop below.
         */
        String[] parts = path.split("/");

        /*
         * STEP 2: PROCESS EACH PART
         *
         * Enhanced for-loop:
         *
         * for (String part : parts)
         *
         * means:
         * Take each string from the parts array, one by one,
         * and store it in the variable "part".
         */
        for (String part : parts) {

            /*
             * CASE 1: EMPTY PART
             *
             * Example:
             * "/home//user"
             *
             * The consecutive "//" produces an empty part.
             *
             * Empty parts do not represent directories, so skip them.
             */
            if (part.isEmpty()) {
                continue;
            }

            /*
             * CASE 2: CURRENT DIRECTORY "."
             *
             * "." means "stay in the current directory".
             *
             * Therefore, it does not change the simplified path.
             *
             * Example:
             * "/home/./user" -> "/home/user"
             */
            if (part.equals(".")) {
                continue;
            }

            /*
             * CASE 3: PARENT DIRECTORY ".."
             *
             * If the stack is empty, we are already at the root.
             *
             * Example:
             * "/../../home"
             *
             * We cannot move above the root directory "/".
             *
             * Therefore, ignore ".." when the stack is empty.
             */
            if (part.equals("..") && st.isEmpty()) {
                continue;
            }

            /*
             * CASE 4: PARENT DIRECTORY ".." WITH A DIRECTORY AVAILABLE
             *
             * If the stack is NOT empty, remove one directory.
             *
             * Example:
             *
             * Current stack (top first): ["user", "home"]
             *
             * Encounter ".."
             *
             * pop() removes "user".
             *
             * Remaining stack (top first): ["home"]
             *
             * This represents moving one directory backward.
             */
            if (part.equals("..") && !st.isEmpty()) {
                st.pop();
            }

            /*
             * CASE 5: NORMAL DIRECTORY NAME
             *
             * If the part is neither empty, "." nor "..",
             * it represents a normal directory name.
             *
             * Example:
             * "home", "user", "docs"
             *
             * push() inserts the directory at the TOP of the stack.
             *
             * IMPORTANT:
             * We use else here because if the preceding if-condition
             * handled "..", we must NOT add ".." to the stack.
             */
            else {
                st.push(part);
            }
        }

        /*
         * STEP 3: BUILD THE FINAL SIMPLIFIED PATH
         *
         * CASE 1: STACK IS EMPTY
         *
         * If there are no directory names left, the simplified path
         * points to the root directory.
         *
         * Example:
         * "/home/.."
         *
         * "home" is pushed.
         * ".." removes "home".
         * Stack becomes empty.
         *
         * Final answer: "/"
         */
        if (st.isEmpty()) {

            // Root Directory
            return "/";

        } else {

            /*
             * CASE 2: STACK IS NOT EMPTY
             *
             * We need to convert the directory names into a path.
             *
             * WHY StringBuilder?
             *
             * StringBuilder allows us to append strings efficiently
             * without creating a new String object for every append.
             */
            StringBuilder str = new StringBuilder();

            /*
             * IMPORTANT CONCEPT: STACK ORDER
             *
             * Suppose we processed:
             *
             * "/home/user/docs"
             *
             * We used push(), so the stack looks like this:
             *
             * TOP    -> docs
             *          user
             * BOTTOM -> home
             *
             * If we repeatedly use pop(), the order would be:
             *
             * docs -> user -> home
             *
             * But we want the final path to be:
             *
             * /home/user/docs
             *
             * Therefore, we use removeLast() to remove elements
             * from the BOTTOM of the deque first.
             *
             * removeLast() returns the element AND removes it.
             *
             * That is why we must NOT call st.pop() afterward:
             * doing so would remove an additional element.
             */
            while (!st.isEmpty()) {

                // Add "/" before every directory name.
                str.append("/");

                /*
                 * Remove the LAST element of the deque and append it.
                 *
                 * For the example above:
                 *
                 * First iteration:
                 * removeLast() -> "home"
                 * str = "/home"
                 *
                 * Second iteration:
                 * removeLast() -> "user"
                 * str = "/home/user"
                 *
                 * Third iteration:
                 * removeLast() -> "docs"
                 * str = "/home/user/docs"
                 *
                 * The deque becomes empty, so the loop stops.
                 */
                str.append(st.removeLast());

                /*
                 * YOUR ORIGINAL CODE:
                 *
                 * str.append(st.peek());
                 * st.pop();
                 *
                 * str.reverse().toString();
                 *
                 * Bro, your observation was correct:
                 * reverse() reverses CHARACTERS, not just directory order.
                 *
                 * For example:
                 *
                 * "/home/user".reverse()
                 *
                 * becomes:
                 *
                 * "resu/emoh/"
                 *
                 * That is not the path we want.
                 *
                 * Using removeLast() preserves the correct directory order.
                 *
                 * ALSO:
                 * Do not uncomment st.pop() after removeLast().
                 * removeLast() has already removed one element.
                 */
            }

            // Return the correctly ordered, simplified absolute path.
            return str.toString();
        }
    }

    public static void main(String[] args) {

        /*
         * STEP 4: TEST THE METHOD
         *
         * Each test checks a different path-simplification rule.
         */

        System.out.println(simplifyPath("/home/"));
        // Expected: /home

        System.out.println(simplifyPath("/home//user/"));
        // Expected: /home/user

        System.out.println(simplifyPath("/home/./user"));
        // Expected: /home/user

        System.out.println(simplifyPath("/home/../"));
        // Expected: /

        System.out.println(simplifyPath("/../../home"));
        // Expected: /home

        System.out.println(simplifyPath("/a/./b/../../c/"));
        // Expected: /c

        System.out.println(simplifyPath("/home/user/docs"));
        // Expected: /home/user/docs

        System.out.println(simplifyPath("/.../b"));
        // Expected: /.../b
        // "..." is a normal directory name, not the special "..".
    }
}
