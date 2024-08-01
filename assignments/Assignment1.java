package assignments;
//Array
public class Assignment1 {

    public void driver() {
        System.out.println("program starts\n\n");
        Array ArrObj = new Array(11);
        System.out.println("And Size of array is: " + ArrObj.getCapacity());
        System.out.println("Initially last filled index of array is: " + ArrObj.lastFilledIndex()+"\n");

        ArrObj.append(11); // insert 11 in array
        ArrObj.append(22);


        ArrObj.insertAt(2, 33);
        ArrObj.insertAt(3, 44);
        ArrObj.insertAt(11, 99); //it will give error
        
        System.out.println("After insertions last filled index of array is: " + ArrObj.lastFilledIndex());
        System.out.println("So Total no of elements present before deletion is: " + ArrObj.count());
        for (int i = 0; i < ArrObj.count(); i++) {
            System.out.println("ptr[" + i + "] = " + ArrObj.getValue(i));
        }


        System.out.println("\nusing getValue() function we found Value at index[1]: "+ArrObj.getValue(1));

        System.out.println("\nNow deletion will happen");
        ArrObj.delete(0);
        ArrObj.delete(0);
        ArrObj.delete(0);
        ArrObj.delete(0);

        System.out.println("\nAfter deletion, the last filled index of array is: " + ArrObj.lastFilledIndex());
        System.out.println("\nSo Total no of elements present after deletion is: " + ArrObj.count());

        System.out.println("\nIs array empty: " + ArrObj.isEmpty());

        for (int i = 0; i < ArrObj.count(); i++) {
            
            System.out.println("[" + i + "] = " + ArrObj.getValue(i));
        }
        System.out.println("\n\nprogram ends\n");

        System.out.println("Ptr[0] = "+ArrObj.getValue(0));
    }
}

class Array {

    // private int ArrSize;
    private int lastIndex; // holds index of "last filled block"
    private int ptr[];

    public Array(int arrSize) // Constructor of Array class
    {
        lastIndex = -1; // just for declaring an int local variable
        ptr = new int[arrSize];
    }

    public void append(int data) {
        try {

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

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error: "+e.getMessage());
        }

    }

    public void edit(int index, int newData) {
        try {
            if (index < 0 || index > lastIndex) {
                throw new ArrayIndexOutOfBoundsException("Cannot access an invalid index");

            } else {
                ptr[index] = newData; // editing value at an index
              //  lastIndex++;
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
                System.out.println("proof that value at desired index i.e [" + index + "] got deleted: because now ptr[" + index
                        + "]=" + ptr[index]);
                // }
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

}

