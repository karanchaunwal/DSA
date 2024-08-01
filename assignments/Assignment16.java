package assignments;

// import java.util.Arrays;

public class Assignment16 {
    public void driver(){
        
        int arr []=new int[]{3,8,20,4,11,1,2};

        Sort sortObj=new Sort();

        sortObj.printArr(arr);
        // sortObj.bubbleSort(arr);
        // sortObj.modifiedBubbleSort(arr);
       // sortObj.selectionSort(arr);
       sortObj.insertionSort(arr);

        System.out.println("\nAfter Sorting ");
        sortObj.printArr(arr);

    }

}

class Sort{  //Or pre-defined func
            // Arrays.sort(arr);

        public void printArr(int arr[]){
        System.out.print("Arr: [ ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i<arr.length-1){
                System.out.print(", ");
            }
        }
        System.out.print(" ] ");
    }


    public void bubbleSort(int arr[]){
 
        System.out.println("\n\n[Using Bubble Sort]");
        for(int j=0;j<arr.length;j++){ 

            for (int i=0;i<arr.length-1-j;i++){ //for swapping
                
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            
            }
               
        }
        
    }

    public void modifiedBubbleSort(int arr[]){

        System.out.println("\n\n[Using Modified Bubble Sort]");
        for(int j=0;j<arr.length;j++){ 

            int flag=0;//for modifying bubble sort
            for (int i=0;i<arr.length-1-j;i++){ //for swapping
                
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    flag=1;
                }
            }
                if(flag==0){
                    break;
            }
        }     
    }

    public void selectionSort(int arr[]){

        System.out.println("\n\n[Using Selection Sort]");

        for (int i=0;i<arr.length-1;i++){

            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp= arr[min];
            arr[min]=arr[i];
            arr[i]=temp;

        }

        // for(int i=0;i<arr.length-1;i++){
        //     int min=i;

        //     for (int j=i+1;j<arr.length;j++){

        //         if (arr[min]>arr[j]){
        //              min=j;
        //         }
                
        //     }
        //     int temp=arr[min];
        //         arr[min]=arr[i];
        //         arr[i]=temp;
            
        // }

    }


    public void insertionSort(int arr[]){
        System.out.println("\n\n[Using Insertion Sort]");
        for(int i=1;i<arr.length;i++){
            // int temp=i+1;
            int temp=arr[i];
            
            int j=i-1;
            while ( j>=0 && arr[j]>temp) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;

        }
        
    }
    

}






