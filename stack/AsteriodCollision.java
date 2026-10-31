
import java.util.*;

public class AsteriodCollision {

    public static int[] asteroidCollision(int[] asteroids) {

        // Stack to maintain asteroids that have survived so far.
        Deque<Integer> st = new ArrayDeque<>();

        // Process every asteroid from left to right.
        for (int ast : asteroids) {

            // CASE 1: Positive asteroid.
            // Positive asteroid moves towards the right.
            // It cannot collide with any asteroid already in the stack,
            // because those asteroids are either moving left or are
            // positioned before it.
            if (ast >= 0) {
                st.push(ast);
            }

            // CASE 2: Negative asteroid.
            // Negative asteroid moves towards the left.
            // Collision is possible only when the top of the stack
            // contains a positive asteroid.
            else {

                // CASE 2.1:
                // Stack is empty.
                // No asteroid is available to collide with.
                // Therefore, current asteroid survives.
                if (st.isEmpty()) {
                    st.push(ast);
                }

                // CASE 2.2:
                // Top asteroid is also negative.
                // Both are moving in the same direction (left).
                // Therefore, no collision is possible.
                else if (st.peek() < 0) {
                    st.push(ast);
                }

                // CASE 2.3:
                // Stack top is positive and current asteroid is negative.
                // They are moving towards each other.
                // Collision is possible.
                else {

                    // Tracks whether the current asteroid gets destroyed.
                    boolean destroyed = false;

                    // Keep checking while:
                    // 1. Stack is not empty.
                    // 2. Current asteroid is still moving left.
                    // 3. Top asteroid is positive.
                    //
                    // We need a while loop because one negative asteroid
                    // can destroy multiple positive asteroids.
                    while (!st.isEmpty() && st.peek() > 0) {

                        // Compare magnitudes of both asteroids.

                        // CASE A:
                        // Positive asteroid is smaller.
                        // It gets destroyed.
                        //
                        // Current negative asteroid survives this collision
                        // and may collide with another asteroid.
                        if (st.peek() < -ast) {
                            st.pop();
                            continue;
                        }

                        // CASE B:
                        // Positive asteroid is larger.
                        // Current negative asteroid gets destroyed.
                        //
                        // No further collision checks are required.
                        else if (st.peek() > -ast) {
                            destroyed = true;
                            break;
                        }

                        // CASE C:
                        // Both asteroids have equal magnitude.
                        // Both get destroyed.
                        else {
                            st.pop();
                            destroyed = true;
                            break;
                        }
                    }

                    // If current asteroid survived all collisions,
                    // insert it into the stack.
                    if (!destroyed) {
                        st.push(ast);
                    }
                }
            }
        }

        // Stack contains surviving asteroids in reverse order.
        // Convert stack into the original left-to-right order.
        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] asteroids = {5, 10, -5};

        int[] result = asteroidCollision(asteroids);

        System.out.println(Arrays.toString(result));

        // Expected output: [5, 10]
    }
}
