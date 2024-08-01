package assignments;
//Circular Doubly Linked List
public class Assignment6 {

    public void driver(){

        CDLL CDLLObj =new CDLL();

        CDLLObj.InsertAtFirst(10);
        CDLLObj.InsertAtFirst(0);
         CDLLObj.InsertAtLast(20);
         CDLLObj.InsertAtLast(30);
    
       CDLLObj.InsertAfter(CDLLObj.SearchFor(30), 40);

    //    CDLLObj.InsertAtFirst(-10);

    //    CDLLObj.DeleteANodeWith(40);
      //  CDLLObj.InsertAtLast(30);
      //  CDLLObj.InsertAtLast(30);
    //   CDLLObj.DeleteANodeWith(40);
    //   CDLLObj.DeleteFirst();
    //   CDLLObj.DeleteFirst();

      System.out.print("Empty: "+CDLLObj.IsEmpty()+"\n");

      CDLLObj.Print_DCLL();

    }
}

class CDLL{
    
    private Node Start;

    class Node{

        Node Prev;
        Node Next;
        int Item;
        
        public Node getPrev() {
            return Prev;
        }
        public void setPrev(Node prev) {
            Prev = prev;
        }
        public Node getNext() {
            return Next;
        }
        public void setNext(Node next) {
            Next = next;
        }
        public int getItem() {
            return Item;
        }
        public void setItem(int item) {
            Item = item;
        }

    }

      public boolean IsEmpty(){
       
        return Start==null;
    }

    void InsertAtFirst(int data){


        Node n = new Node();
        n.setItem(data);

        if(Start!=null){
        n.setPrev(Start.getPrev());
        n.setNext(Start);
        Start.getPrev().setNext(n);
        Start.setPrev(n);
        Start=n;

        }else{
            Start=n;
            Start.setNext(n);
            Start.setPrev(n);
        }
    }


    void InsertAtLast(int data){
        Node n = new Node();
        n.setItem(data);

        if(Start!=null){
            n.setPrev(Start.getPrev());
            n.setNext(Start);
            Start.getPrev().setNext(n);
            Start.setPrev(n);

        }else{
            Start=n;
            Start.setNext(n);
            Start.setPrev(n);
        }
    }


    Node SearchFor(int data){     
        Node t;   
        t=Start;
        
        if(Start!=null){
        do{
           if (t.getItem()==data)    // if (t.getItem()!=data)
           return t;

           t=t.getNext();
        }while(t.getNext()!=Start.getNext()); //or simply while(t!=Start)
    }
    System.out.print("Search failed: No Node with such item found");
    return null;
            
    }



    void InsertAfter(Node N, int data){
        if (N!=null ){
            Node n=new Node();
            n.setItem(data);

            n.setPrev(N);
            n.setNext(N.getNext());
            N.getNext().setPrev(n);
            N.setNext(n);

            if(N.getNext()==Start){
                Start=n;
            }
    
        }else{
            System.out.println("Insersion Failed");
        }
    }

    void DeleteFirst(){

        if(Start!=null && Start.getNext()!=Start){
            Start.getPrev().setNext(Start.getNext());
            Start.getNext().setPrev(Start.getPrev());
            Start=Start.getNext();
        }else if(Start!=null && Start.getNext()==Start){
            Start=null;
        }else{
             System.out.println("Deletion Failed");
        }

    }

    void DeleteLast(){
        if(Start!=null ){
            if(Start.getNext()==Start){
            Start=null;
            }
            else{
                Start.setPrev(Start.getPrev().getPrev());
                Start.getPrev().getPrev().setNext(Start);
            }
        
        }else{
             System.out.println("Deletion Failed");
        }
    }

    void DeleteANodeWith(int data){
        Node N=SearchFor(data);
        if (N!=null) {
            if(N==Start){
                DeleteFirst();
            }else{
                N.getPrev().setNext(N.getNext());
                N.getNext().setPrev(N.getPrev());
            }       
        }else{
             System.out.println("Deletion Failed");
        }
    }

    
    void Print_DCLL(){

        System.out.println("\nThis is the CLL:");

        Node t=new Node();  
        t=Start;

        System.out.print("[");

        do{
            System.out.print(" "+t.getItem()+" ");  
            t=t.getNext();

        }while(t!=Start);

        System.out.print("]");

        // System.out.println("\n\n"+Start.getPrev().getNext().getItem());
        // System.out.println(Start.getPrev().getItem());

    }


    
}

