package assignments;
//Dynamic Array
public class Assignment2 {

    public void driver() {

        DynamicArray DyArrayObj = new DynamicArray();

        DyArrayObj.Append(11);
        System.out.println("Capacity = "+DyArrayObj.GetCapacity());
        DyArrayObj.Append(22);
        System.out.println("Capacity = "+DyArrayObj.GetCapacity());
        DyArrayObj.Append(33);
        System.out.println("Capacity = "+DyArrayObj.GetCapacity());
        DyArrayObj.Append(44);
        System.out.println("Capacity = "+DyArrayObj.GetCapacity());
        DyArrayObj.Append(55);
        System.out.println("Capacity = "+DyArrayObj.GetCapacity());
        DyArrayObj.Append(66);
        System.out.println("Capacity = "+DyArrayObj.GetCapacity()+"\n");


        for(int i=0;i<DyArrayObj.Count();i++){
            System.out.println("Ptr["+i+"] = "+DyArrayObj.ValueAt(i));       
        }
        System.out.println("\n(After Appending 6 elements) Capacity = "+DyArrayObj.GetCapacity()+"\n");
        System.out.println("Value at [7] = "+DyArrayObj.ValueAt(7)+"\n");

        DyArrayObj.Delete(1);
        DyArrayObj.Delete(3);
        DyArrayObj.Delete(0);
        DyArrayObj.Delete(0);
        DyArrayObj.Delete(1);
        DyArrayObj.Delete(0);// before executing this step only one elemnet should have left(i.e at index[0]), so deleting index[0]

        for(int i=0;i<DyArrayObj.Count();i++){
            System.out.println("Ptr["+i+"] = "+DyArrayObj.ValueAt(i));       
        }

        System.out.println("(After Deleting all 6 elements) Capacity = "+DyArrayObj.GetCapacity()+"\n");

        System.out.println("Last filled index = "+DyArrayObj.LastFilledIndex());
        System.out.println("Ptr[0] = "+DyArrayObj.ValueAt(0));



    }
}

class DynamicArray {

/*

    // private int ArrSize;
    private int lastIndex; // holds index of "last filled block"
    private int ptr[];

    // public DynamicArray(int arrSize) // Constructor of DynamicArray class
    // {
    // lastIndex = -1; // just for declaring an int local variable
    // ptr = new int[arrSize];
    // }

    public void append(int data) {
        try {

            if (isFull() == true) {
                DoubleArray();
            }

            ptr[lastIndex + 1] = data; // adding elements in array from right
            lastIndex++;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is overflowed and cannot add more values");
        }
    }

    public void insertAt(int index, int data) {
        try {
            if (index < 0 || index > (lastIndex + 1)) {
                throw new ArrayIndexOutOfBoundsException("error: Cannot insert value to an invalid index ");
            } else {
                for (int i = lastIndex; i >= index; i--) { // shifting values in indexes to right
                    ptr[i + 1] = ptr[i];
                }
            }
            ptr[index] = data; // inserting new data in array
            lastIndex++;

            if (isFull() == true) {
                DoubleArray();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public void edit(int index, int newData) {
        try {
            if (index < 0 || index > lastIndex) {
                throw new ArrayIndexOutOfBoundsException("Cannot access an invalid index");

            } else {
                ptr[index] = newData; // editing value at an index
                // lastIndex++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int index) {
        try {
            if (index < 0 || index > lastIndex) {
                throw new ArrayIndexOutOfBoundsException("Cannot access an invalid index");

            } else {
                // if (index == lastIndex) {
                // ptr[index] = 0;
                // }else {
                System.out.println("Before deletion: ptr[" + index + "]=" + ptr[index]);
                for (int i = index; i < (lastIndex); i++) {
                    ptr[i] = ptr[i + 1]; // deleting value at an index

                }
                lastIndex--;
                System.out.println("proof that value at desired index i.e [" + index + "] got deleted: ptr[" + index
                        + "]=" + ptr[index]);
                // }
                if (lastIndex <= (ptr.length) / 2) {
                    HalfArray();

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public int count() {
        int totalElements;
        totalElements = lastIndex + 1;
        return totalElements;
    }

    public boolean isEmpty() {
        if (lastIndex <= 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (ptr.length == lastIndex + 1)
            return true;
        else
            return false;
    }

    public int getValue(int index) {
        try {
            if (index < 0 || index > lastIndex)
                throw new ArrayIndexOutOfBoundsException("Invalid index");
            return ptr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }

    public int getCapacity() {

        return ptr.length;
    }

    public int lastFilledIndex() {
        return lastIndex;
    }

    void DoubleArray() {
        int[] temp = new int[2 * (ptr.length)];
        // DynamicArray NewArray = new DynamicArray(2*(ptr.length));

    }

    void HalfArray() {

    }

*/


    private int LastIndex;
    private int[] Ptr;


    public DynamicArray() {  // This Non-parameterized Constructor will run if - an obj(without passing parameter) is created 
        LastIndex = -1;

        Ptr = new int[1];

    }

    public DynamicArray(int arrSize) {
        LastIndex = -1;

        Ptr = new int[arrSize];

    }

    void doubleArray() {
        int[] temp = new int[ 2 * (Ptr.length)];

        for (int i = 0; i <= LastIndex; i++) {
            temp[i] = Ptr[i];
        }
        Ptr = temp;
    }

    void halfArray() {
        int[] temp = new int[(Ptr.length) / 2];
        for (int i = 0; i <= LastIndex; i++) {
            temp[i] = Ptr[i];
        }
        Ptr = temp;

    }

    void Append(int data) {
        if (ISfull()) {
            doubleArray();
        }
        Ptr[LastIndex + 1] = data;
        LastIndex++;
    }

    void InsertAt(int index, int data) {
        try {
            if (index < 0 || index >(LastIndex+1))
                throw new ArrayIndexOutOfBoundsException("error: Cannot insert value to an invalid indexi ");
            else{
                if (ISfull()) {
                    doubleArray();
                }
                for(int i=LastIndex;i>=index;i--){
                    Ptr[i+1]=Ptr[i];
                }
                Ptr[index]=data;
                LastIndex++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }


    void Edit(int index, int Newdata){
        try{
            if (index<0 || index >LastIndex){
                throw new ArrayIndexOutOfBoundsException("error: Cannot insert value to an invalid indexe ");
            }
            else{
                Ptr[index]=Newdata;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }


 

    void Delete(int index){
        try{
        if (index<0 || index>LastIndex)
        throw new ArrayIndexOutOfBoundsException("Cannot delete element from an invalid indexd");

        else{
            
        for(int i=index;i<LastIndex;i++){
        Ptr[i]=Ptr[i+1];
        }
        LastIndex--;

        if((LastIndex+1) == (Ptr.length/2) && (Ptr.length>1)){ //"&& (LastIndex>0)" <-- This logic is different from MySirG
            halfArray();
        }
    }
    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println(e.getMessage());
    }
        
    }


    int Count(){
        return LastIndex+1;

    }


    boolean ISfull() {
        if (LastIndex + 1 == Ptr.length)
            return true;
        else
            return false;

    }


    boolean ISempty() {
        if (LastIndex < 0)
            return true;
        else
            return false;
    }



    int ValueAt(int index){
        try{
            if (index<0 || index>LastIndex){
                throw new ArrayIndexOutOfBoundsException("Cannot access an invalid indexv");
            }
            else 
            return Ptr[index];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return 0;
    
    }


    int GetCapacity(){
        return Ptr.length;
    }



    int SpaceLeft(){
        return Ptr.length-(LastIndex+1);
    }


    int LastFilledIndex(){
        return LastIndex;
    }

}
