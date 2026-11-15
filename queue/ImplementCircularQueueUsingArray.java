public class ImplementCircularQueueUsingArray {
    
    static class MyCircularQueue {
        int[] arr;
        int front, rear, size, capacity;

        // Constructor to initialize the queue
        public MyCircularQueue(int k) {
            this.capacity = k;
            this.arr = new int[k];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        // Insert an element into the circular queue
        public boolean enqueue(int x) {
            if(size == capacity){
                System.out.println("Queue is full");
                return false;
            }
            else{
                rear = (rear + 1) % capacity;
                arr[rear] = x;
                size++;
                System.out.println(x + " inserted into queue");
                return true;
            }
        }

        // Remove from front end of queue
        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            else{
                int data = arr[front];
                front = (front + 1) % capacity;
                size--;
                System.out.println("Element removed from queue");
                return data;
            }
        }

        // get front element of queue
        public int getFront(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            else{
                return arr[front];
            }
        }

        // get the rear element of queue
        public int getRear(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            else{
                return arr[rear];
            }   
        }

        // return size of queue
        public int getSize(){
            return this.size;
        }

        // Check if queue is empty

        public boolean isEmpty(){
            return size == 0;
        }
        
        public boolean isFull(){
            return size == capacity;
        }
    }
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(5);
        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        System.out.println("Front of queue: " + circularQueue.getFront());                  
        System.out.println("Rear of queue: " + circularQueue.getRear());
        circularQueue.dequeue();
        System.out.println("Front of queue after dequeue: " + circularQueue.getFront());
        System.out.println("Size of queue: " + circularQueue.getSize());
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);
        circularQueue.enqueue(60); // This should show that the queue is full
        System.out.println("Is queue full? " + circularQueue.isFull());
        circularQueue.dequeue();
        circularQueue.enqueue(70); // This should succeed now
        System.out.println("Front of queue: " + circularQueue.getFront());
        System.out.println("Rear of queue: " + circularQueue.getRear());
        
    }

}
