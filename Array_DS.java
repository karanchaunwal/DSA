public class Array_DS {
    
    public static void main(String args[]){        
                

    }
    Array ptr=new Array(5); //reference of obj of Array class is in ptr(which is a ref. var.)
    
    }
    
class Array{

        private int arrSize;
        private int lastIndex; //holds index of last filled block
        private int ptr[] ;

        public Array(int arrSize)     //Constructor of Array class
        {
            lastIndex=-1; //just for declaring an int local variable
            ptr=new int[arrSize];
        }

        public void append(int data)
        {
            try{
                
                ptr[lastIndex+1]=data;   //adding elements in array from right
                lastIndex++;
            }catch(ArrayIndexOutOfBoundsException e){
               System.out.println("Array is overflowed and cannot add more values");
            }
        }
        
        public void insert(int index,int data){
            try{
                if(index<0 || index>(lastIndex+1)){
                    throw new ArrayIndexOutOfBoundsException("Cannot insert value to an invalid index ");
                }
                else{
                    for(int i=index;i<=(lastIndex);i++){        //shifting values in indexes to right
                        ptr[i+1]=ptr[i];
                    }
                    ptr[index]=data;     //inserting new data in array 
                    lastIndex++;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }

        } 

        public void edit(int index,int newData){
            try{
                if(index<0 || index>lastIndex){
                    throw new ArrayIndexOutOfBoundsException("Cannot access an invalid index");

                }else{
                    ptr[index]=newData;     //editing value at an index
                    lastIndex++;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }



        public void delete(int index){
            try{
                if(index<0 || index>lastIndex){
                    throw new ArrayIndexOutOfBoundsException("Cannot access an invalid index");

                }else{    
                    if(index==lastIndex){
                        ptr[index]=0;
                    }
                    else{
                    for(int i=index;i<(lastIndex);i++){
                        ptr[i]=ptr[i+1];  //deleting value at an index
                      }                                      
                    lastIndex--;
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }

        public int count(){
            int totalElements;
            totalElements=lastIndex+1;
            return totalElements;
        }

        public boolean isEmpty(){
            if(lastIndex<-1)
            return true;
            else 
            return false;
        }

        public boolean isFull(){
            if(ptr.length==lastIndex+1)
            return true;
            else
            return false;
        }

        public int getValue(int index){
            try{
            if(index<0 || index>lastIndex)
            throw new ArrayIndexOutOfBoundsException("Invalid index");
            
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
            return ptr[index];
          
        }

        public int getCapacity(){
            
            return ptr.length;
        }



    }
