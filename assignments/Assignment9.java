package assignments;

public class Assignment9 {
    public void driver() {
        Queue QueueObj = new Queue(5);
        QueueObj.Insert(10); 
        System.out.println("Total items: "+ QueueObj.Count_QueueItems()+" Front="+QueueObj.getFront() + " Rear="+QueueObj.getRear());
        QueueObj.Insert(20);
         System.out.println("Total items: "+ QueueObj.Count_QueueItems()+" Front="+QueueObj.getFront() + " Rear="+QueueObj.getRear());
        QueueObj.Insert(30);
         System.out.println("Total items: "+ QueueObj.Count_QueueItems()+" Front="+QueueObj.getFront() + " Rear="+QueueObj.getRear());
        QueueObj.Insert(40);
         System.out.println("Total items: "+ QueueObj.Count_QueueItems()+" Front="+QueueObj.getFront() + " Rear="+QueueObj.getRear());

        QueueObj.Insert(50);
        System.out.println("Total items: "+ QueueObj.Count_QueueItems()+" Front="+QueueObj.getFront() + " Rear="+QueueObj.getRear());
         
         QueueObj.Delete();
         System.out.println("\n(After deleting 1 item)Total items: "+ QueueObj.Count_QueueItems()+" Front="+QueueObj.getFront() + " Rear="+QueueObj.getRear());
         QueueObj.Insert(60);
         System.out.println("\n(Again adding 1 item)Total items: "+ QueueObj.Count_QueueItems()+" Front="+QueueObj.getFront() + " Rear="+QueueObj.getRear());



        System.out.println("\nTotal items: "+ QueueObj.Count_QueueItems());

        System.out.println("\nFront item: "+ QueueObj.View_FrontItem());
        System.out.println("Rear item: "+ QueueObj.View_RearItem()+"\n");

        QueueObj.Insert(70);
    }
}

class Queue {
    private int front;
    private int rear;
    private int[] ptr;

    public Queue(int size) {

        front = -1;   //it indicates that array is empty
        rear = -1;
        ptr = new int[size];

    }

    public void Insert(int data) {

        if(Is_Full()==true){
            System.out.println("Queue Overflow");     
        }
        else if (Is_Empty()==true) { 
            front++;
            rear++;
            ptr[rear] = data;
        }
        // else if(rear+1 == ptr.length-1){
        //     rear++; //because we are considering it as a circular array
        //     ptr[rear]=data; 
        //     rear=0; 
        // }

        else if(rear+1== ptr.length){
            rear=0; //because we are considering it as a circular array
            ptr[rear]=data;             
        }

        else{
            rear++;
            ptr[rear]=data;
        }

        // try {
        //     if(ptr.length-1 == rear){
        //         rear=0;
        //         ptr[rear]=data;
        //     }
        //     else {
        //         if (front == -1)
        //         front++;
        //     rear++;
        //     ptr[rear] = data;
            
        // }

        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Array is overflowed");
        // }

        

    }













    public void Delete() {

        if(Is_Empty()==true){
            System.out.println("Array is Empty");
        }
        else if(rear==front){ //i.e if array has only one element
            rear=-1;
            front=-1;
        }
        else if(front==ptr.length-1){
            front =0;  
        }
        else {
            front++;
        }


        // try {
        //     for (int i = front; i != rear; i++) {
        //         ptr[i] = ptr[i + 1];
        //     }
        //     // front--;

        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Array is Empty");
        // }
    }

    public int View_RearItem() {

        if (rear != -1)
            return ptr[rear];
        else {
            System.out.println("Array is empty");
            return -1;
        }
    }

    public int View_FrontItem() {

        if (front != -1)
            return ptr[front];
        else {
            System.out.println("Array is empty");
            return -1;
        }
    }

    public int Count_QueueItems() {

        if(rear>=front){
            return rear-(front)+1;

        }
        else {
            return (ptr.length-(front-rear))+1;
        }
        // else{
        //     return 1; //i.e if(front==rear)
        // }


        // if(Is_Empty() == true){
        // System.out.println("Array is empty");
        // return -1;
        // }
        // else if(front==rear){
        //     return 1;
        // }
        // else if(front==rear+1){
        //     return ptr.length-1;
        // }
        // else{
        //     return rear + 1;
        // }

        // if (rear > -1)
        //     return rear + 1;
        // else
        //     System.out.println("Array is empty");
        // return -1;

    }

    public boolean Is_Empty() {
        return front == -1; // or rear == -1;
    }

    public boolean Is_Full() {
        // System.out.println("Array is full");
        if (ptr.length == (rear + 1) && front == 0)
            return true;
        else if (rear == front - 1) // or (rear+1 == front)  
            return true;   //value of Rear has become more than Front because we are treating it as circular array
        else
            return false;

    }

    public boolean Is_underflown() {
        System.out.println("Array is not full yet");
        return ptr.length > (rear + 1);
    }

    public int getRear(){
       return rear;
    }
    public int getFront(){
        return front;
    }

}




