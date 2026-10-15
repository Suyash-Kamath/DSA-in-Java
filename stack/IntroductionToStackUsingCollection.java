import java.util.*;

class IntroductionToStackUsingCollection {
    public static void main(String[] args) {
       Deque<Integer> st = new ArrayDeque<>();

        st.push(10);
        st.push(20);
        st.push(30);

        
        System.out.println("Stack Top Element: "+st.peek());
        System.out.println("Stack Size: "+st.size());

        st.pop();

        System.out.println("Stack Top Element: "+st.peek());
         System.out.println("Stack Size: "+st.size());

         System.out.println("Stack Empty ?: "+st.isEmpty());
        
    }
}
