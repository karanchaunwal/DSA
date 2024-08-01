package assignments;
//Doubly Linked List
public class Assignment4 {

    public void driver(){

        DLL DLLObj=new DLL();
        DLLObj.InsertAtFirst(10);
        DLLObj.InsertAtFirst(0);
        DLLObj.InsertAfter(DLLObj.SearchNodeWith(10), 20);
        DLLObj.InsertAtLast(30);

        DLLObj.deleteFirst();

        DLLObj.deleteNodeWith(0);

        DLLObj.printList();


    }
        
}
 
class DLL{

        Node Start;

        class Node {
            int Item;
            Node Next;
            Node Prev;

            public int getItem(){
                return Item;
            }
            public void setItem(int data){
                Item=data;               //or this.data=data
            }

            public Node getNext(){
                return Next;
            }
            public void setNext(Node next){
                Next=next;
            }

            public Node getPrev(){
                return Prev;
            }
            public void setPrev(Node prev){
                Prev=prev;
            }
        }

        boolean IsEmpty(){
            if (Start==null)     //or return (Start==null)
            return true;
            else
            return false;
        }

        void InsertAtFirst(int data){
            Node n=new Node();
            n.Item=data; // or n.setItem(data);
            n.setNext(Start);
            n.setPrev(null);

            if(Start!=null){        
            Start.setPrev(n);
            }
       /*or

       try {
            Start.setPrev(n);

            }catch (Exception e){  
        }
               */
            Start=n;
            
        }

        void InsertAtLast(int data){

            Node n=new Node(); 
            n.Item=data;
            n.setNext(null);

            if(Start==null){
                Start=n;
                n.setPrev(null);
            }

            else{
            Node temp=new Node();
            temp=Start;
            while (temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(n);
            n.setPrev(temp);

            // Node temp2=new Node();
            // temp2=Start;
            // while(temp2.getNext().getNext()!=null){
            //     temp2=temp2.getNext();
            // }
            // n.setPrev(temp2);
          }

        }

        Node SearchNodeWith(int data){

            Node temp=new Node();
            temp=Start;
            while(temp!=null){
               if(temp.getItem()==data)
               return temp;

                temp=temp.getNext();
            }
            System.out.println("Search failed : No such item exsits");
            return null;
        }



        void InsertAfter(Node x,int data){
            if(x!=null){

            Node n=new Node(); 
            n.Item=data;

            // Node temp=new Node();  //no need to find x (because x will be given, or can be searched by the above function)
            // temp=Start;
            // while(temp!=x){
            //     temp=temp.getNext();
            // }

            n.setNext(x.getNext());
            n.setPrev(x);

            if(x.getNext()!=null){
                (x.getNext()).setPrev(n);
            }
            x.setNext(n);

            }

        }
        void deleteFirst(){

            if(Start!=null){
                if (Start.getNext()==null){
                    Start=null;
                }
                else{
                Start=Start.getNext();
                Start.setPrev(null);
                
                }                           
            }
            else{
                System.out.println("Deletion failed: List is empty");
            }
        }


        void deleteLast(){
            if(Start!=null){
                if (Start.getNext()==null){
                    Start=null;
                }
                else{
                    Node temp;
                    temp=Start;
                    while(temp.getNext().getNext()!=null){
                        temp=temp.getNext();
                    }
                    temp.setNext(null);
                }
            }
            else{
                System.out.println("Deletion failed: List is empty");
            }
        }


        void deleteNodeWith(int data){

            Node x = SearchNodeWith(data);

            if (x!=null){

            
            if(x.getNext()==null){
                deleteLast();

            }else if(x.getPrev()==null){
                deleteFirst();

            }else{
                Node temp= new Node();
                
                temp=x.getPrev();
                temp.setNext(x.getNext());
                x.getNext().setPrev(temp);

      //or by doing traversing     
                // temp=Start;
                // while(temp.getNext()!=x){
                // temp=temp.getNext();
                // }
                // temp.setNext(x.getNext());
                // x.getNext().setPrev(temp);
            }
        }
        else{
            System.out.println("Deletion failed: No node exists with such item");
        }

        }


        
        public void printList(){
            System.out.print("\nItems in DLL are: ");
            Node t;
            t=Start;
            while(t!=null){
                System.out.print(t.getItem()+" ");
                t=t.getNext();
            }
        }



    }
