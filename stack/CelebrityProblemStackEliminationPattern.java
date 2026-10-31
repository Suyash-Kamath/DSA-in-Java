
import java.util.*;

public class CelebrityProblemStackEliminationPattern {

    public static int findCelebrity(int[][] M, int n) {

        Deque<Integer> st = new ArrayDeque<>();

        // Step 1: Put all individuals into the stack
        // Initially, everyone is a potential celebrity
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        // Step 2: Stack Elimination Pattern
        // Ek baar mein 2 individuals ko pop karunga
        // Dono mein se ek definitely celebrity nahi ho sakta
        while (st.size() >= 2) {

            int a = st.pop();
            int b = st.pop();

            if (M[a][b] == 1) {

                // a knows b -> a celebrity nahi ho sakta
                // Celebrity kisi ko nahi jaanta
                // b abhi bhi potential celebrity ho sakta hai
                st.push(b);

            } else {

                // a does not know b -> b celebrity nahi ho sakta
                // Agar a, b ko nahi jaanta, toh b celebrity nahi ho sakta
                // a abhi bhi potential celebrity ho sakta hai
                st.push(a);
            }
        }

        // Step 3: Stack mein ab sirf ek individual bacha hoga
        // Elimination process ne baaki sabko reject kar diya
        // But abhi bhi confirm nahi hai ki ye celebrity hai
        int celebIndex = st.pop();

        // Step 4: Verify outgoing relationships
        // Celebrity kisi ko nahi jaanta
        // Isliye celebrity ki row mein sabhi values 0 honi chahiye
        for (int i = 0; i < n; i++) {

            if (M[celebIndex][i] == 1) {

                // Agar celebrity kisi ek person ko bhi jaanta hai
                // Toh celebrity condition violate ho gayi
                return -1;
            }
        }

        // Step 5: Verify incoming relationships
        // Celebrity ko baaki sabhi individuals jaante hone chahiye
        // Isliye har individual ke row mein celebrity ka column check karenge
        for (int i = 0; i < n; i++) {

            // Apne aap ko check nahi karna
            // Celebrity ko khud ko jaanna necessary nahi hai
            if (i != celebIndex) {

                if (M[i][celebIndex] == 0) {

                    // Agar koi ek individual bhi celebrity ko nahi jaanta
                    // Toh celebrity condition violate ho gayi
                    return -1;
                }
            }
        }

        // Step 6: Both celebrity conditions are satisfied
        // 1. Celebrity kisi ko nahi jaanta
        // 2. Baaki sabhi individuals celebrity ko jaante hain
        // Hence, celebIndex is the actual celebrity
        return celebIndex;
    }

    public static void main(String[] args) {

        int[][] M = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };

        int n = M.length;

        int ans = findCelebrity(M, n);

        System.out.println("Celebrity Index: " + ans);
    }
}
