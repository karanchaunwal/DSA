package assignments;
//Singly Linked List
public class Assignment3 {

   public void driver() {

      SLL SLLObj = new SLL();
      System.out.println("Is list empty: "+SLLObj.isEmpty()+"\n");

      SLLObj.InsertAtFirst(10);      
      SLLObj.InsertAtLast(30);
      SLLObj.InsertAtLast(40);
      SLLObj.Search(10);
      SLLObj.InsertAfter(20, SLLObj.Search(10));

      
      System.out.println("Below are the SLL items:");
      SLLObj.PrintSLL();

      SLLObj.DeleteNodeWith(30);
      System.out.println("\nBelow are the SLL items after deletion:");
      SLLObj.PrintSLL();

      System.out.println("\nIs list empty: "+SLLObj.isEmpty());

   }

}



class SLL {

   private Node start;

   class Node {   // inner class

      private int item;
      private Node next;

      void setItem(int item){
         this.item=item;

      }

      int getItem(){
         return item;
      }


      void setNext(Node next){
         this.next=next;
      }

      Node getNext(){
         return next;
      }

   }

   //1st func
   boolean isEmpty(){
      if(start==null)  //or return start==null;
      return true; 
      else 
      return false;
   }


    // 2st func
   void InsertAtFirst(int data){
      Node n=new Node();
      n.setItem(data); //n.item=data;
      n.setNext(start);

      start=n;      //or SLL Sllobj=new SLL();
                    //   Sllobj.start=n;
   }

   
   //3nd func
   void InsertAtLast(int data){

      Node n=new Node();
      n.setItem(data);
      n.setNext(null);

      if (start==null)   //i.e is node is empty already, then simply add new node n to start
      start=n;

      else{
      Node temp;
      temp=start;
      while(temp.getNext()!=null){  //traversing till last node
           temp=temp.getNext();
      }
      temp.setNext(n);
      }
   }


      //4rd func
      Node Search(int data){
         Node temp;
         temp=start;
         while(temp!=null){   //traversing till end of last node
            if(temp.getItem()==data)
            return temp;
            
            temp=temp.getNext();
            
         }
         
         System.out.println("Search failed, No such item found");
         return null; //i.e search failed, No such item found
           
      }


      //5th func
      void InsertAfter(int data, Node x){
         if(x!=null){
            Node n = new Node();
            n.setItem(data);

            n.setNext(x.getNext());
            x.setNext(n);
                  }

         }
      


      //6th func
      void DeleteFirst(){
         if(start==null){
            System.out.println("Cannot delete node from an empty linked list");
         }
         else{
            start=start.getNext();

         }

      }


       //7th func
      void DeleteLast(){
         if(start==null){
            System.out.println("Cannot delete node from an empty linked list");
         }
         else if(start.getNext()==null){
            start=null;  //or DeleteFirst();
         }
         else{
         Node temp;
         temp=start;
         while(temp.getNext().getNext()!=null){
            temp=temp.getNext();
         }
         temp.setNext(null);
      }
      }



      //8th func
      // void DeleteNodeWith(int item){
      //    Node temp=Search(item);
      //    if(temp==null)
      //    System.out.println("Cannot delete,No Node with such item was found");
      //    else {
      //       if(temp==start){  //or if( temp.getNext()==start.getNext() )
      //        DeleteFirst();
      //         }
      //       else{
      //       Node temp2=new Node();
      //       temp2=start;
      //       while(temp2.getNext()==temp){
      //          temp2=temp2.getNext();
      //       }
      //       temp2.setNext(temp.getNext());
      //       }
      //    }
      // }

      void DeleteNodeWith(int item){
         Node temp=Search(item);
         if(temp==null)
         System.out.println("Cannot delete,No Node with such item was found");

         else {
            if(temp==start){  //or if( temp.getNext()==start.getNext() )
             DeleteFirst();
             System.out.println("\n1st node got deleted");
              }
            else{
               System.out.println("\nenters in else");
            Node temp2;
            temp2=start;
            while(temp2.getNext()!=temp){
               System.out.println("\nenters in while");
               temp2=temp2.getNext(); 
            }
            System.out.println("\nexits while");
            temp2.setNext(temp.getNext()); // <--deleion is happening here
            
            }
            System.out.println("\nexits else");
         }

      }

      //9th func
      void PrintSLL(){
         Node temp=start;
         while(temp!=null){
            System.out.println(temp.getItem());
            temp=temp.getNext();
         }
      }








      // Node n=new Node();
      // n.setItem(data);
      // n.setNext(null);

      // Node temp;
      // temp=start;

      // if(temp==null){
      //    start=n;
      // }
      // else
      // while(temp.getNext()!=null){
      //    temp=temp.getNext();

      // }
      // temp.setNext(n);

   



/*

   private Node Start; // by default it is null

   public class Node {

      private int item;
      private Node next;

      void setItem(int item) {
         this.item = item;

      }

      int getItem() {
         return item;

      }

      void setNext(Node next) {
         this.next = next;

      }

      Node getNext() {
         return next;

      }

   }

   boolean isEmpty() {

      if (Start == null)
         return true;
      else
         return false;

   }

   void InsertAtStart(int data) { // to insert new node at starting
      Node n = new Node();

      n.setItem(data);
      n.setNext(Start); 
      Start=n;

   }

   
     void InsertAtLast(int data){
      Node n = new Node();
      n.setItem(data);
      n.setNext(null);

      if(Start==null){
         Start=n;
      }
      else{
      Node tr;
      tr=Start;
      while(tr.getNext()!=null){  //traversing using while loop
         tr=tr.getNext();
      }
      tr.setNext(n);
      }

     }
     

     Node SearchFor(int data){
     
         Node tr;
         tr=Start;
         while(tr!=null){
            if(tr.getItem()==data){
               return tr;
            }
           else  tr=tr.getNext();
         }
         System.out.println("No such item present in the Linked list");
         return null;  //i.e search failed (as no such data found)

          }

    
     void InsertAfter(Node n, int data){   
               Node newNode =new Node();
               newNode.setItem(data);
               newNode.setNext(n.getNext());

               n.setNext(newNode);

           
     }

      void DeleteFirst(){
         try{if(Start==null)
            throw new ArithmeticException("Cannot delete node from an empty Linked-List");
            
            else Start=Start.next;
         }
         catch(ArithmeticException E){
            System.out.println(E.getMessage());
         }

      }


      void DeleteLast(){

         try{
            if(Start==null)
            throw new ArithmeticException("Cannot delete node from an empty Linked-List");
            
            else if (Start.getNext()==null){
               Start=null;
            }
            else {
            Node tr;
            tr=Start;
            while (tr.getNext().getNext()!=null){         
            tr=tr.getNext();               
           }
           tr.setNext(null);
            }
         }
         catch(ArithmeticException E){
            System.out.println(E.getMessage());
         }


         
        }

      
        void DeleteANode(int data){
         Node t=SearchFor(data);
         if(t==null){
            System.out.println("Nosuch item fould");
         }
         else{
            if(t==Start){
               DeleteFirst();
            }
            else{
               Node temp=Start;
               while(temp.getNext()!=t){
               temp=temp.getNext();
               temp.getNext();
               }
               temp.setNext(t.getNext());
              //or  temp.next=t.getNext();
               
               
            }
            
         }
        }

        */
}