

import java.util.*;


public class IntroductionToStackUsingArray {
    static class MyStack{
        // private data members

        private int[] arr;
        private int capacity;
        private int top;

        // constructor

        public MyStack(int capacity){
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.top= -1;
            
        }

        // member functions 

        public void push(int value){
            if(top==capacity-1){
                System.out.println("Cannot Insert. Stack Overflow");
                return ;
            }
            else{
                top++;
                arr[top] = value;
            }
        }

        public void pop(){
            if(top==-1){
                System.out.println("Cannot Pop Element. Stack Underflow");
            }else{
                arr[top]=-1;
                top--;
            }
        }

        public int peek(){
            if(top==-1){
                System.out.println("There is no element in Stack");
                return -1;
            }else{
                return arr[top];
            }
        }

        public int getSize(){

            return top+1;

            
        }

        public int getCapacity(){
            return this.capacity;
        }

        public boolean checkEmpty(){
            if(top==-1) return true;
            else return false;
        }
    }
    public static void main(String[] args) {

        MyStack stack = new MyStack(3);
       

        stack.push(10);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());
        stack.push(20);
         System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());
        stack.push(30);
         System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());
        stack.push(40);
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

         stack.pop();
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        stack.pop();
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        stack.pop();
        System.out.println("Size: " + stack.getSize());
        System.out.println("Top element: " + stack.peek());

        stack.pop();
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("Is empty: " + stack.checkEmpty());
        
       
        System.out.println("Capacity: " + stack.getCapacity());
        
    }
}
