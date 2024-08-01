package assignments;
//Heap
public class Assignment15 {

    public void driver() {
       Heap HeapObj =new Heap(5);

       HeapObj.Insert(30);
       HeapObj.Insert(45);
       HeapObj.Insert(10);
       HeapObj.Insert(20);
       HeapObj.Insert(21);

       HeapObj.printHeap();
   
       HeapObj.Delete();  
       System.out.println("after deletion");   
       HeapObj.printHeap();

       HeapObj.Delete(); 
       System.out.println("after deletion");  
       HeapObj.printHeap();
       

    }
    
}

class Heap{

    private int lastindex;
    private int []ptr;
    private int Top;

    public Heap(int length){
     ptr=new int[length];
     lastindex=-1; //last filled index
    // Top=ptr[0];
     }

    public int getTop(){
        if(lastindex==-1)
        return ptr[0];
        else
        System.out.println("Top no found: Heap is empty");
        return 0;
    }

    public boolean isFull(){
        return ptr.length==lastindex+1;
    }

    public void Insert(int data){
        if (isFull()==true){
            int temp[];
             temp= new int[ptr.length*2];
            for(int i=0;i<=lastindex;i++){
                temp[i]=ptr[i];
                ptr=temp;
            }
        }
        int index,parIndex;  //logic for insertion 
        for(index=lastindex+1;index>0;index=parIndex){
            parIndex=(index-1)/2;
            if(ptr[parIndex]<data){
                
                ptr[index]=ptr[parIndex];

            }
            else{
            break;
            }         
        }
        ptr[index]=data;  //insertion complete
        lastindex++;

        // int index,Parindex;
        // for(index=lastindex+1;index>0;index=Parindex){
        //     Parindex=(index-1)/2;
        //     if(ptr[Parindex]<data){
        //         ptr[index]=ptr[Parindex];
                
        //     }
        //     else{
        //         break;
        //     }
        //     ptr[index]=data;
    //     //     lastindex++;         
    //     } 

     }



    public int Delete(){ //only root node can be deleted in heap
        int item,temp,index,leftIndex,rightIndex;
        if(lastindex!=-1){

             item=ptr[0];

             temp=ptr[lastindex];
             lastindex--;
               
             index=0;
             leftIndex=1;
             rightIndex=2;
             while (leftIndex<lastindex) {

                if (ptr[leftIndex]>ptr[rightIndex]){
                    if(ptr[leftIndex]>temp){
                    ptr[index]=ptr[leftIndex];
                    index=leftIndex;
                    }
                    else {
                        break;
                    }
                    
                }else{ // (ptr[leftIndex]<ptr[rightIndex] )
                    if(ptr[rightIndex]>temp){
                        ptr[index]=ptr[rightIndex];
                        index=rightIndex;
                    }else{
                        break;
                    }
                }
                leftIndex=2*leftIndex+1;
                rightIndex=2*rightIndex+2;
             }
              if(leftIndex==lastindex && ptr[leftIndex]>temp){// i.e when there is no right child 
                ptr[index]=ptr[leftIndex];
                index=leftIndex;
              }
              ptr[index]=temp;
              return item;
        }
        else{
        System.out.print("Deletion failed: Heap is empty");
        return 0;
        }
        
    }

    public void printHeap(){
        System.out.print("HeapArray: [ "); 
        for(int i=0;i<ptr.length;i++){
            System.out.print(ptr[i]+" ");
        }
        System.out.print("]\n");
    }
}




