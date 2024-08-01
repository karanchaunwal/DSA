package assignments;
//Stack
public class Assignment7 {

    public void driver(){
        Stack StackObj= new Stack(4);
         StackObj.push(10);
         StackObj.push(20);
        // StackObj.push(30);
         
        System.out.println("\npeek(i.e last item): "+StackObj.peek()+" and its index(i.e last index): "+StackObj.top);
        int deletedItem=StackObj.pop();
        System.out.println("After pop (Deleted item): "+deletedItem);
        System.out.println("peek(i.e new last item): "+StackObj.peek()+" and its index(i.e last index): "+StackObj.top);
     //  StackObj.pop();
        

    }
    
}

class Stack{

    public int top; //to contain index no. of top(last index)
    private int []ptr;
    
    public Stack(int size){  //constructor
       ptr= new int[size];
       top= -1;
    }

    public void push(int data){
        try{
            ptr[top+1]=data;
            top++;

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Push failed: Stack has overflown");
        }

    }

    public int peek(){
        int x=0;  //because it is compulsory to innitialize a local variable
       try{ 
         x=ptr[top];
       }catch(Exception e){
        System.out.println("Peek failed: Stack underflow (Stack is Empty)");
       //  or return 0;
       }
       return x;
    }

    public int pop(){
       // int x=0;
        try{
            int x=ptr[top];
            top--;
            return x;
            
        }catch(Exception e){
            System.out.println("Pop failed: Stack underflow (Stack is Empty)");
            return 0;
        }
      //  return x;
    }

    public boolean ISfull(){
        return (ptr[top]==ptr.length-1);
    }

    public boolean IsEmpty(){
        return (top==-1);
    }

}
