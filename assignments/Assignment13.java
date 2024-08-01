package assignments;

public class Assignment13 {
    public void driver() {

        Recursion_3 Rec3Obj = new Recursion_3();

        // System.out.println(Rec3Obj.fib_N(2));

        // Rec3Obj.GetBinary(33);
        // Rec3Obj.getBinary(33);

        // Rec3Obj.Get_Octal(9);

       // System.out.println(Rec3Obj.Get_SumOfSquares(4));

       Rec3Obj.Reverse_Number(13295);

    }
}

    class Recursion_3{
    int fib_N(int n) {
        
            if (n > 1) {
                return fib_N(n - 1) + fib_N(n - 2);
             } //else if(n==1)
            //     return 0;
                else 
                return n;

                //or
            // if(n==0 || n==1)
            // return n;
            // return fib_N(n-1) + fib_N(n+2);
    }


    void GetBinary(int n){
        if (n>0){
            GetBinary(n/2);
            System.out.print(n%2);
            
        }
        // else 
        //     System.out.print(n);
    }

//or
    void getBinary(int n){  //(but this function will also give result for n<1 eg: -1,-2, etc )
        if(n>1){
            getBinary(n/2);
            System.out.print(n%2);
        }
        else System.out.print(1);  //also we can do it in above way as [ 1%2 will be = 1 so no need of below else condintion]
    }

    void Get_Octal(int n){
        // if(n>0){
        //     Get_Octal(n/8);
        //     System.out.print(n%8);
        // }

        //or

        if(n>1){  //(but this function will also give result for n<1 eg: -1,-2, etc )
            getBinary(n/8);
            System.out.print(n%8);
        }
        else System.out.print(1); 

    }

    int Get_SumOfSquares(int n){

        if(n>1){
            return Get_SumOfSquares(n-1) + (n*n);
        }
        else return n; //(i.e if n==1)

    }


    void Reverse_Number(int n){
        if(n>0){
            System.out.print(n%10);
            Reverse_Number(n/10);
        }
        
    }





}











