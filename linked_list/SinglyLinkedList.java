public class SinglyLinkedList {

  static class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
  }

  private Node head; // to represent the first node of the linked list
  private Node tail; // to represent the last node of the linked list
  private int size; // to represent the number of nodes in the linked list

  // constructor to initialize the linked list

  public SinglyLinkedList(){
    this.head=null;
    this.tail=null;
    this.size=0;
  }

  // insert at head 
  public void insertAtHead(int data){
   
    Node newNode = new Node(data);
    if(head==null && tail==null){
        head=newNode;
        tail = newNode;
       
    }
    else{
        newNode.next= head;
        head=newNode;
    }
    size++;
   
  }
 // insert at tail
  public void insertAtTail(int data){
    Node newNode = new Node(data);
    if(head==null && tail==null){
        head = newNode;
        tail = newNode;
    }else{
        tail.next = newNode;
        tail = newNode;
    }
    size++;

  }

  // insert at any position and position is 1 based indexing
  public void insertAtPosition(int data,int position){

   if(position<1 || position>size+1){
    System.out.println("Invalid Position");
    return ;
   }
   if(position==1){
    insertAtHead(data);
    return;
   }
   if(position==size+1){
    insertAtTail(data);
    return;
   }
   else{
    Node newNode = new Node(data);
    Node previous = head;

    /*
    Off-by-one error in traversal:
    Your for loop runs position - 1 times. Since previous starts at head (position 1), advancing it position - 1 times moves previous directly to position instead of stopping at position - 1.
    Example: If you want to insert at position 2 in a list [10, 20, 30]:
    previous starts at head (10).
    The loop runs once (i = 1), setting previous = previous.next (20).
    It then inserts after 20, placing the new node at position 3 instead of position 2.
    */
    for(int i=1;i<position-1;i++){
        previous = previous.next;

    }
    newNode.next = previous.next;
    previous.next = newNode;
    size++;
   }

  }

  // traverse the linked list and print the elements
  
  public void print(){
    Node current = head;
    while(current!=null){
        System.out.print(current.data+"-> ");
        current = current.next;
    }
    System.out.println("null");
  }

  public int getSize(){
    return size;

  }

  public boolean isEmpty(){
    return head==null;
    }

    public int getHead(){
        if(head==null){
            return -1;
        }
        return head.data;

    }
    public int getTail(){
        if(tail==null){
            return -1;
        }
        return tail.data;
        
    }

    public void clear(){
        head = null;
        tail=null;
        size=0;
    }

    public boolean search(int data){
        Node current = head;
        while(current!=null){
            if(current.data==data){
                return true;

            }
            current = current.next;
        }
        return false;
    }

    public int findPosition(int data){
        Node current = head;
        int position = 1;
        while(current!=null){
            if(current.data==data){
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Data not found
    }
    
    
    public void updateAtPosition(int data,int position){
        
       
        Node temp = head;
        
        if(position<1 || position>size+1){
            System.out.println("Invalid Position");
            return ;
        }
        for(int i=1;i<position;i++){
            temp=temp.next;
        }
            temp.data = data;
    }
    // Update the first occurrence of oldValue with newValue in the linked list
    public boolean updateValue(int oldValue,int newValue){

        Node current = head;
        while(current!=null){
            if(current.data==oldValue){
                current.data = newValue;
                return true; // Exit after updating the first occurrence
            }
            current = current.next;
        }
        return false;

    }
    

    public void deleteHead(){
       
        if(head==null){
            System.out.println("The List is empty");
           
            return ;
        }
        head = head.next;
        size--;
        if(head==null){
            tail = null; // If the list becomes empty, update tail to null
        }
        

    }

    public void deleteTail(){
       
        if(tail==null){
            System.out.println("The List is empty ");
            return ;
        }
        if(head==tail){
            head = null;
            tail = null;
            size=0;
            return ;
        }

        Node current = head;
        while(current.next!=tail){
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;

    }

    public void deleteAtPosition(int position){
        if(position<1 || position > size+1){
            System.out.println("Invalid Position");
            return ;
        }
        if(position==1){
            deleteHead();
            return ;
        }
        if(position==size){
            deleteTail();
            return ;
        }

        Node previous = head;
        for(int i=1;i<position-1;i++){
            previous = previous.next;
        }
        Node current = previous.next;
        Node forward = current.next;

        previous.next = forward;
        current.next = null; // Help garbage collection
        size--;
       
    }


public boolean deleteValue(int value) {

    if (head == null) {
        System.out.println("The List is empty");
        return false;
    }

    if (head.data == value) {
        deleteHead();
        return true;
    }

    Node previous = head;
    Node current = head.next;

    while (current != null) {

        if (current.data == value) {

            previous.next = current.next;

            if (current == tail) {
                tail = previous;
            }

            current.next = null; // Help garbage collection
            size--;

            return true;
        }

        previous = current;
        current = current.next;
    }

    return false;
}

    public static void main(String[] args) {
       SinglyLinkedList list = new SinglyLinkedList(); // empty linked list
       if(list.isEmpty()){
        System.out.println("Linked List is empty");
       }
       System.out.println("Size of linked list = "+list.getSize());
         list.insertAtHead(10);
         list.print();
         list.insertAtHead(20);
         list.print();
         list.insertAtHead(30);
         list.print();

        list.insertAtTail(100);
        list.print();
        list.insertAtTail(110);
        list.print();
        list.insertAtTail(120);
        list.print();

        list.insertAtPosition(25,2);
        list.print();
        list.insertAtPosition(15,3);
        list.print();
        list.insertAtPosition(200,11);
        list.print();
        list.insertAtPosition(5,8);
        list.print();
        list.insertAtPosition(200,10);
        list.print();

        System.out.println("Size of linked list = "+list.getSize());
        System.out.println("Head of linked list = "+list.getHead());
        System.out.println("Tail of linked list = "+list.getTail());
        System.out.println("Searching for 100 in linked list = "+list.search(100));
        System.out.println("Position of 100 in linked list = "+list.findPosition(10000));
        System.out.println("Position of 100 in linked list = "+list.findPosition(100));
        list.updateAtPosition(900,3);
        list.print();
        System.out.println("Updating value 100 to 500 in linked list or not  = "+list.updateValue(100,500));
        list.print();

        list.deleteHead();
        list.print();

        list.deleteHead();
        list.print();

        list.deleteHead();
        list.print();

        list.deleteTail();
        list.print();

        list.deleteAtPosition(3);
        list.print();

        list.deleteAtPosition(1);
        list.print();

        list.deleteValue(120);
        list.print();

    }
    
}
 
