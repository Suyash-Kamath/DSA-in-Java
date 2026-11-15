public class ImplementQueueUsingArray {
    
    /*
    Front =0 and rear =-1 , front = rear , means queue having one element, so yeah 
    */


    static class MyQueue{
        int []arr ;
        int front =0;
        int rear;
        int capacity;
        int size;

        // constructor to initialize the queue
        public MyQueue(int n){
            arr = new int[n];
            capacity = n;
            rear = -1;
            size = 0;
            front =0;
        }

        // Insert at rear end of queue
        public boolean enqueue(int x){
            if(isFull()){
                System.out.println("Queue is full");
                return false;
            }
            else{
                rear++;
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
                arr[front]=-1;
                front++;
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

        // check if queue is full
        public boolean isFull(){

            // if queue has size and capacity equal , remember if I poll , then size 3 and capacity 4, it is still full becuase rear end se insertion hota hai naa , uske baad koi index nahi hai , isliye full hota hai , samjhe ? if there is one element but at the last index, then it is still full because we cannot insert anymore, and rear end keliye memory nahi hai jisse insertion ho sakte hai 

            // jaise we do poll , waise hi front aage badta hai number 

            // full means queue me aur data insert kar sakta hu ki nahi 
            if(rear == capacity -1){
                return true;
            }
            else{

                return false;
            }
        }



    }
public static void main(String[] args){

    MyQueue q = new MyQueue(5);
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    System.out.println("Front element is: " + q.getFront());
    System.out.println("Rear element is: " + q.getRear());
    System.out.println("Size of queue is: " + q.getSize());
    q.dequeue();
    System.out.println("Front element is: " + q.getFront());
    System.out.println("Rear element is: " + q.getRear());
    System.out.println("Size of queue is: " + q.getSize()); 
        
}
  
}
