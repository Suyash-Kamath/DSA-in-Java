public class CircularSinglyLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public CircularSinglyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head==null){
            head=newNode;
            tail=newNode;
            tail.next=head;
        }else{
            newNode.next=head;
            head=newNode;
            tail.next=head;
        }
        size++;
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data);

        if(head==null){
            head=newNode;
            tail=newNode;
            tail.next=head;
        }else{
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
        }
        size++;
    }

    public void insertAtPosition(int data,int position){
        if(position<1 || position>size+1){
            System.out.println("Invalid Position");
            return;
        }
        if(position==1){
            insertAtHead(data);
            return;
        }
        if(position==size+1){
            insertAtTail(data);
            return;
        }else{
            Node newNode = new Node(data);

            // Node previous = head;

            Node prevNode = head;

            for(int i=1;i<position-1;i++){
                prevNode=prevNode.next;
            }
            // newNode.next=previous.next;
            // previous.next=newNode;

            Node currNode = newNode;
            Node nextNode = prevNode.next;

            prevNode.next=currNode;
            currNode.next=nextNode;

            size++;
        }
    }


    public void printList(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        // used do while loop because we want to print the head node as well and in circular linked list the last node points to head node so we can use do while loop to print the list
        do{
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println("Back to head");
    }

    public boolean search(int data){
        if(head==null){
            System.out.println("List is empty");
            return false;
        }
        Node temp = head;
        int position=1;
        do{
            if(temp.data==data){
                System.out.println("Element found at position: "+position);
                return true;
            }
            temp=temp.next;
            position++;
        }while(temp!=head);
        System.out.println("Element not found");
        return false;
    }

    public void deleteAtHead(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
            size=0;
            return;

        }else{
            Node temp = head;
            head=head.next;
            tail.next=head;
            temp.next=null; // temp wala node is isolated now , jaise function return karega , temp local variable will be destroyed and garbage collector will take care of it as it is unreachable node right ?
        }
        size--;
    }

    public void deleteAtTail(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
            size=0;
            return;
        }else{
            Node temp = head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            temp.next=head;
            tail=temp;
        }
        size--;
    }

    public void deleteAtPosition(int position){
        if(position<1 || position>size){
            System.out.println("Invalid Position");
            return;
        }
        if(position==1){
            deleteAtHead();
            return;
        }
        if(position==size){
            deleteAtTail();
            return;
        }else{
            Node prevNode = head;
            for(int i=1;i<position-1;i++){
                prevNode=prevNode.next;
            }
            Node currNode = prevNode.next;

            prevNode.next=currNode.next;

            currNode.next=null; // currNode is isolated now , jaise function return karega , currNode local variable will be destroyed and garbage collector will take care of it as it is unreachable node right ?
            size--;
        }
    }
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getHead(){
        if(head==null){
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    public int getTail(){
        if(tail==null){
            throw new IllegalStateException(
                "CircularSinglyLinkedList is empty. No tail element exists."
            );
        }
        return tail.data;
    }




    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        list.insertAtHead(20);
        list.insertAtHead(10);
        list.insertAtTail(40);
        list.insertAtPosition(30,3);

        list.printList();

        System.out.println("Search 30: " + list.search(30));
        System.out.println("Search 50: " + list.search(50));

        list.deleteAtHead();
        list.printList();
        list.deleteAtTail();
        list.printList();

        list.deleteAtPosition(2);
        list.printList();


        System.out.println("Size of linked list = "+list.getSize());
        System.out.println("Head of linked list = "+list.getHead());
        System.out.println("Tail of linked list = "+list.getTail());
        System.out.println("Is linked list empty? = "+list.isEmpty());

        list.insertAtHead(100);
        list.printList();

        

    }
}
