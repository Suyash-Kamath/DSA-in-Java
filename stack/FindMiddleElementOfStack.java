import java.util.*;

public class FindMiddleElementOfStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int count = 0;
        int size = stack.size();

        printMiddleElementOfStack(stack, count, size);
    }

    public static void printMiddleElementOfStack(Deque<Integer> stack,int count,int size) {
        // int size = stack.size();
        // int middleIndex = size / 2;

        // for (int i = 0; i < middleIndex; i++) {
        //     stack.pop();
        // }

        // System.out.println("Middle element: " + stack.pop());


        // using Recursion

        if(count==size/2) {
            int middleElement = stack.pop();
            System.out.println("Middle element: " + middleElement);
            return;
        }

        stack.pop();
        count++;
        printMiddleElementOfStack(stack,count,size);
    }
}
