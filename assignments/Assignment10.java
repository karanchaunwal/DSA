package assignments;

public class Assignment10 {
    public void driver(){
        Queue_SLL Qobj=new Queue_SLL();
        Qobj.insert(10);
        Qobj.insert(20);
        Qobj.insert(30);
        Qobj.insert(40);
        Qobj.insert(50);
        

        System.out.println("\nTotal elements = "+Qobj.countItems());
        System.out.println("Oldest item: "+Qobj.getFrontItem()+" Latest item: "+Qobj.getRearItem());

        Qobj.delete();
        System.out.println("\n(After deletion)Total elements = "+Qobj.countItems());
        System.out.println("Oldest item: "+Qobj.getFrontItem()+" Latest item: "+Qobj.getRearItem());


    }

}

class Queue_SLL {

    Node front;
    Node rear;

    int count;

    public class Node {
        int item;
        Node next;
        int count=0;
      // Node prev;  

    }

    public Queue_SLL(){ //constructor
        front=null;
        rear=null;  // *although there is no need of constructor, because by default these values would be null aswell.
    }

    public void Count_QueusSLL(){
    // instead we have made a variable i.e int count
    }

    public void insert(int data){

         Node n =new Node();
         n.item=data;
         n.next=null;

         if(rear==null){
            rear=n;
            front=n;
         }
         else{
            rear.next=n;
            rear=n;
            // n.next=rear;
            // rear=n;        
         }
         count++;



    }

    public int GetRearItem(){
        if(rear!=null){
            return rear.item;
        }
        else 
        System.out.println("Queue_sll is empty");
        return -1;
    }

    public int GetFrontItem(){
        if(front!=null){
            return front.item;
        }
        else 
        System.out.println("Queue_sll is empty");
        return -1;
    }

    public void delete(){
        if(count==0){
            System.out.println("Queue_sll is empty");

        }else if(count==1){
            front=null;
            rear=null;
            count=0;
        }else{
            front=front.next;
            count--;
        }
    }

    public boolean isEmpty(){
        if(count==0)
        return true;
        else 
        return false;

    }

    public int countItems(){
        return count;
    }


    public int getFrontItem(){
        return front.item;
    }
     public int getRearItem(){
        return rear.item;
    }
}

