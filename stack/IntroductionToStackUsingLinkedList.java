
import java.util.*;

public class IntroductionToStackUsingLinkedList {

    static class MyStack {

        // Node class
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // Private data members
        private Node top;
        private int size;

        // Constructor
        public MyStack() {
            this.top = null;
            this.size = 0;
        }

        // Push: Insert element at the top
        public void push(int value) {
            Node newNode = new Node(value);

            newNode.next = top;
            top = newNode;

            size++;
        }

        // Pop: Remove element from the top
        public void pop() {
            if (top == null) {
                System.out.println("Cannot Pop Element. Stack Underflow");
                return;
            }

            top = top.next;
            size--;
        }

        // Peek: Return the top element
        public int peek() {
            if (top == null) {
                System.out.println("There is no element in Stack");
                return -1;
            }

            return top.data;
        }

        // Get current size
        public int getSize() {
            return size;
        }

        // Linked List stack has no fixed capacity
        public int getCapacity() {
            return Integer.MAX_VALUE;
        }

        // Check whether stack is empty
        public boolean checkEmpty() {
            return top == null;
        }

        // Display all elements from top to bottom
        public void display() {
            Node current = top;

            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(10);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        stack.push(20);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        stack.push(30);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        System.out.println("Is empty: " + stack.checkEmpty());

        System.out.println("Stack elements:");
        stack.display();

        stack.pop();
        System.out.println("After pop, top element: " + stack.peek());
        System.out.println("Size: " + stack.getSize());
    }
}
