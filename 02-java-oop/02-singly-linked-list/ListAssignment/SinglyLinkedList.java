
public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
     
        public Integer remove(){
            Node runner = head;
            int valReturn;

            if(head == null){
                System.out.println("List is empty"); 
                return null;

            }else{
                //runner becomes last node before null
                while(runner.next.next != null){
                runner = runner.next;
           }
           runner.next = null;
            } 
            return runner.next.value;  
        }
         
     public void printValues(){
        Node n = head; 
        while (n != null) { 
                System.out.print(n.value + " "); 
                n = n.next; 
            } 
        } 

        //Implement a find(int) method that will return the first node with the value in the parameter


        //Implement a removeAt(int) method that will remove the node after n nodes, where n is the parameter.
}