package assignments;
//Circular Linked List
public class Assignment5 {
    
   void  driver(){

    CLL CLLObj=new CLL();

    CLLObj.InsertAtFirst(0);
    CLLObj.InsertAtLast(20);
    CLLObj.InsertAfter(CLLObj.SearchFor(0), 10);
    CLLObj.InsertAtLast(30);
   // CLLObj.DeleteLast();
   CLLObj.DeleteANodeWith(20);
   CLLObj.InsertAtFirst(-10);
   CLLObj.DeleteANodeWith(-10);

   CLLObj.InsertAfter(CLLObj.SearchFor(10), 20);
  

    CLLObj.Print_CLL_1();
   

    }
}


class CLL{

   private  Node Last;
    
   public class Node{
    
        private int Item;
        private Node Next;

        public void setItem(int item){
            Item=item;
        }
        public int getItem(){
            return Item;
        }
        public Node getNext() {
            return Next;
        }
        public void setNext(Node next) {
            Next = next;
        }
    }

    boolean IsEmpty(){
        return Last==null;
    }

    void InsertAtFirst(int data){

        Node n =new Node();
        n.setItem(data);
        if(Last!=null){
      //n.setNext(Last.getNext().getNext());    wrong
        n.setNext(Last.getNext());    
        Last.setNext(n);
        }else{
            Last=n;
            n.setNext(n);
        }
    }

    void InsertAtLast(int data){
         Node n = new Node();
        n.setItem(data);
        if(Last!=null){     
        // Last.getNext().setNext(n);    wrong
        // n.setNext(Last.getNext());

        n.setNext(Last.getNext());
        Last.setNext(n);
        Last=n;
        }else{
            Last=n;
            n.setNext(n);

        }      
    }


    Node SearchFor(int data){
        
        Node t=new Node();
        t=Last.getNext(); //so here t is pointing to first node 

        if(Last!=null){
            System.out.println("entered if block");
        do{
                System.out.println("entered do while loop");  
            if(t.getItem()==data)
            return t;
            
            System.out.println("entered 2 do while loop");
            t=t.getNext();

        }while(t!=Last.getNext());
        return null;

    }else {  
    System.out.println("Search failed: No Node with such item found");
    return null;
    }

    }


    void InsertAfter(Node N,int data){

        System.out.println(N.getItem());
      //System.out.println(N.getNext());
        Node n = new Node();
        n.setItem(data);
         System.out.println(N.getItem());
     //   N=SearchFor(data);
     // System.out.println(N.getItem());     //NullPointerException
        if(N!=null && N!=Last){
        n.setNext(N.getNext());
        N.setNext(n);
         
        }else if(N!=null && N==Last){
            n.setNext(N.getNext());      
            N.setNext(n);
            Last=n;        
        }else{
            System.out.println("Insersion Failed");
        }
    }


    void DeleteFirst(){
        if(Last!=null){
            if(Last.getNext()==Last){
            Last=null;
            }else{
            Last.setNext(Last.getNext().getNext());
            }
        }else{
            System.out.println("Deletion Failed: No node found to be deleted");
        }
    }

    void DeleteLast(){
        if(Last!=null){
            if(Last.getNext()==Last){
            Last=null;
            }else{
                Node t;
                t=Last.getNext();
                while(t.getNext()!=Last){
                    t=t.getNext();
                }
                t.setNext(Last.getNext());
                Last=t;
            }
        }else{
            System.out.println("Deletion Failed: No node found to be deleted");
        }
    }

    void DeleteANodeWith(int data){
        Node N=SearchFor(data); 
        if(N!=null && N!=Last){
            Node t;
            t=Last.getNext();
            while(t.getNext()!=N){
                t=t.getNext();
            }
            t.setNext(N.getNext());

        }else if(N!=null && N==Last){
            if(Last.getNext()==Last){ //Case If there is only one node 
                Last=null;           
            }
            // Node t;         
            // t=Last.getNext();
            // while(t.getNext()!=N){
            //     t=t.getNext();
            // }
            // t.setNext(N.getNext());
            // Last=t;

            //or simply
            DeleteLast();
        }
        else{
            System.out.println("Deletion Failed: No node with such item got found to be deleted");
        }

    }

    // void Print_CLL_2(){
    //     System.out.println("\nBelow is the CLL:"); 

    //     Node t=new Node();
    //     t=Last;  //i.e fronm last node
    //     do{
    //         System.out.print(t.getItem()+" ");
    //         t=t.getNext();

    //     }while(t.getNext()!=Last);

    // }




        void Print_CLL_1(){
        System.out.println("\nBelow is the CLL:");

        Node t;
        t=Last.getNext();   //i.e from first node
        do{
            System.out.print(t.getItem()+" ");
            t=t.getNext();

        }while(t!=Last.getNext());

    }

}


