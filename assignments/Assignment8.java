package assignments;
//Queue
public class Assignment8 {
    public void driver() {
        Stack2 Stack2obj = new Stack2();
        Stack2obj.push(10);
        Stack2obj.push(20);
        Stack2obj.push(30);
        Stack2obj.push(40);
        Stack2obj.push(50);

        Stack2obj.printStack();
        System.out.println("Peek: " + Stack2obj.peek());

        // int deletedItem =Stack2obj.pop();
        // // // Stackobj.printStack();
        // System.out.println("After pop (Deleted item): "+deletedItem);

        Stack2obj=Stack2obj.ReverseStack(Stack2obj);
        // Stack2obj.push(10);
        // Stack2obj.printStack();
        Stack2obj.printStack();
        System.out.println("Peek: " + Stack2obj.peek());


        // Stack2obj=Stack2.ReverseStack_ByStatic(Stack2obj);  //here after reversing we return the values to the Stack2obj (using return i.e from RevStack_ByStatic function)

        // Stack2obj.printStack();
        // System.out.println("Peek: " + Stack2obj.peek());


    }
}




class Stack2 {
    Node top;

    class Node {
        private int Item;
        private Node Next;
    }

    public void push(int data) { // InserAtFirst
        Node n = new Node();
        n.Item = data;
        if (top != null) {
            n.Next = top;
            top = n;
        } else if (top == null) {
            n.Next = null;
            top = n;

        }
    }

    public int peek() {
        if (top != null)
            return top.Item;
        else
            System.out.println("Peak failed: LinkedList is Empty");
        return 0;
    }

    public int pop() { // DeleteFirst
        int x = top.Item;
        if (top != null) {
            top = top.Next;
            return x;
        } else {
            System.out.println("Pop failed: LinkedList is Empty(Stack underflow)");
            return 0;
        }
    }

    public void printStack() {
        Node n;
        n = top;
        System.out.println("\nLinkedList: ");
        System.out.print("[ ");
        while (n != null) {
            System.out.print(n.Item + " ");
            n = n.Next;
        }
        System.out.print(" ]");
        System.out.print("\n");
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Stack2 ReverseStack(Stack2 s) {

        Stack2 temp = new Stack2();
        while (!s.isEmpty()) {
            temp.push(s.pop());

        }
        return temp;   // this=temp;  <-- will give error


        // Stack2 temp2 = new Stack2();   //or
        // while (!temp.isEmpty()) {
        //     temp2.push(temp.pop());
        // }

        // while (!temp2.isEmpty()) {
        //     push(temp2.pop());
            
        // }

        
        // if(top!=null && top.Next!=null){
        // Node t;
        // t=top;
        // while(t!=null){
        // t=t.Next;
        // }
        // top=t;
        // }
    }

    public static Stack2 ReverseStack_ByStatic(Stack2 s) {
       Stack2 temp=new Stack2();
       while(!s.isEmpty()){
        temp.push(s.pop());
       };
    //    s=temp;  it will not work (because s is local var)

       return temp;

    }

}
